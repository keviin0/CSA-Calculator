package util;

import ui.UnoUI;

import java.util.ArrayList;
import java.util.List;
import util.Actions;

public class Playfield {
    public Card topCard;
    public int round = 0;
    public Player actPlayer; //active player
    public ArrayList<Player> players = new ArrayList<Player>();
    public static boolean actionSuccess;

    public Playfield(int playerNum, List<String> names){ //Initialize playfield

        Deck test = Actions.newDeck();
        topCard = Actions.pop(test);
        System.out.println(topCard.getLabel());
        addPlayers(playerNum, names);

        for(int i = 0; i < playerNum; i++){ //Start each player with 7 cards
            for(int j = 0; j < 7; j++){
                players.get(i).hand.add(Actions.pop(test));
            }
        }

        actPlayer = players.get(round % playerNum); //Set first active player
        topCard = Actions.getTopCard(); //Set first top card
        UnoUI gameWindow = new UnoUI(actPlayer, topCard, test, players); //Start game
        gameWindow.setVisible(true); //Make UnoUI visible

    }

    public void addPlayers(int numPlayers, List<String> args) { //Add players to players arraylist
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player(args.get(i)));
        }
    }

}
