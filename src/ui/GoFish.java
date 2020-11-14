package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//creates class GoFish that stores all the methods, constructors, view codes, and datatypes used to execute the code.
public class GoFish extends JFrame{


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GoFish frame = new GoFish();
                frame.setSize(300,300);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //Creates a new ArrayList and uses the add function to add values.
        //The elements of the ArrayList are randomized
        //The ArrayList is then split into two smaller ArrayLists
        ArrayList<Integer> newDeck = new ArrayList<Integer>();
        newDeck.add(0);
        newDeck.add(1);
        newDeck.add(2);
        newDeck.add(3);
        newDeck.add(4);
        newDeck.add(5);
        newDeck.add(6);
        newDeck.add(7);
        newDeck.add(8);
        newDeck.add(9);
        newDeck.add(10);
        newDeck.add(11);
        newDeck.add(12);
        newDeck.add(14);
        newDeck.add(15);
        Collections.shuffle(newDeck);
        System.out.println(newDeck);
        List<Integer> gameDeck = newDeck.subList(0, 5);
        List<Integer> pickDeck = newDeck.subList(5, 15);
        System.out.println(pickDeck);
        System.out.println(gameDeck);
        Scanner scanning = new Scanner(System.in);
        System.out.println("Pick a card");
        int cardPick = scanning.nextInt();
        System.out.println(cardPick);
        //This boolean is used to determine whether the player's card guess is correct
        //This boolean and if statement checks the card values in the deck of cards
        //There is an operation each if the guess is correct or if the guess fails.
        boolean isTrue = pickDeck.contains(cardPick);
        if (isTrue) {
            System.out.println("correct");
        } else{
            System.out.println("wrong");
            System.out.println("Draw A Card");
            Integer g = pickDeck.get(0);
            System.out.println(g);
            gameDeck.add(g);
            System.out.println(gameDeck);
        }


    }

    public GoFish(){
        //Create a textfield that prints out the different types of cards
        //It prints out the card deck that the player uses
        //Then create a way to input the guess using a JPanel textfield

        super("GoFish");
        setBounds(100, 100, 418, 315);
        Container c = getContentPane();

        JButton b = new JButton("Deck");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<Integer> newDeck = new ArrayList<Integer>();
                newDeck.add(0);
                newDeck.add(1);
                newDeck.add(2);
                newDeck.add(3);
                newDeck.add(4);
                newDeck.add(5);
                newDeck.add(6);
                newDeck.add(7);
                newDeck.add(8);
                newDeck.add(9);
                newDeck.add(10);
                newDeck.add(11);
                newDeck.add(12);
                newDeck.add(14);
                newDeck.add(15);
                Collections.shuffle(newDeck);
                //System.out.println(newDeck);

                List<Integer> gameDeck = newDeck.subList(0, 5);
                List<Integer> pickDeck = newDeck.subList(5, 15);
                System.out.println(gameDeck);
            }


        });

        c.add(BorderLayout.EAST, b);

        JPanel panel = new JPanel();

        JTextField f = new JTextField("Pick a Card", 10);
        f.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = f.getText();
                //A String is converted to an integer
                //This stores the input from my textfield in GoFish as an integer
                //This input is the guess the player makes
                //The input must be a card number
                //Primitive datatype int is used
                int i = Integer.parseInt(num);
                



            }
        });

        panel.add(f);

        c.add(BorderLayout.SOUTH, panel);


        List<String> allMatches = new ArrayList<String>();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        JButton button = new JButton("Draw Card");
        c.add(BorderLayout.NORTH, button);
    }

    public static void controlCode(){


    }


}
