package SFM.ShiftTGC;

import java.io.File;

public class ProgramChecking {

    public static Boolean check() throws Exception {
        
        SFM.cls();
        SFM.logo();
        SFM.println("----------------------------------------------");

        String steamPath = FileReader.readSteam();
        String sfmPath = FileReader.readSFM();
        String steamExecutable = steamPath + "\\steam.exe";
        String sfmExecutable = sfmPath + "\\sfm.exe";
        Boolean steamTrue = checkStep2(steamExecutable);
        Boolean sfmTrue = checkStep2(sfmExecutable);

        if(steamTrue && sfmTrue) return true;
        else return false;
        



    }
    
    public static boolean checkStep2(String path)
    {
  
        // Get the file
        File steamFile = new File(path);
  
        // Check if the specified path
        // is a directory or not
        if (steamFile.exists())
            return true;
        else
            return false;
    }
    
}
