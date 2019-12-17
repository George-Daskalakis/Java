import java.util.*;
/**
 * This class makes use of Hashmaps to set the pricing of the lithium as this class is responsible for ensuring that each lithium sample is given a price. 
 *
 * @author George Daskalakis
 * @version 20/10/2019
 */
public class LithiumPricing
{
    private HashMap<Integer, Double> hmap = new HashMap<Integer, Double>();
    int [][] tray; 
    /**
     * Constructor for objects of class LithiumPricing.
     * @param gl The class of GenerateLithium.
     */
    public LithiumPricing(GenerateLithium gl)
    {
        tray = gl.getTray();
    }
    
    /**
    * Returns the HashMap with  an integer key and a Double as a value.
    * @return the HashMap 
    */
     public HashMap<Integer, Double> getHash()
    {
        return hmap;
    }
    
    /**
     * Creates the HashMap.
     * Keys are the values from the two dimensional array.
     * Values are the prices.
     */
    public void setPrice()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(tray[i][j]<10)
                {
                    hmap.put(tray[i][j], 300.00);
                }
                else if(tray[i][j]>=10 && tray[i][j]<20){
                    hmap.put(tray[i][j], 600.00);
                }
                else if (tray[i][j]>=20 && tray[i][j]<30){
                    hmap.put(tray[i][j], 900.00);
                }
                else if (tray[i][j]>=30){
                    hmap.put(tray[i][j], 1250.00);
                }
            }
        }
    }
    
    /**
     * Prints out the HashMap.
     * Checks to see if the key is double digit to print the hashmap appropriately.
     */
    public void printPrice()
    {
        
       for (Integer key : hmap.keySet()) {
            if(key >= 10){
            System.out.print(key.toString());
            System.out.print("   " + hmap.get(key).toString());
            System.out.println();
        }
        else 
        {
            System.out.print(key.toString());
            System.out.print("    " + hmap.get(key).toString());
            System.out.println();
        }
    }
    }
}

