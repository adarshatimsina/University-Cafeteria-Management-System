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
 */
public class Menu {
    
    public String ItemID;
    public String ItemName;
    public String ItemPrice;
    public String ItemStatus;
    public String ItemCategory;
    
    
    public void addItemToMenu(String ItemID,String ItemName, Double ItemPrice, String ItemStatus, String ItemCategory){
    
        try {
            FileWriter fileWriter = new FileWriter("src/Cafeteria/data/Menu.txt",true);
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(ItemID+","+ItemName+","+ItemPrice+","+ItemStatus+","+ItemCategory);
                bufferedWriter.newLine();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public String priceReturner(String ItemName) throws IOException{
        
        try {
            FileReader filereader = null;
            
            filereader = new FileReader("src/Cafeteria/data/Menu.txt");
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String menuDetails;
            while ((menuDetails = bufferedReader.readLine()) != null) {
                String[] DetailsArray = menuDetails.split(",");
                if (ItemName.equals(DetailsArray[1])) {
                    return DetailsArray[2];
                }
                         }
            return null;            
        } catch (IOException iOException) {
        }
     return null;
    }
    
    
    public void PaymentAdder(String OrderID, String TotalPrice, String Username) throws IOException{
    
        FileWriter filewriter = new FileWriter("src/Cafeteria/data/Payments.txt",true);
        BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
        bufferedwriter.write(OrderID+","+TotalPrice+","+Username);
        bufferedwriter.newLine();
        bufferedwriter.close();
    }
    
    
    public Menu menuReader(String username) throws IOException{
            
        FileReader filereader = null;
        try {
            filereader = new FileReader("src/Cafeteria/data/Menu.txt");
            BufferedReader buff = new BufferedReader(filereader);
            String MenuDetails;
            while((MenuDetails = buff.readLine()) != null){
                String[] DetailsArray = MenuDetails.split(",");
                if(username.equals(DetailsArray[0]))
                {
                    Menu me = new Menu();
                    me.ItemID = DetailsArray[0];
                    me.ItemName = DetailsArray[1];
                    me.ItemPrice = DetailsArray[2];
                    me.ItemCategory = DetailsArray[3];
                    me.ItemStatus = DetailsArray[4];
                    return me;
                    
                    
                }
            }   return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                filereader.close();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    
    public void changeItemData(String username , String newName , String newPrice , String newStatus, String newCategory){
        
        FileReader fileReader = null;
        try {
            File MenuFile = new File("src/Cafeteria/data/Menu.txt");
            File tempMenuFile = new File("src/Cafeteria/data/tempMenu.txt");
            fileReader = new FileReader(MenuFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempMenuFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String menuDetails;
            while((menuDetails = bufferedReader.readLine()) != null){
                String[] MenuArray = menuDetails.split(",");
                if(username.equals(MenuArray[0])){
                    bufferedWriter.write(MenuArray[0]+","+ newName +","+ newPrice+","+ newStatus +","+ newCategory);
                }
                else{
                    bufferedWriter.write(menuDetails);
                }
                bufferedWriter.newLine();                                      
            }
            bufferedWriter.close();
            bufferedReader.close();
            
            MenuFile.delete();
            tempMenuFile.renameTo(new File("src/Cafeteria/data/Menu.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    public void deleteItem(String FoodID) {
    try {
        File MenuFile = new File("src/Cafeteria/data/Menu.txt");
        File tempMenuFile = new File("src/Cafeteria/data/tempMenu.txt");

        FileReader fileReader = new FileReader(MenuFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(tempMenuFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String menuDetails;

        while ((menuDetails = bufferedReader.readLine()) != null) {
            String[] MenuArray = menuDetails.split(",");
            if (!FoodID.equals(MenuArray[0])) {
                bufferedWriter.write(menuDetails);
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.close();
        bufferedReader.close();

        // Delete the original file and rename the temporary file
        if (MenuFile.delete()) {
            if (tempMenuFile.renameTo(new File("src/Cafeteria/data/Menu.txt"))) {
                System.out.println("Item deleted successfully.");
            } else {
                System.err.println("Failed to rename the temporary file.");
            }
        } else {
            System.err.println("Failed to delete the item. The item may not exist.");
        }
    } catch (IOException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    

    
}
