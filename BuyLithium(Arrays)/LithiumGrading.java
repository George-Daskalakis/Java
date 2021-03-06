import java.util.*;
/**
 * This class makes use of the tray of lithium generated in the GenerateLithium class so that the lithium can be graded .
 *
 * @author George Daskalakis
 * @version 20/10/2019
 */

public class LithiumGrading
{
    ArrayList<Integer> highGrade = new ArrayList<>();
    ArrayList<Integer> lowGrade = new ArrayList<>();
    int [][] tray;
    /**
     * Constructor for objects of class LithiumGrading
     * @param gl The class of GenerateLithium.
     */
    public LithiumGrading(GenerateLithium gl)
    {
        tray = gl.getTray();
    }

    /**
     * Accepts a two dimensional array.
     * Checks the values and adds them to the according ArrayLists.
     * @param tray A two dimensional array. 
     */
    public void generateGrades(int[][] tray)
    {
        int min = 25;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (tray[i][j] > min)
                {
                    highGrade.add(tray[i][j]);
                }
                else {
                    lowGrade.add(tray[i][j]);   
                }
            }
        }
    }
    
    /**
     * Using bubble sort on the two ArrayLists, it sorts the numbers at an ascending order.
     * Prints the values of the two ArrayLists 
     */
    public void sortingLithium()
    {
        int temp;
         if (highGrade.size()>1) // check if the number of orders is larger than 1
        {
            for (int x=0; x<highGrade.size(); x++) // bubble sort outer loop
            {
                for (int i=0; i < highGrade.size() - x - 1; i++) {
                    if (highGrade.get(i).compareTo(highGrade.get(i+1)) > 0)
                    {
                        temp = highGrade.get(i);
                        highGrade.set(i,highGrade.get(i+1) );
                        highGrade.set(i+1, temp);
                    }
                }
            }
        }
        
        if (lowGrade.size()>1) // check if the number of orders is larger than 1
        {
            for (int x=0; x<lowGrade.size(); x++) // bubble sort outer loop
            {
                for (int i=0; i < lowGrade.size() - x - 1; i++) {
                    if (lowGrade.get(i).compareTo(lowGrade.get(i+1)) > 0)
                    {
                        temp = lowGrade.get(i);
                        lowGrade.set(i,lowGrade.get(i+1) );
                        lowGrade.set(i+1, temp);
                    }
                }
            }
        }
        
        System.out.println("High Grade");
        for (Integer grade: highGrade)
        {
            System.out.println(grade.intValue());
        }
        System.out.println();
        System.out.println("Low Grade");
        for (Integer grade: lowGrade)
        {
            System.out.println(grade.intValue());
        }
    }
}