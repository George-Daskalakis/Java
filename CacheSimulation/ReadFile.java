import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
  
  public static void main(String[] args) {
      cacheOrMemory2 m = new cacheOrMemory2(64, 268435456, 16384 ,64);
    try {
      File myObj = new File("C:\\Users\\geov_\\Desktop\\Uni\\Year2\\Operating Systems\\19-gd309.in");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
        m.result(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
