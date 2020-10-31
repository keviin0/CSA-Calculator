package ui;

import util.APIRequest;
import util.Playfield;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        super("Uno");
        setBounds(100, 100, 418, 315);
        Container c = getContentPane();
        JPanel p = new JPanel();
        JButton b = new JButton("Submit"); //Submit button
        List<String> allMatches = new ArrayList<String>();


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        numPlayers = new JTextArea("# of players",1, 10); //Initial setting for # of players
        p.add(numPlayers); //Add text area for year to panel
        playerNames = new JTextArea("Names of each player (Separated by comma)",1, 10);//Initial setting for names of players separated by commas
        p.add(playerNames); //Add text area for season to panel
        p.add(b); //Add button to panel
        c.add(p); //add panel to container

        b.addActionListener(e -> {
            int tempNum = Integer.parseInt(numPlayers.getText());
            Matcher m = Pattern.compile("[^,]+")
                    .matcher(playerNames.getText());
            while (m.find()) {
                allMatches.add(m.group());
            }
           new Playfield(tempNum, allMatches);
        });

    }
}
