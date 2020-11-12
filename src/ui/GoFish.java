package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        super("GoFish");
        setBounds(100, 100, 418, 315);
        Container c = getContentPane();
        JPanel panel = new JPanel();

        JTextField f = new JTextField("Pick a Card", 10);
        JButton b = new JButton("Enter");

        panel.add(f);
        panel.add(b);
        c.add(panel);


        List<String> allMatches = new ArrayList<String>();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        JButton button = new JButton("Draw Card");
    }






}
