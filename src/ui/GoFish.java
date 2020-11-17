package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//creates class GoFish that stores all the methods, constructors, view codes, and datatypes used to execute the code.
public class GoFish extends JFrame{

    public static Container frameContainer;
    public static int numberOfCards = 10;
    public static ArrayList<Integer> newDeck = null;
    public static ArrayList<Integer> gameDeck = null;
    public static ArrayList<Integer> pickDeck = null;

    public static JButton deckButton = null;
    public static JTextField playerCardNumbers = new JTextField(20);


    public static JButton drawCardButton = null;
    public static JTextField inputCardField = new JTextField(20);
    public static JLabel winLooselabel = new JLabel();


    //control code
    void compareCard() {
        boolean isTrue = false;

        int cardValue = Integer.parseInt(inputCardField.getText());
        System.out.printf("You picked : %s\n",cardValue);

        isTrue = pickDeck.contains(cardValue);

        //if player picked right card
        if (isTrue) {
            System.out.println("you picked correct card");
            cardValue = gameDeck.get(0);
            pickDeck.add(cardValue);
            gameDeck.remove(gameDeck.indexOf(cardValue));

            System.out.printf("Contents of game deck (player has): %s \n", gameDeck);
            playerCardNumbers.setText(String.valueOf(gameDeck));
            System.out.printf("Contents of pick deck : %s\n", pickDeck);


            if (gameDeck.isEmpty()) {
                System.out.println("you won the game");
                winLooselabel.setText("you won the game");

            }
        }
        //if player picked wrong card
        else {
            System.out.println("you picked wrong card, draw again");

            cardValue = pickDeck.get(0);
            gameDeck.add(cardValue);
            pickDeck.remove(pickDeck.indexOf(cardValue));
            System.out.printf("Contents of game deck (player has): %s\n",gameDeck);
            playerCardNumbers.setText(String.valueOf(gameDeck));
            System.out.printf("Contents of pick deck : %s\n",pickDeck);

            if (pickDeck.isEmpty()) {
                System.out.println("you lost the game");
                winLooselabel.setText("you lost the game");

            }
        }
        System.out.println("Exiting while loop");
    }

    void handleEnterKeyPressForInputCardField() {
        inputCardField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    compareCard();
                    inputCardField.setText("");
                }
            }

        });
    }

    public static ArrayList<Integer> createDeck(int numberOfCards) {
        ArrayList<Integer> newDeck = new ArrayList<Integer>();
        for(int i=0; i < numberOfCards; i++) {
            newDeck.add(i);
        }
        return newDeck;
    }

    //Button for Deck
    void initiateDeckButton() {
        deckButton = new JButton("Start Game");
        deckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newDeck = createDeck(numberOfCards);
                Collections.shuffle(newDeck);

                gameDeck = new ArrayList<>();
                for (int i = 0; i < numberOfCards / 2; i++)
                    gameDeck.add(newDeck.get(i));
                System.out.printf("Contents of game deck (player has): %s\n", gameDeck);

                pickDeck = new ArrayList<>();
                for (int i = numberOfCards / 2; i < numberOfCards; i++)
                    pickDeck.add(newDeck.get(i));
                System.out.printf("Contents of pick deck : %s\n", pickDeck);

                //set the text field
                playerCardNumbers.setText(gameDeck.toString());
          }
        });
    }


    //text field for input
    //Text field to show card

    //view code
    //constructor
    public GoFish() {
        JFrame aWindow = new JFrame("GoFish");
        aWindow.setBounds(100, 100, 418, 315);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        FlowLayout flow = new FlowLayout(); // Create a layout manager
        flow.setHgap(5);                   // Set the horizontal gap
        flow.setVgap(5);
        flow.setAlignment(FlowLayout.CENTER);
        Container content = aWindow.getContentPane(); // Get the content pane
        content.setLayout(new GridLayout(2,2,10,10));

        content.setLayout(flow); // Set the container layout mgr

        initiateDeckButton();
        content.add(deckButton);
        //we already initialize during declaration
        playerCardNumbers.setEditable(false);
        content.add(playerCardNumbers);

        JLabel labelEnterYourCardNumber = new JLabel();
        labelEnterYourCardNumber.setText("Enter Your Card Number");

        content.add(labelEnterYourCardNumber);

        content.add(inputCardField);
        handleEnterKeyPressForInputCardField();

        content.add(winLooselabel);

        aWindow.setVisible(true); // Display the window
    }

    //model code
    public static void main(String[] args) {
        GoFish frame = new GoFish();
    }

}
