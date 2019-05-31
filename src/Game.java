/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pengg8152
 */
import javax.swing.JFrame;
import java.awt.Component;

public class Game extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    private static InfiniteRunner game;

    public Game()
    {
        super("InfinitRunner");
        setSize(WIDTH,HEIGHT);

        game = new InfiniteRunner();
        ((Component)game).setFocusable(true);
        getContentPane().add(game);
        
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}