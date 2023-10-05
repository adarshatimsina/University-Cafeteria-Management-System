/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cafeteria.cli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class OrdersHandler {
     public List<Orders> orderReportGiver(String OrderID) {
        List<Orders> matchingOrders = new ArrayList<>();
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Cafeteria/data/Orders.txt"))) {
            String OrderDetails;
            while ((OrderDetails = bufferedReader.readLine()) != null) {
                String[] ArrayOfDetails = OrderDetails.split(",");
                
                if (ArrayOfDetails.length >= 6 && OrderID.equals(ArrayOfDetails[0])) {
                    Orders data = new Orders();
                    data.OrderID = ArrayOfDetails[0];
                    data.ItemName = ArrayOfDetails[1];
                    data.Quantity = ArrayOfDetails[2];
                    data.ItemTotalPrice = ArrayOfDetails[3];
                    data.TableNum = ArrayOfDetails[4];
                    data.OrdererID = ArrayOfDetails[5];
                    matchingOrders.add(data);
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading Orders.txt: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        if (!matchingOrders.isEmpty()) {
            System.out.println("Successful Reading");
        } else {
            System.out.println("No matching orders found for OrderID: " + OrderID);
        }
        
        return matchingOrders;
    }
    
}
