import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Head {

    // Color Constants
    private static final String YELLOW_COLOR = "Yellow";
    private static final String GREEN_COLOR = "Green";
    private static final String RED_COLOR = "Red";
    private static final String RESET = "Try_again";

    // Global Variables
    private static Scanner sc = new Scanner(System.in);
    private static Keyboard keyboard = new Keyboard();
    private static Words Word = new Words();
   
    public static void play() {
        ArrayList<String> guess = new ArrayList<String>();
        String random = Word.chooseWord().toUpperCase();
        keyboard.reset();
        boolean isGo = true;
        int attempts = 0;

        while (isGo) {
            System.out.println("Enter the five-letter word:");
            String input = process(sc);

            // To exit
            if (input.toLowerCase().equals("e") || input.toLowerCase().equals("exit")) {
                isGo = false;
                restart(sc);
                break;
            }
            else if (isValid(input)) {
                guess.add(input); 
                draw(guess, random);

                if (guess.get(attempts).toUpperCase().equals(random)){
                    isGo = false;
                    switch(attempts){
                        case(0):
                            System.out.println("You got it in " + (attempts + 1) + " attempt!");
                            break;
                        default:
                            System.out.println("You got it in " + (attempts + 1) + " attempts!");
                            break;
                    }
                    restart(sc);
                }
                else if (attempts == 5) {
                    isGo = false;
                    System.out.print("You ran out of tries." +  "The word was " + random + "\n");
                    restart(sc);
                    break;
                }
                attempts++;
            } else {
                System.out.println("Not in the dictionary.");
            }
        }
        sc.close();
    }

   
    public static String process(Scanner sn) {
        String s1 = sc.nextLine();
        s1 = s1.trim().toLowerCase();
        return s1;
    }

    
    public static boolean isValid(String input) {
        if (input.length() != 5) {
            System.out.println("The word is not 5 letters!");
            return false;
        }
        return Word.isWord(input);
    }

   
    public static void draw(ArrayList<String> guess, String random){
        for (int i = 0; i < guess.size(); i++) {
            for (int j = 0; j < 5; j++){
                String characterUpper = guess.get(i).substring(j, j+1).toUpperCase();
                String characterLower = guess.get(i).substring(j, j+1).toLowerCase();
                int colorKey = color(random, characterUpper, j);
                switch(colorKey){
                    case 0:
                        keyboard.LetterAndKey.replace(characterLower, 0);
                        System.out.print("[" + characterUpper + "] ");
                        break;
                    case 1:
                        keyboard.LetterAndKey.replace(characterLower, 1);
                        System.out.print("[" + YELLOW_COLOR + characterUpper + RESET + "] ");
                        break;
                    case 2:
                        keyboard.LetterAndKey.replace(characterLower, 2);
                        System.out.print("[" + GREEN_COLOR + characterUpper + RESET + "] ");
                        break;
                    
                }
            }
            System.out.print("\n");
        }
        for (int i = guess.size(); i<6; i++){
            System.out.println("[#] [#] [#] [#] [#]");
        }

        drawKeyboard();
    }

    public static void drawKeyboard(){
        System.out.println("\nKeyboard");
        for (int i = 0; i < 26; i++){
            switch(i){
                case 10:
                     System.out.print("");
                case 19:
                    System.out.print("\n");
            }
            switch(keyboard.LetterAndKey.get(keyboard.alphabet[i].toLowerCase())){
                case 0:
                    System.out.print("[" + RED_COLOR + keyboard.alphabet[i] + RESET + "] ");
                    break;
                case 1:
                    System.out.print("[" + YELLOW_COLOR + keyboard.alphabet[i] + RESET + "] ");
                    break;
                case 2:
                    System.out.print("[" + GREEN_COLOR + keyboard.alphabet[i] + RESET + "] ");
                    break;
                case 3:
                    System.out.print("[" + keyboard.alphabet[i] + "] ");
                    break;
            }
        }
        System.out.print("\n");
    }

    public static int color(String random, String character, int index){
        if (character.equals(random.substring(index, index+1))){
            return 2;
        }
        else {
            for (int i = 0; i < 5; i++) {
                if (character.equals(random.substring(i, i+1))){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void restart(Scanner sc) {
        System.out.println("Do you want to restart? (Yes/No)");
        String response = sc.nextLine().trim().toUpperCase();
        switch(response){
            case "Yes":
                System.out.println("Beginning...");
                play();
                break;
            case "No":
                System.out.println("Leaving...");
                break;
            default:
                System.out.println("Invalid input.");
                restart(sc);
        }
    }

    public static void instructions(){
        File file = new File("Instructions.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
               System.out.println(line);           
            }
        } catch (Exception e) {
            System.out.println("Bug");
        }
    }
}
