package depaul.edu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class Logger {
	
	//This file can be found inside the root folder FinalProject when opened using File Explorer
	private static final String LOG_FILE = "log.txt";
	
    public static void log(String message) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE, true);
        	 PrintWriter printWriter = new PrintWriter(fileWriter)) {
        	LocalDateTime timestamp = LocalDateTime.now();
            printWriter.println("[" + timestamp + "] " + " - " + message);
        } catch (IOException e) {
        	System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public static void logError(String errorMessage) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE, true);
           	 PrintWriter printWriter = new PrintWriter(fileWriter)) {
           	LocalDateTime timestamp = LocalDateTime.now();
               printWriter.println("[" + timestamp + "] " + " - " + "ERROR: " + errorMessage);
           } catch (IOException e) {
           	System.err.println("Error writing to log file: " + e.getMessage());
           }
    }
    
}
