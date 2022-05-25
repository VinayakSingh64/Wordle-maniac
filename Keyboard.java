import java.util.*;

public class Keyboard {
    Hashtable<String, Integer> LetterAndKey = new Hashtable<String,Integer>();
    String[] alphabet = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
    "A", "S", "D", "F", "G", "H", "J", "K", "L",
    "Z", "X", "C", "V", "B", "N", "M"};

    public Keyboard() {
        reset();
    }

    public void reset() {
    	LetterAndKey.put("a", 3);
    	LetterAndKey.put("b", 3);
    	LetterAndKey.put("c", 3);
    	LetterAndKey.put("d", 3);
    	LetterAndKey.put("e", 3);
    	LetterAndKey.put("f", 3);
    	LetterAndKey.put("g", 3);
    	LetterAndKey.put("h", 3);
    	LetterAndKey.put("i", 3);
    	LetterAndKey.put("j", 3);
    	LetterAndKey.put("k", 3);
    	LetterAndKey.put("l", 3);
    	LetterAndKey.put("m", 3);
    	LetterAndKey.put("n", 3);
    	LetterAndKey.put("o", 3);
    	LetterAndKey.put("p", 3);
    	LetterAndKey.put("q", 3);
    	LetterAndKey.put("r", 3);
    	LetterAndKey.put("s", 3);
    	LetterAndKey.put("t", 3);
    	LetterAndKey.put("u", 3);
    	LetterAndKey.put("v", 3);
    	LetterAndKey.put("w", 3);
    	LetterAndKey.put("x", 3);
    	LetterAndKey.put("y", 3);
    	LetterAndKey.put("z", 3);
    }
    
}
