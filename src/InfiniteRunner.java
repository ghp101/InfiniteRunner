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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InfiniteRunner extends Canvas implements KeyListener, Runnable
{
    private boolean[] keys;
    private BufferedImage back;
    private int score;
    private int level;
    private boolean jump;
    private Player player;
    private Obstacle obstacle;
    private HighScore highScore;

    public InfiniteRunner()
    {
        keys = new boolean[2];

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);
        
        player = new Player();
        obstacle = new Obstacle();
        
        highScore = new HighScore();
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
        
        // ground
        graphToBack.setColor(Color.black);
        graphToBack.fillRect(0, 450, 800, 200);
        
        // score
        graphToBack.setColor(Color.white);
        graphToBack.fillRect(350, 0, 200, 80);
        graphToBack.setColor(Color.black);
        graphToBack.drawString("Score: " + score, 400, 50);
        graphToBack.drawString("High Score: " + highScore.get(), 470, 50);
        
        // jump
        player.draw(graphToBack);
        if(jump == true)
        {
            player.move(graphToBack);
            if(player.getY() == 150)
                player.setSpeed(-5);
            if(player.getY() == 400)
            {
                jump = false;
                player.setSpeed(5);
            }
        }
        
        // re draw obstacle
        obstacle.move(graphToBack);
        if(obstacle.getX()+obstacle.getWidth() <= 0)
        {
            obstacle.draw(graphToBack,Color.white);
            obstacle.setHeight((int) (Math.random()*50) + 50);
            obstacle.setX(800);
            obstacle.setY(400-(obstacle.getHeight()-50));
            obstacle.move(graphToBack);
            
            score++;
        }
        
        // collision
        if(obstacle.didCollideBottom(player) == true
        && obstacle.didCollideTop(player) == true
        && obstacle.didCollideLeft(player) == true
        && obstacle.didCollideRight(player) == true)
        {
            obstacle.setSpeed(0);
            player.setSpeed(0);
            try {
                highScore.save(score);
            } catch (IOException ex) {
                Logger.getLogger(InfiniteRunner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // level
        if(score == 5)
            obstacle.setSpeed(3);
        if(score == 10)
            obstacle.setSpeed(4);
        if(score == 20)
            obstacle.setSpeed(5);
        if(score == 40)
            obstacle.setSpeed(6);
        
        if (keys[0] == true)
        {
            jump = true;
        }
        if (keys[1] == true)
        {
            obstacle.draw(graphToBack,Color.white);
            obstacle.setHeight((int) (Math.random()*50) + 50);
            obstacle.setX(800);
            obstacle.setY(400-(obstacle.getHeight()-50));
            obstacle.move(graphToBack);
            obstacle.setSpeed(2);
            
            player.draw(graphToBack, Color.white);
            player.setY(400);
            player.draw(graphToBack);
            
            score = 0;
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
            case 'R':
                keys[1] = true;
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
            case 'R':
                keys[1] = false;
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
