// import java.util.*;
// /**
 // * Write a description of class CacheOrMemory here.
 // *
 // * @author (your name)
 // * @version (a version number or a date)
 // */
public class cacheOrMemory
{
    // private String binary;
    // private int cache; 
    // private int numberGiven;
    // private int word;
    // private int match;
    // private int bytesInCache;
    // private int lines;
    // private String binaryClean;
    // private String index;
    // private Cache correctOne;
    
    // ArrayList<String> indexArray = new ArrayList<String>();
    // HashMap<String, Cache> indexesA = new HashMap<String, Cache>();
    // /**
     // * Constructor for objects of class CacheOrMemory
     // */
    // public cacheOrMemory(int w, int c ,int b ,int k)
    // {
        // cache = c;
        // bytesInCache = b;
        // lines = k;
        // word = w;

        // Scanner in = new Scanner(System.in);
        // System.out.printf("Please specify how many lines you want to enter: ");    
        // int max = in.nextInt();
        // in.nextLine(); //consuming the <enter> from input above  
        // numberIntoBinary a = new numberIntoBinary();
        // binaryToDecimal bi = new binaryToDecimal();
        // StringBuilder result = new StringBuilder();
        // for (int i = 0; i < max; i++) {
            // numberGiven = in.nextInt();
            // binary = a.decToBinary(numberGiven, word);
            // binaryClean = removeTagAndOffset(binary);
            // System.out.println("binaryClean: "+ binaryClean);
            // System.out.println("Contains: " + indexArray.contains(index));
            // System.out.println("Index: "+ index);
            // if (indexArray.contains(index)) {
                // correctOne = indexesA.get(index);  
                // //find the object with that index 
                // //and call the methods of that index 
                // int decimal = bi.returnDecimal(binaryClean); //the decimal number without index and offset
                // System.out.println("Decimal: "+ decimal);
                // if(decimal == 0) {
                    // decimal = 99991;
                    // System.out.println("Decimal Changed: "+ decimal);
                // }
                // result.append(correctOne.addInArray(decimal));
                // System.out.println(result);
                // }
               
            
            // else {
                // Cache indexNew = new Cache(lines); //make a new cache
                // indexArray.add(index); //add the index in the Array list
                // indexesA.put(index, indexNew); //put in the hashmap the new Cash with key the index
                
                // int decimal = bi.returnDecimal(binaryClean); //the decimal number without index and offset
                // System.out.println("Decimal: "+ decimal);
                // if(decimal == 0) {
                    // decimal = 99991;
                    // System.out.println("Decimal Changed: "+ decimal);
                // }
                // result.append(indexNew.addInArray(decimal));
                // System.out.println(result);
            // }
        // }
    // }
    
    // public String removeTagAndOffset(String binary)
    // {
        // int indexBits = (int) (Math.log(cache/bytesInCache) / Math.log(2));
        // int offsetBits = (int) (Math.log(bytesInCache/lines) / Math.log(2));
        // int removingParts = indexBits+offsetBits; 
        // index = binary.substring(binary.length() - removingParts, binary.length()- offsetBits);
        // return binary.substring(0, binary.length() - removingParts);
    // }
}

