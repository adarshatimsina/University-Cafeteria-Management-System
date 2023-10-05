/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cafeteria.cli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class LoginLogger {
    
    private static final String LOG_FILE_PATH = "src/Cafeteria/data/login_log.txt";

    public static void logLogin(String username, String userType) throws IOException {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logEntry = "User '" + username + "' (" + userType + ") logged in at " + timestamp + "\n";
        try (FileWriter fw = new FileWriter(LOG_FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(logEntry);
        }
    }
    
    
    
   public static void logUserDeletion(String staffUsername, String deletedUsername) throws IOException {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logEntry = "Staff '" + staffUsername + "' deleted details of '" + deletedUsername + "' at " + timestamp + "\n";
        try (FileWriter fw = new FileWriter(LOG_FILE_PATH, true); // true for append mode
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(logEntry);
        }
    }
   
   
    public static void logLogout(String username, String userType) throws IOException {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logEntry = "User '" + username + "' (" + userType + ") logged out at " + timestamp + "\n";

        try (FileWriter fw = new FileWriter(LOG_FILE_PATH, true); // true for append mode
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(logEntry);
        }
    }
   
   
   
   
}

