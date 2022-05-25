import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener{

    JButton button;

    Frame(){

        JButton button = new JButton();
        button.setBounds(200, 100, 100, 50);
        button.addActionListener(e -> System.out.println("hey"));

        JPanel rdPanel = new JPanel();
        rdPanel.setBackground(Color.gray);
        rdPanel.setBounds(10, 10, 72, 72);
        // redPanel.setLayout(new BorderLayout());

        JPanel bluPanel = new JPanel();
        bluPanel.setBackground(Color.gray);
        bluPanel.setBounds(92, 10, 72, 72);


        JLabel label = new JLabel();
        label.setText("Wordle");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        loadRowsAndColumns(this);

        this.setBackground(Color.green);
        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        // redPanel.add(label);
        this.add(rdPanel);
        this.add(bluPanel);
        this.add(button);
    }

    public void loadRowsAndColumns(JFrame frame){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("hi");
        }
        
        
    }

    
}
