/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cafeteria.cli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ASUS
 */
public class Admins extends Users{
    
    public static Admins adminDetailsReader(String Username) throws FileNotFoundException, IOException{
        
        FileReader filereader = new FileReader("src/Cafeteria/data/Staffs.txt");
        BufferedReader bufferedReader = new BufferedReader(filereader);
        String staffDetails;
        while(( staffDetails = bufferedReader.readLine()) != null){
            String[] Unparted_staff_Details = staffDetails.split(",");
            if(Unparted_staff_Details[0].equals(Username))
            {
                Admins staff = new Admins();
                staff.Name = Unparted_staff_Details[2];
                staff.UserID = Unparted_staff_Details[0];
                staff.Password = Unparted_staff_Details[1];                
                return staff;
            }                              
        }
        filereader.close(); 
        bufferedReader.close();
      return null;
    
    }
    
  
    public boolean authenticateStaff(String username , String password) throws IOException{
        
        Admins staff =  adminDetailsReader(username);
        if(staff == null)
        {
            return false;
        }
        if(username.equals(staff.UserID) && password.equals(staff.Password)){
            return true;
        }
        return false;
    }
    
    
    public void registerStudent(String UserID, String Password, String Name){
        
        FileWriter filewriter;
        try {
            filewriter = new FileWriter("src/Cafeteria/data/Students.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
            bufferedWriter.write(UserID.toLowerCase()+","+Password+","+Name);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void registerStaff(String UserID,String Password, String Name) throws IOException{
        FileWriter filewriter;
        
            filewriter = new FileWriter("src/Cafeteria/data/Staffs.txt",true);
        try (BufferedWriter bufferedWriter = new BufferedWriter(filewriter)) {
            bufferedWriter.write(UserID.toLowerCase()+","+Password+","+Name);
            bufferedWriter.newLine();
        }
            
       
            
    }
    

    
}




