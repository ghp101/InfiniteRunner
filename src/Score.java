
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pengg8152
 */
public class Score
{
    private static int highScore;
    
    public Score()
    {
        
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
    
    public void read(String fileName)
    {
        
    }
}
