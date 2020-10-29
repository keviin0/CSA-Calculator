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

    }

    public void shuffle(){
        Collections.shuffle(cardDeck);
    }



}
