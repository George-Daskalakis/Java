import java.lang.*;
import java.math.BigInteger; 
import java.util.Scanner;
/**
 * Write a description of class binaryToDecimal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class binaryToDecimal
{
    public binaryToDecimal(){

    }

    public int returnDecimal(String binary) {
        BigInteger f = new BigInteger(binary);
        int num = f.intValue();
        int decimal = 0;
        int p = 0;
        while(true){
            if(num == 0){
                break;
            } else {
                int temp = num%10;
                decimal += temp*Math.pow(2, p);
                num = num/10;
                p++;
            }
        }
        System.out.println(decimal);
        return decimal;
    }
}
