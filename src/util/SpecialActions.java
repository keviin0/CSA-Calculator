package util;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class SpecialActions {
    int round;
    Player mActivePlayer;
    Deck mActiveDeck;
    ArrayList<Player> mPlayers = new ArrayList<Player>();
    Card mTopPileCard;
    Actions actions;
    Card resultCard;
    Card moveStatus;
    Card tempCard = new Card(Color.BLUE, 2);

    public SpecialActions(Deck d, ArrayList<Player> p, Card c){
        this.round = 0;
        this.mPlayers = p;
        this.mActivePlayer = mPlayers.get(0);
        this.mActiveDeck = d;
        this.mTopPileCard = c;
        this.moveStatus = tempCard;
    }

    public Card topCardReturn(){
        return Actions.peek(mActiveDeck);//mActiveDeck.cardDeck.get(0);
    }

    public String execute(Card cardFromTop, Actions.ACTIONS action, Card gamePileTopCard){
        if( cardFromTop == null ) {
            // no card selected
            return "invalid move";
        }

        resetStatus();
        if (cardFromTop.getColor() == Card.SPECIAL_COLOR) {

            if (cardFromTop.getCardNum() == Card.REVERSE_CARD) {
                action = Actions.ACTIONS.REVERSE;
            } else if (cardFromTop.getCardNum() == Card.SKIP_CARD) {
                action = Actions.ACTIONS.SKIP;
            } else if (cardFromTop.getCardNum() == Card.DRAW_TWO_CARD) {
                action = Actions.ACTIONS.DRAWTWO;
            }
        }


        // Skip card case
        if (action == Actions.ACTIONS.SKIP){
            Actions.doAction(action, mActivePlayer, 2, mActiveDeck, cardFromTop, gamePileTopCard);
            // Skips to next player
            round++;
            mActivePlayer = mPlayers.get(round % mPlayers.size());
            String skippedPlayer = mActivePlayer.getName();
            // skips their turn
            round++;
            mActivePlayer = mPlayers.get(round % mPlayers.size());

            return "skipping player " + skippedPlayer;

        }

        // Reverse card case
        if (action == Actions.ACTIONS.REVERSE){
            moveStatus = Actions.doAction(action, mActivePlayer, 2, mActiveDeck, cardFromTop, gamePileTopCard);
            if (moveStatus.getSuccess() == false) {
                round = round - 1;
                return "invalid move";
            }
            Collections.reverse(mPlayers);
            round++;
            mActivePlayer = mPlayers.get(round % mPlayers.size());
        }

        // draw two case
        if (action == Actions.ACTIONS.DRAWTWO){

            // place down draw two card
            action = Actions.ACTIONS.PLACE;
            moveStatus = Actions.doAction(action, mActivePlayer, 1 , mActiveDeck, cardFromTop, gamePileTopCard);

            // switch to other player
            String activePlayerTemp = mActivePlayer.name;
            round++;
            mActivePlayer = mPlayers.get(round % mPlayers.size());

            // draws 2 for player
            action = Actions.ACTIONS.DRAWTWO;
            moveStatus = Actions.doAction(action, mActivePlayer, 2, mActiveDeck, cardFromTop, gamePileTopCard);
            if (moveStatus.getSuccess() == false) {
                round = round - 1;
                return "invalid move";
            }
            System.out.println(round + "\n" + mActivePlayer.name + " card " + cardFromTop.getDescription());

            return activePlayerTemp + " used draw 2 cards";

        }

        // draw case
        if (action == Actions.ACTIONS.DRAW) {
            moveStatus = Actions.doAction(action, mActivePlayer, 1, mActiveDeck, cardFromTop, gamePileTopCard);
            System.out.println(round + "\n" + mActivePlayer.name + " card " + cardFromTop.getDescription());

            round++;
            String activePlayerTemp = mActivePlayer.name;
            mActivePlayer = mPlayers.get(round % mPlayers.size());
            return activePlayerTemp + " has drawn card";
        }
        // place case
        if (action == Actions.ACTIONS.PLACE){

            moveStatus = Actions.doAction(action, mActivePlayer, 1 , mActiveDeck, cardFromTop, gamePileTopCard);

            if (moveStatus.getSuccess() == false) {
                round = round - 1;
                return "invalid move";
            }
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

    public int getRound(){
        return round;
    }

    public Player getActivePlayer(){
        return mActivePlayer;
    }

    public ArrayList getPlayers(){
        return mPlayers;
    }

    public Card getResultCard() {return resultCard;}

    public void resetStatus() {
        moveStatus.setSuccess(true);
    }

    public boolean getStatus() {
        return moveStatus.getSuccess();
    }

}
