import java.util.*;
/**
 * Write a description of class Cache here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cache 
{
private  int[] cacheArray;
private int cache;
private int match;
private int bytesInCache;
private int lines;

    /**
     * Constructor for objects of class Cache
     */
    public Cache(int k)
    {
        lines = k;
        cacheArray = new int[lines];
    }

    
    public String addInArray(int number)
    {
        boolean found = false;
        for (int i = 0; i < cacheArray.length; i++) {
            if (number == cacheArray[i]) {
                found = true;
                match = i;
            }
        }
        if (found == false) {
            for (int i = 0; i < cacheArray.length-1; i++) {
                cacheArray[i] = cacheArray[i+1];
            }
            cacheArray[cacheArray.length-1] = number; 
            return "M";
        }
        else
        {
            for (int i = match; i < cacheArray.length-1; i++) {
                cacheArray[i] = cacheArray[i+1];
            }
            cacheArray[cacheArray.length-1] = number;
            return "C";
        }
    }
    
    public void printArray() {
         for (int element: cacheArray) {
            System.out.println(element);
        }
    }
}
