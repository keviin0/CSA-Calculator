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

        Deck test = new Deck();
        //System.out.println(test.cardDeck);
        test.shuffle();
        //System.out.println(test.cardDeck);
        topCard = Actions.pop(test);
        addPlayers(playerNum, names);

        for(int i = 0; i < playerNum; i++){ //Start each player with 7 cards
            for(int j = 0; j < 7; j++){
                players.get(i).hand.add(Actions.pop(test));
            }
        }

        actPlayer = players.get(round % (playerNum - 1));
        topCard = Actions.getTopCard();
        UnoUI gameWindow = new UnoUI(actPlayer, topCard, test, players);
        gameWindow.setVisible(true);

    }

    public void addPlayers(int numPlayers, List<String> args) {
        for(int i = 0; i < numPlayers; i++){
            players.add(new Player(args.get(i)));
        }
    }

}
