package SFM.ShiftTGC;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class SFM {

    public static void main() throws Exception {

        //clears the Windows CMD console and inserts the "logo"
        cls();
        logo();
        println("----------------------------------------------");

        //Initiations
        String opposite;
        String notOpposite;
        String status;
        String userArgs = null;
        String steamStatus;
        String steamProcessStatus;
        String steamPath = FileReader.readSteam();
        String sfmPath = FileReader.readSFM();
        Boolean picked = false; //Wanted to make a loop
        boolean allServicesBool;
        boolean pingSteamBool;
        boolean processSteamBool;
        boolean processSteamServicesBool;

        //Actual start of code per say

        //Checks if you have access to Steam's website
        pingSteamBool = pingSteam();
        if (!pingSteamBool) {
            status = "!!!CONNECTION FAILED/UNAUTHORIZED!!!";
        }
        else if (pingSteamBool) {
            status = "Connected";
        }
        else {
            status = "UNKNOWN ERROR (contact dev)";
        }

        //Checks if steam.exe is running or not
        if (processSteam()) {
            steamStatus = "Running";
            processSteamBool = true;
        } else {
            steamStatus = "NOT Running";
            processSteamBool = false;
        }

        //Checks if steamService.exe
        if (processSteamServices()) {
            steamProcessStatus = "Running";
            processSteamServicesBool = true;
        } else {
            steamProcessStatus = "NOT Running";
            processSteamServicesBool = false;
        }

        //Checks if all services has given green lights
        if (pingSteamBool && processSteamBool && processSteamServicesBool) {
            notOpposite = "Steam Enabled";
            opposite = "No-Steam";
            allServicesBool = true;
        } else {
            opposite = "Steam Enabled";
            notOpposite = "No-Steam";
            allServicesBool = false;
        }

        //Display the status to user
        cls();
        logo();
        println("Connection to Steam servers: " + status);
        println("Steam Application running: " + steamStatus);
        println("Steam Services running: " + steamProcessStatus);
        println("----------------------------------------------");
        Scanner input = new Scanner(System.in);

        //Again checks for the steam.exe and steamServices.exe if it is running or not
        // If not running, probably just the program not started up, as long as a connection to the steam servers have been made.
        if (!processSteamBool && !processSteamServicesBool && pingSteamBool) {
            println("Steam seems to not be running.");
            print("Do you want to run it? (y/n): ");
            String userInput = input.nextLine();
            if (userInput.equals("y") || userInput.equals("Y")) {
                print("Starting..");

                Runtime runTime = Runtime.getRuntime();
                String executablePath = steamPath + "\\steam.exe";
                println("Launching Executable: " + executablePath);
                runTime.exec(executablePath);

                while (!processSteam() || !processSteamServices()) {
                    print(".");
                    TimeUnit.MILLISECONDS.sleep(500);
                }
                notOpposite = "Steam Enabled";
                opposite = "No-Steam";
                cls();
                println("");
                logo();
                println("Connection to Steam servers: " + status);
                println("Steam Application running: Running");
                println("Steam Services running: Running");
            } else {
                println("Assuming \"n\" (no \"y\" or \"Y\" input detected)");
                println("Continuing in 3 seconds");
                TimeUnit.SECONDS.sleep(3);

                cls();
                logo();
                println("Connection to Steam servers: " + status);
                println("Steam Application running: " + steamStatus);
                println("Steam Services running: " + steamProcessStatus);

            }
            println("----------------------------------------------");

        }


        println("Which mode do you want to start in?");
        println("(Add 1 to the end, no spaces, to overwrite " + notOpposite + " mode and launch in " + opposite + " mode.");
        println("Editing Mode: 1 | Render Mode: 2 | Open SFM folder: 3");
        println("");
        print("User Input: ");
        String userInput = input.nextLine();

        try {
            if (allServicesBool) {
                switch (userInput) {
                    case "1":
                        userArgs = "";
                        picked = true;
                        break;
                    case "2":
                        userArgs = " -sfm_resolution 8640 -w 15360 -h 8640";
                        picked = true;
                        break;
                    case "11":
                        userArgs = " -nosteam";
                        picked = true;
                        break;
                    case "21":
                        userArgs = " -nosteam -sfm_resolution 8640 -w 15360 -h 8640";
                        picked = true;
                        break;
                    case "3":
                        userArgs = "3";
                        picked = true;
                        break;
                    default:
                        Boolean warningSent;
                        if (warningSent = false) {
                            println("Invalid input");
                            println("Please type in one of the numbers above.");
                            print("User Input: ");
                            userInput = input.nextLine();
                            warningSent = true;
                        } else {
                            print("User Input: ");
                            userInput = input.nextLine();
                        }
                }
            }
            if (!allServicesBool) {
                switch (userInput) {
                    case "11":
                        userArgs = "";
                        picked = true;
                        break;
                    case "21":
                        userArgs = " -sfm_resolution 8640 -w 15360 -h 8640";
                        picked = true;
                        break;
                    case "1":
                        userArgs = " -nosteam";
                        picked = true;
                        break;
                    case "2":
                        userArgs = " -nosteam -sfm_resolution 8640 -w 15360 -h 8640";
                        picked = true;
                        break;
                    case "3":
                        userArgs = "3";
                        picked = true;
                        break;
                    default:
                        Boolean warningSent;
                        if (warningSent = false) {
                            println("Invalid input");
                            println("Please type in one of the numbers above.");
                            print("User Input: ");
                            userInput = input.nextLine();
                            warningSent = true;
                        } else {
                            print("User Input: ");
                            userInput = input.nextLine();
                        }
                }
            }

        } catch (Exception e) {
            println("");
            println("An ERROR has occurred. Cuz someone have been a dumbass most likely.");

//            switch (userInput) {
//                case "1":
//                    userArgs = "";
//                    picked = true;
//                    break;
//
//                case "2":
//                    userArgs = " -sfm_resolution 8640 -w 15360 -h 8640";
//                    picked = true;
//                    break;
//
//                case "11":
//                    userArgs = " -nosteam";
//                    picked = true;
//                    break;
//
//                case "21":
//                    userArgs = " -nosteam -sfm_resolution 8640 -w 15360 -h 8640";
//                    picked = true;
//                    break;
//                default:
//                    Boolean warningSent;
//                    if (warningSent = false) {
//                        println("Invalid input");
//                        println("Please type in one of the numbers above.");
//                        print("User Input: ");
//                        userInput = input.nextLine();
//                        warningSent = true;
//                    } else {
//                        print("User Input: ");
//                        userInput = input.nextLine();
//                    }
//            }
        }


        Runtime runTime = Runtime.getRuntime();
        if(userArgs != "3")
        {
            String executablePath = sfmPath + "\\sfm.exe" + userArgs;
            println("Launching Executable: " + executablePath);
            runTime.exec(executablePath);
        }

        else if(userArgs == "3")
        {
            Desktop.getDesktop().open(new File(sfmPath));
        }
        println("");
        println("Thanks for using Shift's SFM Quickstart.");
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    //https://intellipaat.com/community/39035/preferred-java-way-to-ping-an-http-url-for-availability
    //https://java2blog.com/how-to-ping-url-and-get-status-in-java/
    public static boolean pingSteam() {
        try {
            return InetAddress.getByName("steamcommunity.com").isReachable(100);
        } catch (IOException e) {
            return false;

//        HttpURLConnection connection = null;

//        try {
//            //println("Debugging: Giving URL");
//            URL u = new URL("https://steamcommunity.com/");
//
//            //println("Debugging: u.OpenConnection");
//            connection = (HttpURLConnection) u.openConnection();
//
//            //println("Debugging: setRequestMethod to Head");
//            connection.setRequestMethod("HEAD");
//
//            //println("Debugging: Setting timeout");
//            connection.setConnectTimeout(1000); //wHY THE FUCK IS THIS NOT WORKING LIKE IT SHOULD!??? if I take it over 10, it uses like 30 seconds.
//            //println("Debugging: Connecting");
//            connection.connect();
//            //println("Debugging: Connected/Timeout");
//
//            int code = connection.getResponseCode();
//            boolean steamStatusBool;
//            steamStatusBool = code == 200; // if (code == 200) {steamStatusBool = true} else {steamStatusBool = false}
//            connection.disconnect();
//            //println("Connection test finished");
//            return steamStatusBool;
//
//
//            // You can determine on HTTP return code received. 200 is success.
//
//        } catch (IOException e) {
//
//            // TODO Auto-generated catch block
//
//            //e.printStackTrace();
//            //println("Debugging: EXCEPTION!");
//
//        } finally {
//
//            if (connection != null) {
//
//                connection.disconnect();

//            }

        }
    }

    //https://stackoverflow.com/questions/19005410/check-if-some-exe-program-is-running-on-the-windows
    public static Boolean processSteam() throws IOException {
        String line;
        String pidInfo = "";

        Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

        while ((line = input.readLine()) != null) {
            pidInfo += line;
        }

        input.close();

        if (pidInfo.contains("steam.exe")) {
            return true;
        } else {
            return false;
        }
    }

    //https://stackoverflow.com/questions/19005410/check-if-some-exe-program-is-running-on-the-windows
    public static Boolean processSteamServices() throws IOException {
        String line;
        String pidInfo = "";

        Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

        while ((line = input.readLine()) != null) {
            pidInfo += line;
        }

        input.close();

        if (pidInfo.contains("SteamService.exe")) {
            return true;
        } else {
            return false;
        }
    }

    public static void cls() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void logo() {
        println("");
        println("  ///////////////////////////////////////");
        println(" ///SFM Quickstart V2.7.3 by ShiftTGC///");
        println("///////////////////////////////////////");
    }

    public static void question() {

    }

    public static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            SFM.class.getResourceAsStream("/path/to/sounds/" + url));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}