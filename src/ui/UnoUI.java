package ui;

import util.Deck;
import util.Player;
import util.Card;

public class UnoUI {

    boolean actionSuccess;

    public UnoUI(){

        Deck test = new Deck();
        //System.out.println(test.cardDeck);
        test.shuffle();
        //System.out.println(test.cardDeck);
        Player testPlayer = new Player("monkaS");

    }

    public void action(Player p, Card t){
        while(true){
            actionSuccess = true;

            //TODO: Display active player(p)'s hand and show card on top of deck(t). Add button on a deck to draw a card or press a card to place a card. Have callback call either drawCard or playCard in Playfield.
            if(actionSuccess = false){ //Invalid move check
                invalid();
                continue;
            }
            break;
        }

    }

    public boolean invalid(){
        //TODO: add invalid move prompt
        return false;
    }

}
