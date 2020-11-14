package ui;

import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import util.Actions.ACTIONS;

public class UnoUI extends JFrame{

    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel cardsPanel;
    private JButton button1;
    private JButton button7;
    private JButton button6;
    private JButton button4;
    private JButton button3;
    private JButton button8;
    private JButton button9;
    private JButton button2;
    private JButton button10;
    private JButton button5;
    private JButton mDrawCardButton;
    private JButton mPlaceCardButton;
    private JButton mTopCardButton;
    private JLabel mCurrentPlayerLabel;
    private JButton mPileButton;
    private JLabel mGamePile;
    private Player placeholder = new Player("placeholder");

    private ACTIONS action;

    private Player mActivePlayer = new Player("test");
    private Deck mActiveDeck;
    private Card mUselessCard = new Card(Color.BLUE, -1);
    private Card tempCard= new Card(Color.BLUE, -1);
    public int round = 0;
    private ArrayList<Player> mPlayers = new ArrayList<Player>();
    private Card mTopCard;
    private ArrayList<JButton> mCardButtons;
    private SpecialActions model;
    private static final Color DEFAULT_COLOR = Color.white;

    /**
     * Launch the application.
     */

    public void specialAction(Card cardFromTop)
    {
        String output = model.execute(cardFromTop, action);
        JOptionPane.showMessageDialog(null, output);
        round = model.getRound();
        mActivePlayer = model.getActivePlayer();
        updateActivePlayer(mActivePlayer);
    }

    public UnoUI(Player currentPlayer, Card topCard, Deck deck, ArrayList<Player> players){
        createUIComponents();

        model = new SpecialActions(deck, players, topCard);
        /*
        mActiveDeck = deck;
        mPlayers =  players;

        // Update the top card
        mTopCard = topCard;


         */
        // update pile
        updateGamePile(mTopCard);

        // Display active player(p)'s hand
        updateActivePlayer(currentPlayer);
        System.out.println(mActivePlayer);
        // Handle the draw card action and handle the
        // place card actions
        mDrawCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action = ACTIONS.DRAW;
                updateTopCard(mTopCard);
                specialAction(mTopCard);
                Card nextCard = model.topCardReturn();
                updateTopCard(nextCard);

            }
        });

        mPlaceCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action = ACTIONS.PLACE;
                //updateTopCard();
                //TODO: to be implemented

                specialAction(mTopCard);
            }
        });

        //TODO: Add card selection handling

    }
    //method is used for player objects
    //method purpose is to update current active player's hand and name
    private void updateActivePlayer(Player p) {
        mActivePlayer = p;

        // First clear and reset the current hand
        // to update the cards view
        clearHand();

        for(int i = 0; i < mActivePlayer.getHand().size(); ++i ) {
            Card card = mActivePlayer.getHand().get(i);
            JButton cardButton = mCardButtons.get(i);

            // update the card display

            cardButton.setEnabled(true);
            cardButton.setVisible(true);
            cardButton.setBackground(card.getColor());
            cardButton.setText(card.getLabel());

            // Update text color
            cardButton.setForeground(card.isSpecialCard() ? Color.white : Color.black);


        }

        mCurrentPlayerLabel.setText(mActivePlayer.name);
        System.out.println(mActivePlayer.getHand());
    }

    private void updateTopCard(Card c){
        if( c == null ) {
            c = mUselessCard;
        }
        mTopCard = c;
        mTopCardButton.setText(c.getLabel());
        mTopCardButton.setBackground(c.getColor());

        // Update text color
        mTopCardButton.setForeground(c.isSpecialCard() ? Color.white : Color.black);
    }

    private void updateGamePile(Card c){
        if( c == null ) {
            c = mUselessCard;
        }

        mPileButton.setText(c.getLabel());
        mPileButton.setBackground(c.getColor());


        // Update text color
        mGamePile.setForeground(c.isSpecialCard() ? Color.white : Color.black);
    }

    public void invalid(){
        JOptionPane.showMessageDialog(null, "Invalid move");
    }


    private void createUIComponents() {
        getContentPane().setBackground(new Color(250, 200, 250));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        setContentPane(mainPanel);

        mCardButtons = new ArrayList<>();

        mCardButtons.add(button1);
        mCardButtons.add(button2);
        mCardButtons.add(button3);
        mCardButtons.add(button4);
        mCardButtons.add(button5);
        mCardButtons.add(button6);
        mCardButtons.add(button7);
        mCardButtons.add(button8);
        mCardButtons.add(button9);
        mCardButtons.add(button10);

        clearHand();

        // Set top deck as useless card.
        // It should not be clickable.
        mTopCardButton.setEnabled(false);
        mTopCardButton.setVisible(true);
        mTopCardButton.setBackground(mUselessCard.getColor());
        mTopCardButton.setText(mUselessCard.getLabel());

        mCurrentPlayerLabel.setText("");
    }

    private void clearHand() {
        // Hide and disable card buttons
        for(JButton button : mCardButtons) {
            button.setEnabled(false);
            button.setVisible(false);
            button.setText("");
            button.setBackground(DEFAULT_COLOR);
        }
    }
}
