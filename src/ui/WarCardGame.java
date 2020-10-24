package ui;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class WarCardGame extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                WarCardGame frame = new WarCardGame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private final JLabel TestLabel = new JLabel("");
    ArrayList<String> Cards = new ArrayList<String>();
    public WarCardGame(){
        getContentPane().setBackground(new Color(250, 200, 250));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 418, 315);
        getContentPane().setLayout(null);
        TestLabel.setForeground(Color.WHITE);
        boolean justPlayed = false;
        String[]types = {"Diamond", "Club", "Heart", "Spade"};
        int[]numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,};
        String[]ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};


    }
    public void Player(){
        //myCards = new ArrayList<Cards>(52);
        //Need to create new file called cards
        /*int y = 52;
        String[]Deck = new String[y]
            for(int i = 0; i < ranks.length; i++){
                for(int j = 0; j < types.length; j++){
                    deck[types.length*i + j] = Ranks[i] + types[j]
                }
            }


         */

    }
    public void setVisible(boolean b) {
    }
}
/*Note: I have a lot of comments right now because I did not have enough time to add this to a new file and I am using
comments for this code because my errors will create "rubber chickens" in the entire project for my group.
public class Cards{
    public Cards(){

 */

