package util;

import java.util.ArrayList;

public class Player {

    public String name;
    public int numCards;
    public ArrayList<Card> hand = new ArrayList<Card>();

    public Player(String newName){
        this.name = newName;
    }



}
