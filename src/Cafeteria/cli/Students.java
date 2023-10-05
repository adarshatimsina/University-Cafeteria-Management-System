/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cafeteria.cli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ASUS
 *
 * 
**/


public class Students extends Users{    
    
public static Students studentDetailsReader(String username) throws FileNotFoundException, IOException{
    
        FileReader fileReader = new FileReader("src/Cafeteria/data/Students.txt");
        
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String studentDetails;
        while((studentDetails = bufferedReader.readLine()) != null)
        {
            String[] Unparted_students_details = studentDetails.split(",");
            if(Unparted_students_details[0].equals(username))
            {
                Students student = new Students();
                student.UserID = Unparted_students_details[0];
                student.Name = Unparted_students_details[2];
                student.Password = Unparted_students_details[1];
                fileReader.close();
                bufferedReader.close();
                
                return student;      
            }
            
        }
        fileReader.close(); 
        bufferedReader.close();
              
    return null;
}

public static boolean authenticateStudent(String Username,String Password) throws IOException
    {
      Students student = Students.studentDetailsReader(Username);
      if(student == null){
          return false;
      }
    return !(!Username.equals(student.UserID) || !Password.equals(student.Password));
  }
    

public String PasswordGiver(String Username) throws FileNotFoundException{
    FileReader fileReader = new FileReader("src/Cafeteria/data/Students.txt");      
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String studentDetails;
    try {
        while((studentDetails = bufferedReader.readLine()) != null)
        {
            String[] Unparted_students_details = studentDetails.split(",");
            if(Unparted_students_details[0].equals(Username))
            {
                String password = Unparted_students_details[1];
                fileReader.close();
                bufferedReader.close();
                return password;
                
            }
            
        }        
    } catch (IOException ex) {
        Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}


    
//public boolean changePassword(String Username,String CurrentPass, String NewPass){
//            
//    try {
//        Students Data = new Students();
//        String RealCurrentPass = Data.PasswordGiver(Username);     
//        if (RealCurrentPass.equals(CurrentPass)) {
//            FileReader fileReader = null;
//            try {               
//                File StudentFile = new File("src/Cafeteria/data/Students.txt");
//                File tempStudentFile = new File("src/Cafeteria/data/tempStudents.txt");
//                fileReader = new FileReader(StudentFile);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                FileWriter fileWriter = new FileWriter(tempStudentFile);
//                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                String StudentDetails;
//                while ((StudentDetails = bufferedReader.readLine()) != null) {
//                    String[] DetailsArray = StudentDetails.split(",");
//                    if (Username.equals(DetailsArray[0])) {
//                        bufferedWriter.write(DetailsArray[0] + "," + NewPass + "," + DetailsArray[2]);
//                    } else {
//                        bufferedWriter.write(StudentDetails);
//                    }
//                    bufferedWriter.newLine();
//                }
//                bufferedReader.close();
//                bufferedWriter.close();                              
//                StudentFile.delete();
//                tempStudentFile.renameTo(new File("src/Cafeteria/data/Students.txt"));
//                
//                return true;
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                //Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
//                Logger.getLogger(Students.class.getName()).log(Level.SEVERE, "IO error: " + ex.getMessage());
//            }
//        }
//        else{
//            return false;
//        }
//    } catch (IOException ex) {
//        Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return false;
//    }

public boolean changePassword(String Username, String CurrentPass, String NewPass) throws IOException {
    Students Data = new Students();
    String RealCurrentPass = Data.PasswordGiver(Username);
    if (RealCurrentPass.equals(CurrentPass)) {
        try {
            File StudentFile = new File("src/Cafeteria/data/Students.txt");
            File tempStudentFile = new File("src/Cafeteria/data/tempStudents.txt");

            FileReader fileReader = new FileReader(StudentFile);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);
                 FileWriter fileWriter = new FileWriter(tempStudentFile);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 

                String StudentDetails;
                while ((StudentDetails = bufferedReader.readLine()) != null) {
                    String[] DetailsArray = StudentDetails.split(",");
                    if (Username.equals(DetailsArray[0])) {
                        bufferedWriter.write(DetailsArray[0] + "," + NewPass + "," + DetailsArray[2]);
                    } else {
                        bufferedWriter.write(StudentDetails);
                    }
                    bufferedWriter.newLine();
                }
            bufferedWriter.close();  
            bufferedReader.close();
            // Rename the temporary file to the original file name.
            StudentFile.delete();
            tempStudentFile.renameTo(new File("src/Cafeteria/data/Students.txt"));
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        return false;
    }
    return false;
}

public void deleteUser(String Username) {
    try {
        Username = Username.toLowerCase();
        File studentFile = new File("src/Cafeteria/data/Students.txt");
        File tempStudentFile = new File("src/Cafeteria/data/tempStudents.txt");
        FileReader fileReader = new FileReader(studentFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(tempStudentFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String studentDetails;

        while ((studentDetails = bufferedReader.readLine()) != null) {
            String[] detailsArray = studentDetails.split(",");
            if (!Username.equals(detailsArray[0])) {
                bufferedWriter.write(studentDetails);
                bufferedWriter.newLine();
            } else {
                // If the username matches, skip writing this line, effectively deleting the user.
            }
        }

        bufferedWriter.close();
        bufferedReader.close();

        // Delete the original file and rename the temporary file
        if (studentFile.delete()) {
            if (tempStudentFile.renameTo(new File("src/Cafeteria/data/Students.txt"))) {
                System.out.println("User deleted successfully.");
            } else {
                System.err.println("Failed to rename the temporary file.");
            }
        } else {
            System.err.println("Failed to delete the user. The user may not exist.");
        }
    } catch (IOException ex) {
        Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
    }
}



}
