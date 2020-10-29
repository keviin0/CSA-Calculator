package ui;

import util.APIRequest;
import util.Playfield;

import javax.swing.*;
import java.awt.*;

public class Uno extends JFrame {

    private JTextArea numPlayers; //Text input for number of players
    private JTextArea playerNames; //Text input for names of each player
    private static String ENTER = "Enter"; //Submit button

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Uno frame = new Uno();
                frame.setSize(300,300);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Uno(){
        Container c = getContentPane();
        JPanel p = new JPanel();
        JButton b = new JButton("Submit"); //Submit button

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        numPlayers = new JTextArea("# of players",1, 10);
        p.add(numPlayers); //Add text area for year to panel
        playerNames = new JTextArea("Names of each player",1, 10);
        p.add(playerNames); //Add text area for season to panel
        p.add(b); //Add button to panel
        c.add(p); //add panel to container

        b.addActionListener(e -> {
            int tempNum = Integer.parseInt(numPlayers.getText());
            String[] names = new String[0];
            names[0] = playerNames.getText();
            UnoUI gameWindow = new UnoUI();
            new Playfield(tempNum, names, gameWindow);
        });
        //TODO: Throw custom exception if not a valid season or year.

    }
}
