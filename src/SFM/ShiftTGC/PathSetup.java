package SFM.ShiftTGC;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PathSetup {
    
    public static void setup() throws Exception {


        String steamPath = null;
        String sfmPath = null;
        Boolean loop = true;
        String loopQuestion;

        Scanner pathInputScanner = new Scanner(System.in);
       /*  while(loop == true)
        { */
            SFM.cls();
            SFM.logo();
            SFM.println("----------------------------------------------");
            SFM.println("Please enter your Steam folder path (which contains the \"Steam.exe\" file)");
            SFM.print("Path: ");
            steamPath = pathInputScanner.nextLine();

            SFM.cls();
            SFM.logo();
            SFM.println("----------------------------------------------");
            SFM.println("Please enter your Steam folder path (which contains the \"Steam.exe\" file)");
            SFM.print("Path: "+steamPath);
            SFM.println("");
            SFM.println("And now your SFM folder path (which contains the \"sfm.exe\" file)");
            SFM.print("Path: ");
            sfmPath = pathInputScanner.nextLine();

           /*  SFM.cls();
            SFM.logo();
            SFM.println("----------------------------------------------");
            SFM.println("Are these paths correct? (y/n)");    
            SFM.println("Steam.exe path: "+steamPath);
            SFM.println("sfm.exe path: "+sfmPath);
            SFM.print("User Input: ");
            
            loopQuestion = pathInputScanner.nextLine();
            if(loopQuestion == "y")
            {
                loop = false;
            }
            else; */

        /* } */
        pathInputScanner.close();

        FileWriter.write(steamPath, sfmPath);
        SFM.cls();
        SFM.logo();
        SFM.println("----------------------------------------------");
        SFM.println("Paths set! The program will stop/die in 10 seconds.");
        SFM.println("You will have to start the program up again afterwards and it should run normally.");
        TimeUnit.SECONDS.sleep(10);
        

    }
    
}
