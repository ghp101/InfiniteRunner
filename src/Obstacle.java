
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
public class Obstacle extends Block
{
    private int speed;
    
    public Obstacle()
    {
        super(200,400,50,50,Color.green);
    }
    
    public void move(Graphics window, int s)
    {
        speed = s;
        
        draw(window, Color.WHITE);
        setY(getX() - speed);
        draw(window); 
    }
}
