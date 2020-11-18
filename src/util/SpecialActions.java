package util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;


public class SpecialActions {
    int round;
    Player mActivePlayer;
    Deck mActiveDeck;
    ArrayList<Player> mPlayers = new ArrayList<Player>();
    Card mTopCard;
    Actions actions;
    Card resultCard;

    public SpecialActions(Deck d, ArrayList<Player> p, Card c){
        this.round = 0;
        this.mPlayers = p;
        this.mActivePlayer = mPlayers.get(0);
        this.mActiveDeck = d;
        this.mTopCard = c;
    }

    public Card topCardReturn(){
        return mActiveDeck.cardDeck.get(0);
    }

    public String execute(Card cardFromTop, Actions.ACTIONS action, Card mTopCard){
        if (cardFromTop.getColor() == Card.SPECIAL_COLOR){
                JOptionPane.showMessageDialog(null, "Pick a color");
        } else if (cardFromTop.getCardNum() == 10){
            action = Actions.ACTIONS.REVERSE;
        } else if  (cardFromTop.getCardNum() == 12){
            action = Actions.ACTIONS.SKIP;
        } else if  (cardFromTop.getCardNum() == 11){
            action = Actions.ACTIONS.DRAWTWO;
        }
        // Skip card case
        if (action == Actions.ACTIONS.SKIP){
            round++;
            round++;
            mActivePlayer = mPlayers.get(round % mPlayers.size());
            // Reverse card case
        } else if (action == Actions.ACTIONS.REVERSE){
            Collections.reverse(mPlayers);
            round++;
            mActivePlayer = mPlayers.get(round % mPlayers.size());
            // Draw two case
        } else if (action == Actions.ACTIONS.DRAWTWO){
            Actions.doAction(action, mActivePlayer, 2, mActiveDeck, cardFromTop, mTopCard);
            System.out.println(round + "\n" + mActivePlayer.name + " card " + cardFromTop.getDescription() );
            if(mActivePlayer.getHand().isEmpty()) {
                round++;
                mActivePlayer = mPlayers.get(round % mPlayers.size());
                return "Winner";
            }
            if(mActiveDeck.cardDeck.isEmpty()){
                mActiveDeck = Actions.newDeck();
            }
            round++;
            mActivePlayer = mPlayers.get(round % mPlayers.size());
            //mActivePlayer.addCard(mTopCard);
        }
        // draw case
        if (action == Actions.ACTIONS.DRAW) {
            Actions.doAction(action, mActivePlayer, 1, mActiveDeck, cardFromTop, mTopCard);
            System.out.println(round + "\n" + mActivePlayer.name + " card " + cardFromTop.getDescription());
            round++;
            String activePlayerTemp = mActivePlayer.name;
            mActivePlayer = mPlayers.get(round % mPlayers.size());
            return activePlayerTemp + " has drawn card";
        }
        // place case
        if (action == Actions.ACTIONS.PLACE){
            Actions.doAction(action, mActivePlayer, 1 , mActiveDeck, cardFromTop, mTopCard);
            System.out.println(round + "\n" + mActivePlayer.name + " card " + cardFromTop.getDescription());
            round++;
            String activePlayerTemp = mActivePlayer.name;
            mActivePlayer = mPlayers.get(round % mPlayers.size());
            return activePlayerTemp + " has placed card";
        }
        if(mActivePlayer.getHand().isEmpty()) {
            return "Winner";
        }
        if(mActiveDeck.cardDeck.isEmpty()){
            mActiveDeck = Actions.newDeck();
        }


        return "error";
    }

    public void setDeck(Deck d){
        mActiveDeck = d;
    }

    public  int getRound(){
        return round;
    }

    public Player getActivePlayer(){
        return mActivePlayer;
    }

    public ArrayList getPlayers(){
        return mPlayers;
    }

    public Card getResultCard() {return resultCard;}

}
