
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pengg8152
 */
public class HighScore
{
    private static int highScore;
    
    public HighScore()
    {
        try {
            read();
        } catch (IOException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void save(int s) throws IOException, FileNotFoundException
    {
        if(s > highScore)
        {
            highScore = s;
            FileWriter fileWriter = new FileWriter("src/highScore.dat");
            fileWriter.write(highScore+" ");
            fileWriter.close();
        }  
    }
    
    public void read() throws IOException, FileNotFoundException
    {
        Scanner sc = new Scanner(new File("src/highScore.dat"));
        highScore = sc.nextInt();
    }
    
    public String get()
    {
        return highScore+"";
    }
}
