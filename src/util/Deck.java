package util;

import java.util.ArrayList;
import java.util.Collections;

import util.Card.COLOR;

public class Deck {

    public ArrayList<Card> cardDeck = new ArrayList<Card>();

    public Deck(){ //initialize the deck

        COLOR colors[] = COLOR.values();
        for(COLOR c: colors) {
            if (c == COLOR.SPECIAL) { //Special cards that don't use 0-12
                for (int i = 0; i < 2; i++) { // 4 of each
                    cardDeck.add(new Card(c, i));
                    cardDeck.add(new Card(c, i));
                    cardDeck.add(new Card(c, i));
                    cardDeck.add(new Card(c, i));
                }
            } else {
                cardDeck.add(new Card(c, 0)); //Only one 0 of each color
                for (int j = 0; j < 2; j++) { //Two of every other card for a color
                    for (int i = 1; i < 13; i++) {
                        cardDeck.add(new Card(c, i));
                    }
                }
            }
        }

        //public void Player(){
        //myCards = new ArrayList<Cards>(52);
        //Need to create new file called cards
        /*int y = 52;
        String[]types = {"Diamond", "Club", "Heart", "Spade"};
        int[]numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,};
        String[]ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[]Deck = new String[y]
            for(int i = 0; i < ranks.length; i++){
                for(int j = 0; j < types.length; j++){
                    deck[types.length*i + j] = Ranks[i] + types[j]

                }
            }
            Note: The commented CardDeck was a CardDeck Siddhant Ranka created. However, Kevin's deck worked better

         */

    }

    public void shuffle(){
        Collections.shuffle(cardDeck);
    }



}
