package util;

public class Card {

    public enum COLOR{ //Color of each card. Special for wildcards
        BLUE, RED, GREEN, YELLOW, SPECIAL
    }

    public COLOR cardColor;
    public int cardNum; //0-9, 10 for reverse, 11 for draw 2, 12 for skip

    public Card(COLOR c, int n){
        this.cardColor = c;
        this.cardNum = n;
    }


}
