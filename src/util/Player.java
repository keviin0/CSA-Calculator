package util;

import java.util.ArrayList;

public class Player {

    public String name; //Player's name
    public int numCards; //Number of cards player has
    public ArrayList<Card> hand = new ArrayList<Card>(); //The player's hand

    public Player(String newName){
        this.name = newName;
    }



}
