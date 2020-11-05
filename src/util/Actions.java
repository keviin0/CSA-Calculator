package util;

public class Actions {

    public static enum ACTIONS {DRAW, PLACE, SKIP, REVERSE, DRAWTWO}
    public static Card topCard;

    public static Card pop(Deck d){
        Card result = d.cardDeck.get(0);
        d.cardDeck.remove(0);
        return result;
    }

    public static Card topCardReturn(Deck d){
        return d.cardDeck.get(0);
    }

    public static Card push(Player p, Card selected){
        int index = 0;
        System.out.println(p.getName());
        for(int i = 0; i < p.getSize(); i++) {
            if (p.getHand().get(i).getColor() == selected.getColor()) {
                if (p.getHand().get(i).getCardNum() == selected.getCardNum()) {
                    index = i;
                    break;
                }
            }
        }
        topCard = p.getHand().get(index);
        p.removeCard(selected);
        return topCard;
    }

    public static Deck newDeck(){
        Deck test = new Deck(); //Create deck
        //System.out.println(test.cardDeck);
        test.shuffle();
        //System.out.println(test.cardDeck);
        return test;
    }

    public static Card getTopCard(){
        return topCard;

    }

    public static Card doAction(ACTIONS choice, Player p, int num, Deck d, Card c, Card topCard){
        switch(choice){
            case DRAW:
                for(int i = 0; i < num; i++){
                    p.addCard(pop(d));
                }
                return c;
            case PLACE:
                if(topCard.getColor() != c.getColor()){ //Check if card is unable to be played
                    if(topCard.getCardNum() == c.getCardNum()){
                        return c;
                    }
                }
                push(p, c);
                return c;
            case SKIP:
                return c;
            case REVERSE:
                return c;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }


    }
}
