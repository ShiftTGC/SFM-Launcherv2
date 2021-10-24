package SFM.ShiftTGC;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException; 

public class PathChecking {
        public static boolean isFileExists(File file) {
            return file.isFile();
        }
    public static boolean read() throws InterruptedException, IOException
    {
        SFM.cls();
        SFM.logo();
        SFM.println("----------------------------------------------");
        System.out.println("Checking if configured correctly");
        String filePath = "Paths.txt";
        File file = new File(filePath);
 
        if (isFileExists(file)) {
            System.out.println("Paths exist!");
            TimeUnit.SECONDS.sleep(1);
            return true;
        }
        else {
            System.out.println("Paths doesn't exist. Preforming setup.");
            TimeUnit.SECONDS.sleep(1);
            return false;
        }
    }
}
