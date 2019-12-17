import java.util.*;
/**
 * This class offers a buyer the chance to enter a price and quality and the method should show all the lithium that is on offer at the buyer’s price 
 * or any price lower than what the buyer has stated
 * or show all the lithium that is on offer at the buyer's prefered quality or greater.. 
 *
 * @author George Daskalakis
 * @version 20/10/2019
 */
public class BuyLithium
{
    private HashMap<Integer, Double> hashmap;
    /**
     * Constructor for objects of class BuyLithium
     * @param lp The class of LithiumPricing.
     */
    public BuyLithium(LithiumPricing lp)
    {
        hashmap = lp.getHash();
    }
    
    /**
     * Compares the price that the user inputs with the prices in the HashMap.
     * Prints all the items that have a price lower or equal to the one the user selected.
     * @param price The price that the user selcets.
     */
    public void findBestPrice(double price)
    {
        int count = 0;
        for (Integer key : hashmap.keySet()){
            if (price>=hashmap.get(key) && key > 9){
                System.out.println(key.toString() +"   "+ hashmap.get(key).toString());
                count++;
            } 
            else if (price>=hashmap.get(key))
            {
                System.out.println(key.toString() +"    "+ hashmap.get(key).toString());
                count++;
            }
        }
        System.out.println("There are " + count + " choices available to you.");
    }

    /**
     * Compares the quality that the user inputs with the grade of lithium in the HashMap.
     * Prints all the items that have a quality greater or equal to the one the user selected.
     * @param quality The quality that the user selects.
     */
    public void findHighQuality(int quality){
         int count = 0;
        for (Integer key : hashmap.keySet()){
            if (quality <= key && key > 9){
                System.out.println(key.toString() +"   "+ hashmap.get(key).toString());
                count++;
            } 
            else if(quality <= key)
            {
                System.out.println(key.toString() +"    "+ hashmap.get(key).toString());
                count++;
            }
        }
        System.out.println("There are " + count + " choices available to you.");
    }
}
