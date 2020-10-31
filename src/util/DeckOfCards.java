package util;
import java.util.ArrayList;
import java.util.Collections;



public class DeckOfCards {
    public DeckOfCards() { //initialize the deck
        ArrayList<Card> cardDeck = new ArrayList<Card>();

        int y = 52;
        String[] types = {"Diamond", "Club", "Heart", "Spade"};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] myDeck = new String[y];
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < types.length; j++) {
                myDeck[types.length * i + j] = ranks[i] + types[j];
            }
        }
    }
}


