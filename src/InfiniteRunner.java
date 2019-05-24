/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pengg8152
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class InfiniteRunner extends Canvas implements KeyListener, Runnable
{
    private boolean[] keys;
    private BufferedImage back;
    private int score;
    private boolean jump;
    private Player player;
    private Obstacle obstacle;

    public InfiniteRunner()
    {
        keys = new boolean[3];

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);
        
        player = new Player();
        obstacle = new Obstacle();
    }

    public void update(Graphics window)
    {
        paint(window);
    }

    public void paint(Graphics window)
    {
        Graphics2D twoDGraph = (Graphics2D) window;

        if (back == null)
        {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        Graphics graphToBack = back.createGraphics();
        
        graphToBack.setColor(Color.black);
        graphToBack.fillRect(0, 450, 800, 200);
        
        player.draw(graphToBack);
        if(jump == true)
        {
            player.move(graphToBack);
            if(player.getY() == 100)
                player.setSpeed(-5);
            if(player.getY() == 400)
            {
                jump = false;
                player.setSpeed(5);
            }
        }
        
        obstacle.move(graphToBack);
        if(obstacle.getX()+obstacle.getWidth() == 0)
        {
            obstacle.draw(graphToBack,Color.white);
            obstacle.setHeight((int) (Math.random()*50) + 50);
            obstacle.setX(800);
            obstacle.setY(400-(obstacle.getHeight()-50));
            obstacle.move(graphToBack);
        }
        
        if (keys[0] == true)
        {
            jump = true;
        }
        if (keys[1] == true)
        {

        }
        if (keys[2] == true)
        {

        }
        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e)
    {
        switch (toUpperCase(e.getKeyChar()))
        {
            case KeyEvent.VK_SPACE:
                keys[0] = true;
                break;
            case 'S':
                keys[1] = true;
                break;
            case 'R':
                keys[2] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        switch (toUpperCase(e.getKeyChar()))
        {
            case KeyEvent.VK_SPACE:
                keys[0] = false;
                break;
            case 'S':
                keys[1] = false;
                break;
            case 'R':
                keys[2] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void run()
    {
        try{
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
