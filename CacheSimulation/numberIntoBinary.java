// Java program to Decimal to binary conversion 
// using bitwise operator 
// Size of an integer is assumed to be 32 bits 

public class numberIntoBinary { 
    // Function that convert Decimal to binary 
    StringBuilder binary = new StringBuilder();
    public numberIntoBinary()
    {
        
       }
       
       
       public String decToBinary(long n, int bits) 
    { 
        binary.setLength(0);
        for (long i = bits-1; i >= 0; i--) { 
            long k = n >> i; 
            if ((k & 1) > 0) 
                binary.append("1"); 
            else
                binary.append("0"); 
        } 
        System.out.println(binary);
        return binary.toString();
    } 
} 

