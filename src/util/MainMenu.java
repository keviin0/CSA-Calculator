package util;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ui.*;


public class MainMenu extends JFrame {
    // This class is the first screen that is comes up with the Menus.


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainMenu frame = new MainMenu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        // JLabel with image
        JLabel pic = new JLabel("");
        java.awt.Image image = new ImageIcon("APCompSci.jpeg").getImage();
        pic.setIcon(new ImageIcon(image));
        pic.setBounds(377, 111, 128, 128);

        // Content Panel to add Label and Image
        //https://docs.oracle.com/javase/tutorial/uiswing/components/rootpane.html
        Container content = getContentPane();
        content.setBackground(new Color(100,100,255));
        content.add(pic);

        // Menu Objects
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnHone = new JMenu("Home");
        menuBar.add(mnHone);

        JMenuItem mntmPreferences = new JMenuItem("Preferences");
        mnHone.add(mntmPreferences);

        JMenuItem mPreferences2 = new JMenuItem("Preferences 2");
        mnHone.add(mPreferences2);

        JMenu mnApTest = new JMenu("AP Test");
        menuBar.add(mnApTest);

        JMenu mnJig = new JMenu("Labs");
        menuBar.add(mnJig);

        JMenuItem mntmCalculator = new JMenuItem("Calculator");
        mntmCalculator.addActionListener(e -> {
            CalculatorUI frame = new CalculatorUI();
            frame.setVisible(true);
        });
        mnJig.add(mntmCalculator);


        JMenuItem thai21 = new JMenuItem("Thai 21");
        thai21.addActionListener(e -> {
            Thai21 frame = new Thai21();
            frame.setVisible(true);
        });
        mnJig.add(thai21);

        JMenuItem uno = new JMenuItem("Uno");
        uno.addActionListener(e -> {
            Uno frame = new Uno();
            frame.setVisible(true);
        });
        mnJig.add(uno);

        JMenuItem mineSweeper = new JMenuItem("Mine Sweeper");
        mineSweeper.addActionListener(e -> {
            MineSweeperGame frame = new MineSweeperGame();
            frame.setVisible(true);
        });
        mnJig.add(mineSweeper);

        JMenuItem ticTacToe = new JMenuItem("TIC TAC TOE");
        ticTacToe.addActionListener(e -> {

           TicTacToe panel = new TicTacToe();
            panel.getFrame().setVisible(true);
        });
        mnJig.add(ticTacToe);



    }

}
