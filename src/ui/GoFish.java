package ui;

import javax.swing.*;

public class GoFish extends JFrame {
    public void setVisible(boolean b) {
    }
    public GoFish(){
        //View Code

        JFrame frame = new JFrame("Card Games");

        frame.setSize(340, 320);

        JButton cardDeck = new JButton("Deck");
        //cardDeck.setSize(new Dimension(10, 10));
        //cardDeck.setLocation(10, 30);
        //frame.add(BorderLayout.EAST, cardDeck);
        //Creating the Menu and adding parts to it
        JMenuBar menu = new JMenuBar();
        JMenu gameMenu = new JMenu("GoFish");

        menu.add(gameMenu);

        //Creating the panel at bottom and adding components
        JPanel ask = new JPanel();

        JLabel question = new JLabel("Pick a Card");
        JTextField field = new JTextField(12);
        JButton enter = new JButton("Enter");

        ask.add(question);
        ask.add(field);
        ask.add(enter);

        JPanel panel = new JPanel();
        JButton name = new JButton("Enter Name");
        panel.add(name);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Using BorderLayout
        //frame.add(BorderLayout.SOUTH,ask);

        //frame.add(BorderLayout.NORTH, menu);
    }
}
