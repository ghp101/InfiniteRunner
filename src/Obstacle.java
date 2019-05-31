
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pengg8152
 */
public class Obstacle extends Block implements Collidable
{
    private int speed;
    
    public Obstacle()
    {
        super(800,350,50,100,Color.black);
        speed = 2;
    }
    
    public void setSpeed(int s)
    {
        speed = s;
    }
    
    public void move(Graphics window)
    {
        draw(window, Color.WHITE);
        setX(getX() - speed);
        draw(window); 
    }

    public boolean didCollideLeft(Block b)
    {
        return (b.getX()+b.getWidth() >= getX());
    }

    public boolean didCollideRight(Block b)
    {

        return (b.getX() <= getX()+getWidth());
    }

    public boolean didCollideTop(Block b)
    {
        return (b.getY()+b.getHeight() >= getY());
    }
    
    public boolean didCollideBottom(Block b)
    {
        return (b.getY() <= getY()+getHeight());
    }
}
