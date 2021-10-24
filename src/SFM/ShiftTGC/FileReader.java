package SFM.ShiftTGC;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileReader {
 
  
  public static String readSteam() throws Exception {
    try {
      File myObj = new File("Paths.txt");
      Scanner myReader = new Scanner(myObj);
        String steamPath = myReader.nextLine();
        String sfmPath = myReader.nextLine();
      
      myReader.close();
      return steamPath;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
  }
    
    
    public static String readSFM() throws Exception {
      try {
        File myObj = new File("Paths.txt");
        Scanner myReader = new Scanner(myObj);
          String steamPath = myReader.nextLine();
          String sfmPath = myReader.nextLine();
        myReader.close();
        return sfmPath;
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      return null;
    }
  }