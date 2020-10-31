package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class Square {
    private int xLoc,yLoc;
    private int width,height;
    private int number;
    private boolean clicked;
    private Color bckgrndColor = new Color(230, 230, 230);
    private Color txtColor;
    private boolean flagged;

    public Square(int x, int y, int num)
    {
        xLoc = x;
        yLoc = y;
        width = 30;
        height = 30;
        number = num;
        clicked = false;
        flagged = false;
    }

    public void draw(Graphics window)
    {
        window.setColor(Color.GRAY);
        window.fillRect(this.getX(),this.getY(),width,height);
    }

    public void disappear(Graphics window)
    {
        window.setColor(bckgrndColor);
        window.fillRect(this.getX(),this.getY(),width,height);

        switch(number)
        {
            case 1:txtColor = Color.BLUE; break;
            case 2:txtColor = new Color(0, 204, 0); break;
            case 3:txtColor = Color.RED; break;
            case 4:txtColor = new Color(0, 0, 102); break;
            case 5:txtColor = new Color(179, 0, 0); break;
            case 6:txtColor = new Color(77, 184, 255); break;
            case 7:txtColor = new Color(102, 0, 102); break;
            case 8:txtColor = new Color(38, 38, 38); break;
            case 9:txtColor = Color.BLACK; break;
            default:txtColor = new Color(230, 230, 230); break;
        }

        window.setColor(txtColor);

        window.setFont(new Font("Courier New", 1, 20));
        if (number == 9)
        {
            window.drawString("*",xLoc+10,yLoc+20);
        }
        else
        {
            window.drawString("" + number,xLoc+10,yLoc+20);
        }
    }

    public void drawFlag(Graphics window)
    {
        window.setColor(Color.BLACK);
        window.drawLine(xLoc+10,yLoc+5,xLoc+10,yLoc+23);
        int[] xPoints = {xLoc+10,xLoc+20,xLoc+10};
        int[] yPoints = {yLoc+5,yLoc+10,yLoc+15};
        window.fillPolygon(xPoints, yPoints, 3);
    }

    public boolean didMouseClick(int x, int y)
    {
        if (x <= getXRightBorder() && x >=getXLeftBorder() && y <= getYDownBorder() && y >= getYUpBorder())
        {
            return true;
        }
        return false;
    }

    public void flag()
    {
        flagged = true;
    }

    public void unflag()
    {
        flagged = false;
    }

    public void setInvisible()
    {
        clicked = true;
    }

    public void setRed()
    {
        bckgrndColor = Color.RED;
    }

    public boolean getInvisibility()
    {
        return clicked;
    }

    public boolean getFlag()
    {
        return flagged;
    }

    public int getX()
    {
        return xLoc;
    }

    public int getY()
    {
        return yLoc;
    }

    public int getXLeftBorder()
    {
        return xLoc;
    }

    public int getXRightBorder()
    {
        return xLoc + width;
    }

    public int getYUpBorder()
    {
        return yLoc;
    }

    public int getYDownBorder()
    {
        return yLoc+height;
    }

    public int getNumber()
    {
        return number;
    }
}

