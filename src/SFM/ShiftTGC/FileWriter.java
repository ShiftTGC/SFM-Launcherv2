package SFM.ShiftTGC;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileWriter {

    public static void write(String steamPath, String sfmPath) throws Exception {
        FileOutputStream fos = new FileOutputStream("Paths.txt",false);
        PrintWriter pw = new PrintWriter(fos);
        //pw.print("");
        pw.println(steamPath);
        pw.println(sfmPath);
        pw.close();
        System.out.println("File \"Paths.txt\" has been made/edited. Please restart.");
        System.out.println(" (I have used a few hours on this program now. I'm lazy. Leave me beee,a aaaaaaaaa)");
    }
    
}
