package ui;

import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import util.Actions.ACTIONS;

import util.Playfield.*;

public class UnoUI extends JFrame{

    volatile boolean actionSuccess;
    private JPanel mainPanel;
    private JPanel testPanel;
    private JPanel cardsPanel;
    private JButton mDrawCard;
    private JButton mPlaceCard;
    private JLabel mTopDeckCard;
    private ACTIONS action;
    private Card c;
    private Player activePlayer;
    private Deck activeDeck;
    private int num = 0;
    private Card useless = new Card(Card.COLOR.BLUE, 0);
    public int round = 0;
    private ArrayList<Player> players = new ArrayList<Player>();

    private int testNumberCards = 7;
    private ArrayList<JButton> testButtons = new ArrayList();

    /**
     * Launch the application.
     */


    // constructor
    private void performAction(){ //method to perform action
        System.out.println(round + "\n" + activePlayer.name);
        Actions.doAction(action, activePlayer, num, activeDeck, c);
        if(activePlayer.hand.isEmpty()) {
            //UnoUI.win(actPlayer); //TODO: Create winner prompt in UnoUI
        }
        if(activeDeck.cardDeck.isEmpty()){
            activeDeck = Actions.newDeck();
        }
        round++;
        activePlayer = players.get(round % players.size());
        updateActivePlayer(activePlayer);

    }

    private void updateActivePlayer(Player p){ //method to update current active player's hand

    }

    public UnoUI(Player p, Card t, Deck d, ArrayList<Player> z){

        getContentPane().setBackground(new Color(250, 200, 250));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 418, 315);
        setContentPane(mainPanel);

        activeDeck = d;
        players =  z;
        activePlayer = p;

        mDrawCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action = ACTIONS.DRAW;
                num = 1;
                c = useless;
                performAction();
                JOptionPane.showMessageDialog(null, activePlayer.name + " has drawn card");

            }
        });

        mPlaceCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action = ACTIONS.PLACE;

                JOptionPane.showMessageDialog(null, "Player has place card");

            }
        });
        //TODO: Display active player(p)'s hand and show card on top of deck(t). Add button on a deck to draw a card or press a card to place a card. Have callback call either mDrawCard or playCard in Playfield.


    }

    public void updateTopCard(Card c){
        mTopDeckCard.setText(c.cardColor + " " + c.cardNum + ":"); //TODO: Put current top card here

    }


    public void invalid(){
        //TODO: add invalid move prompt
        JOptionPane.showMessageDialog(null, "Invalid move");

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
