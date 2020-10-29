package util;

import ui.UnoUI;

import java.util.ArrayList;

public class Playfield {
    Card topCard;
    int round = 0;
    Player actPlayer; //active player
    ArrayList<Player> players = new ArrayList<Player>();
    boolean actionSuccess;

    public Playfield(int playerNum, String[] names, UnoUI gameView){ //Initialize playfield

        Deck test = new Deck();
        //System.out.println(test.cardDeck);
        test.shuffle();
        //System.out.println(test.cardDeck);
        topCard = pop(test);
        addPlayers(playerNum, names);

        for(int i = 0; i < playerNum; i++){ //Start each player with 7 cards
            for(int j = 0; j < 7; j++){
                players.get(i).hand.add(pop(test));
            }
        }

        while(true){
            actPlayer = players.get(round % (playerNum - 1));
            gameView.action(actPlayer, topCard);

            if (actPlayer.hand.isEmpty()) {
                //UnoUI.win(actPlayer); //TODO: Create winner prompt in UnoUI
                break;
            }
            round++;
            continue;
        }

    }


    public Card pop(Deck d){
        Card result = d.cardDeck.get(0);
        d.cardDeck.remove(0);
        return result;
    }

    public void push(Player p, Card selected){
        int index = 0;
        for(int i = 0; i < p.hand.size(); i++){
            if (p.hand.get(i).cardColor == selected.cardColor){
                if (p.hand.get(i).cardNum == selected.cardNum){
                    index = i;
                    break;
                }
            }
        }
        topCard = p.hand.get(index);
        p.hand.remove(selected);
    }

    public void addPlayers(int numPlayers, String[] args) {
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player(args[i]));
        }
    }

    public boolean drawCard(Player p, int num, Deck d) { //draws num amount of cards into activePlayer(p)'s hand from passed in deck
        for(int i = 0; i < num; i++){
            p.hand.add(pop(d));
        }
        return true;
    }

    public boolean playCard(Card c, Card t) { //c is card to be placed, t is top card
        if(c.cardColor == Card.COLOR.SPECIAL){
            //
        }
        if(topCard.cardColor != c.cardColor){ //Check if card is unabled to be played
            if(topCard.cardNum == c.cardNum){
                return false;
            }
        }

        push(actPlayer, c);
        return true;


    }
}
