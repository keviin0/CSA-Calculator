package ui;

import util.MGame;

import javax.swing.JFrame;
import java.awt.Component;

public class MineSweeperGame extends JFrame
{
    private static final int WIDTH = 810;
    private static final int HEIGHT = 510;
    private MGame game;

    public MineSweeperGame()
    {
        super("Mine Sweeper");
        setSize(WIDTH,HEIGHT);

        game = new MGame();

        ((Component)game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main( String args[] )
    {
        MineSweeperGame run = new MineSweeperGame();
    }
}
