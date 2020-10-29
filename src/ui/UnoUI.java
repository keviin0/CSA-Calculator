package ui;

import util.Deck;
import util.Player;
import util.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UnoUI extends JFrame{

    boolean actionSuccess;
    private JPanel mainPanel;
    private JPanel testPanel;
    private JPanel cardsPanel;
    private JButton mDrawCard;
    private JButton mPlaceCard;
    private JLabel mTopDeckCard;

    private int testNumberCards = 7;
    private ArrayList<JButton> testButtons = new ArrayList();

    /**
     * Launch the application.
     */

    /*
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UnoUI frame = new UnoUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    */

    // constructor
    public UnoUI(){

        getContentPane().setBackground(new Color(250, 200, 250));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 418, 315);
        setContentPane(mainPanel);


        Deck test = new Deck();
        //System.out.println(test.cardDeck);
        test.shuffle();
        //System.out.println(test.cardDeck);
        Player testPlayer = new Player("monkaS");


        mDrawCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Player has drawn card");

                ++testNumberCards;
                JButton newButton = new JButton(String.valueOf(testNumberCards));

                newButton.setBounds(50,50,90, 50);

                cardsPanel.add(newButton, new GridBagConstraints());
                if(testButtons == null) {
                    testButtons = new ArrayList();
                }
                testButtons.add(newButton);


            }
        });

        mPlaceCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Player has place card");

            }
        });


    }

    public void updateTopCard(Card c){
        mTopDeckCard.setText(c.cardColor + " " + c.cardNum + ":"); //TODO: Put current top card here

    }

    public void action(Player p, Card t){
        while(true){
            actionSuccess = true;
            updateTopCard(t);

            //TODO: Display active player(p)'s hand and show card on top of deck(t). Add button on a deck to draw a card or press a card to place a card. Have callback call either mDrawCard or playCard in Playfield.
            if(actionSuccess = false){ //Invalid move check
                invalid();
                continue;
            }
            break;
        }

    }

    public boolean invalid(){
        //TODO: add invalid move prompt
        JOptionPane.showMessageDialog(null, "Invalid move");

        return false;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
