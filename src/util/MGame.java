package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.*;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MGame extends Canvas implements MouseListener, Runnable
{
    // Declaring and initializing all variables.
    private boolean mouseClicked = false; //detect for the left mouse button
    private boolean mouseClicked2 = false; //detect for the right mouse button
    private int xPos;
    private int yPos;
    private int[][] map;
    private Square[][] allSquares;
    private boolean[][] wasHere;
    private int numBombs;
    private boolean playAgain = false;
    private boolean win = false;
    private boolean lose = false;
    private int flagsPlaced = 0;
    private boolean LockMouse = false;
    public MGame() {
        //Setup for background.
        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addMouseListener(this);

        wasHere = new boolean[10][10];
        for (int r = 0; r < wasHere.length; r++)
        {
            // Marks clicked spots.
            for (int c = 0; c < wasHere[0].length; c++)
            {
                wasHere[r][c] = false;
            }
        }
        // Counts number of spots clicked by user.
        Grid g = new Grid(10, 10);
        map = g.getCountsGrid();
        allSquares = new Square[10][10];
        int x = 250;
        int y = 80;
        for (int r = 0; r < map.length; r++)
        {
            for (int c = 0; c< map[0].length;c++)
            {
                allSquares[r][c] = new Square(x+31*r,y+31*c,map[r][c]);
            }
        }
        //Counting how many bombs are in the map.
        for (int r = 0; r <allSquares.length; r++)
        {
            for (int c = 0; c < allSquares.length; c++)
            {
                if (allSquares[r][c].getNumber() == 9)
                {
                    numBombs++;
                }
            }
        }
    }
    // Code that instructs actions of the mouse when pressed.
    public void mousePressed(MouseEvent e) //checks to see when and where the mouse is pressed
    {
        xPos = e.getX();
        yPos = e.getY();
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            mouseClicked = true;
        }
        else if (e.getButton() == MouseEvent.BUTTON3)
        {
            mouseClicked2 = true;
        }
    }
    // Code for when mouse is released.
    public void mouseReleased(MouseEvent e)
    {
        mouseClicked = false;
        mouseClicked2 = false;
    }
    // No need for mouseEntered, just here for reference.
    public void mouseEntered(MouseEvent e) {}
    // Code for mouseExited command.
    public void mouseExited(MouseEvent e) {}
    // Code for when mouse is clicked.
    public void mouseClicked(MouseEvent e)
    {
        xPos = e.getX();
        yPos = e.getY();
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            mouseClicked = true;
        }
        else if (e.getButton() == MouseEvent.BUTTON3)
        {
            mouseClicked2 = true;
        }
    }
    // Changes color of square when mouse is clicked.
    public void update(Graphics window)
    {
        paint(window);
    }
    // Makes sure that other squares are not uncovered when square in clicked.
    public int checkOtherSquares(int r, int c) //checks to show other squares after clicking on a blank square
    {
        if (allSquares[r][c].getNumber() >= 1 || wasHere[r][c])
        {
            return 0;
        }
        else if (allSquares[r][c].getNumber() == 0 )
        {
            if (allSquares[r][c].getFlag() == false){ allSquares[r][c].setInvisible(); }
            if (r-1 >=0)
            {
                if (allSquares[r-1][c].getFlag() == false){ allSquares[r-1][c].setInvisible(); }
            }
            if (r+1 < allSquares.length)
            {
                if (allSquares[r+1][c].getFlag() == false){ allSquares[r+1][c].setInvisible(); }
            }
            if (c-1 >= 0)
            {
                if (allSquares[r][c-1].getFlag() == false){ allSquares[r][c-1].setInvisible(); }
            }
            if (c+1 < allSquares[0].length)
            {
                if (allSquares[r][c+1].getFlag() == false){ allSquares[r][c+1].setInvisible(); }
            }
        }
        wasHere[r][c] = true;
        if (r != 0)
        {
            if (checkOtherSquares(r-1,c) != 0) { return 1; }
        }
        if (r != allSquares.length - 1)
        {
            if (checkOtherSquares(r+1, c) != 0) { return 1; }
        }
        if (c != 0)
        {
            if (checkOtherSquares(r, c-1) != 0 ) { return 1; }
        }
        if (c != allSquares[0].length- 1)
        {
            if (checkOtherSquares(r, c+1) != 0) { return 1; }
        }
        return 0;
    }
    // When game is over, graphics are displayed, reveals bombs.
    public void gameOver(Graphics window) //Game over screen
    {
        playAgain = true;
        LockMouse = true;
        window.setColor(Color.RED);
        window.setFont(new Font("Courier New", 1, 30));
        window.drawString("GAME OVER",325,415);

        window.setColor(new Color(0, 57, 77));
        window.setFont(new Font("Courier New", 1, 20));
        window.drawString("Play Again?",340,440);
        window.setColor(Color.BLACK);
        window.drawRect(335,422,140,25);

        for (int r = 0; r < map.length; r++)
        {
            for (int c = 0; c< map[0].length;c++)
            {
                if (allSquares[r][c].getNumber() == 9)
                {
                    allSquares[r][c].unflag();
                    allSquares[r][c].setInvisible();
                }
            }
        }
    }
    // When user clicks to play again, everything resets.
    public void reset(Graphics window) //resets the game so the play can play again
    {
        playAgain = false;
        LockMouse = false;
        flagsPlaced = 0;
        numBombs = 0;
        xPos = 0;
        yPos = 0;
        mouseClicked = false;
        mouseClicked2 = false;
        win = false;
        lose = false;
        wasHere = new boolean[10][10];
        for (int r = 0; r < wasHere.length; r++)
        {
            for (int c = 0; c < wasHere[0].length; c++)
            {
                wasHere[r][c] = false;
            }
        }
        Grid g = new Grid(10, 10);
        map = g.getCountsGrid();
        allSquares = new Square[10][10];
        int x = 250;
        int y = 80;
        for (int r = 0; r < map.length; r++)
        {
            for (int c = 0; c< map[0].length;c++)
            {
                allSquares[r][c] = new Square(x+31*r,y+31*c,map[r][c]);
            }
        }
        //counting how many bombs in the map
        for (int r = 0; r <allSquares.length; r++)
        {
            for (int c = 0; c < allSquares.length; c++)
            {
                if (allSquares[r][c].getNumber() == 9)
                {
                    numBombs++;
                }
            }
        }
    }
    // Display when user wins.
    public void winningScreen(Graphics window)
    {
        LockMouse = true;
        playAgain = true;
        window.setColor(new Color(0, 57, 77));
        window.setFont(new Font("Courier New", 1, 20));
        window.drawString("Play Again?",340,440);
        window.setColor(Color.BLACK);
        window.drawRect(335,422,140,25);

        window.setColor(new Color(0, 230, 0));
        window.setFont(new Font("Courier New",1, 30));
        window.drawString("YOU WIN!!!",320, 415);
    }
    // Displays all objects on screen.
    public void paint(Graphics window)
    {
        //Edge
        window.setColor(Color.BLACK);
        window.drawLine(10,10,10,450);
        window.drawLine(10,450,780,450);
        window.drawLine(780,450,780,10);
        window.drawLine(780,10,10,10);
        window.setColor(new Color(0, 107, 179));

        window.setFont(new Font("Courier New", 1, 35));
        window.drawString("MINESWEEPER",295,50);

        if ((mouseClicked == true || mouseClicked2 == true) && LockMouse == false)
        {
            for (int r = 0; r < map.length; r++)
            {
                for (int c = 0; c< map[0].length;c++)
                {
                    if (allSquares[r][c].didMouseClick(xPos,yPos) == true) //checking each square for a click R/L Mouse
                    {
                        if (mouseClicked == true && mouseClicked2 == false)
                        {
                            allSquares[r][c].setInvisible();
                            allSquares[r][c].unflag();
                            if (allSquares[r][c].getNumber() == 0)
                            {
                                checkOtherSquares(r,c);
                            }
                        }
                        else if (mouseClicked2 == true && mouseClicked == false && allSquares[r][c].getInvisibility() == false && flagsPlaced<numBombs) //check to flag
                        {
                            allSquares[r][c].flag();
                        }
                        //Game over
                        if (allSquares[r][c].getNumber() == 9 && mouseClicked == true && mouseClicked2 == false)
                        {
                            allSquares[r][c].setRed();
                            lose = true;
                        }
                    }
                }
            }
        }
        else
        {

        }

        flagsPlaced = 0;
        int bombsCorrectlyFlagged = 0;

        for (int r = 0; r < map.length; r++) //Painting all of the squares to screen
        {
            for (int c = 0; c< map[0].length;c++)
            {
                if (allSquares[r][c].getInvisibility() == true && allSquares[r][c].getFlag() == false)
                {
                    allSquares[r][c].disappear(window);
                }
                else if (allSquares[r][c].getFlag() == true && allSquares[r][c].getInvisibility() == false)
                {
                    allSquares[r][c].drawFlag(window);
                    flagsPlaced++;
                    if (allSquares[r][c].getNumber() == 9)
                    {
                        bombsCorrectlyFlagged++;
                    }
                }
                else
                {
                    allSquares[r][c].draw(window);
                }
                if (bombsCorrectlyFlagged == numBombs)
                {
                    win = true;
                }
            }
        }

        //Checking to print a win/lose screen.
        if (win == true)
        {
            winningScreen(window);
        }
        else if (lose == true)
        {
            gameOver(window);
        }
        else
        {
            window.setColor(Color.WHITE);
            window.fillRect(315,390,200,60);
        }

        //Checking to play again.
        if (playAgain == true)
        {
            if (mouseClicked == true || mouseClicked2 == true)
            {
                if (xPos >= 335 && xPos <= 475 && yPos >= 422 && yPos <=447)
                {
                    reset(window);
                }
            }
        }
        // Resetting colors, fonts, and words.
        window.setColor(Color.WHITE);
        window.fillRect(25,75,200,350);
        window.setColor(new Color(255, 204, 0));
        window.setFont(new Font("Courier New", 1, 15));
        window.drawString("# of Bombs: " + numBombs,35,200);
        window.drawString("Flags Placed: " + flagsPlaced,35,230);
    }

    public void run()
    {
        try
        {
            while(true)
            {
                Thread.currentThread().sleep(10);
                repaint();
            }
        }catch(Exception e)
        {
        }
    }
}

