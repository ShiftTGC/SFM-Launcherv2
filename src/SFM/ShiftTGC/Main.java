package SFM.ShiftTGC;

public class Main {
    public static void main(String[] args) throws Exception {

        SFM.cls();
        SFM.logo();
        SFM.println("----------------------------------------------");

        Boolean correctPath;
        correctPath = PathChecking.read();
        System.out.println(correctPath);

        if(correctPath == true)
        {
            if(ProgramChecking.check() == true) SFM.main();
            else PathSetup.setup();
        }
        else
        {
            PathSetup.setup();
        }
        
    }
    
}
