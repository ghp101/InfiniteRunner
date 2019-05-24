//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private Color color;

    public Block(int x, int y, int w, int h, Color c)
    {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = c;
    }

    public void setPos(int x, int y)
    {
        xPos = x;
        yPos = y;
    }

    public int getX()
    {
        return xPos;
    }

    public void setX(int xPos)
    {
        this.xPos = xPos;
    }

    public int getY()
    {
        return yPos;
    }

    public void setY(int yPos)
    {
        this.yPos = yPos;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color col)
    {
        color = col;
    }

    public void draw(Graphics window)
    {
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col)
    {
        window.setColor(col);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public String toString()
    {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
    }
}
