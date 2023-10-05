/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cafeteria.cli;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ASUS
 */
public class Orders {
    public String OrderID;
    public String ItemName;
    public String Quantity;
    public String ItemTotalPrice;
    public String TableNum;
    public String OrdererID;   
    
    
    
    
    public boolean isOrderValid(String orderID) throws IOException{
    
      FileReader filereader = null;
        try {
            filereader = new FileReader("src/Cafeteria/data/Orders.txt");
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String orderDetails;
            while((orderDetails = bufferedReader.readLine()) != null){
                String[] Arrayorder = orderDetails.split(",");
                if(Arrayorder[0].equals(orderID)){
                return true;
                }
            }
            filereader.close();
            bufferedReader.close();
            return false;     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                filereader.close();
            } catch (IOException ex) {
                Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
      
    }
}
