
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
public class Player extends Block
{
    private int speed;
    
    public Player()
    {
        super(100,400,50,50,Color.blue);
        speed = 5;
    }
    
    public void setSpeed(int s)
    {
        speed = s;
    }
    
    public void move(Graphics window)
    {
        draw(window, Color.WHITE);
        setY(getY() - speed);
        draw(window); 
    }  
}
