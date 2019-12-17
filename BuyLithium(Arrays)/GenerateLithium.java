import java.util.*;
/**
 * This class is responsible for generating a tray of lithium.
 *
 * @author George Daskalakis
 * @version 20/10/2019
 */
public class GenerateLithium
{
    int tray [][] = new int [5][3];
    private int grading = 0;
    private Random randomGenerator;

    /**
     * Constructor for objects of class GenerateLithium
     */
    public GenerateLithium()
    {
        randomGenerator = new Random();
    }

    /**
    * Returns the two dimensional array.
    * @return the two dimensional array 
    */
   public int[][] getTray()
    {
        return tray;
    }
    
    /**
    * Generates the two dimensional array with numbers from 0 to 50
    */
   public void generateSample()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                grading = randomGenerator.nextInt(50);
                //Student to continue coding from here
                tray[i][j] = grading;
            }
        }
    }

    /**
    * Prints out the two dimensional array.
    */
   public void printTray()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(tray[i][j]>9){
                    System.out.print(tray[i][j] + "||");
                }
                else {
                    System.out.print(tray[i][j] + " ||");
                }
            }
            System.out.println();
        }
    }
}
