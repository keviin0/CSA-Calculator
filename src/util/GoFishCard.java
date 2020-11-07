package util;

import java.util.ArrayList;
import java.util.Random;

public class GoFishCard {
    public GoFishCard() {

        ArrayList<String> cardDeck = new ArrayList<String>();

        String[] suites = {"Diamond", "Spade", "Club", "Heart"};
        String[] values = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                "Nine", "Ten", "Jack", "Queen", "King"};

    }

    private String[] card(String[] suites, String[] values) {


        for (int i = 0; i <= 4; i++) ;
        for (int j = 0; j <= 13; j++) ;
        String[] card = card(suites, values);

        return card;
    }

    private int shuffle() {
        int n = 52;
        return shuffle();
    }
    private boolean player(){
        boolean player = true;
        return true;
    }
}
