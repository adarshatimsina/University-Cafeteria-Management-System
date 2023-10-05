/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cafeteria.gui;


import Cafeteria.cli.Orders;
import Cafeteria.cli.OrdersHandler;
import java.awt.FileDialog;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List; // For List
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ReportGenerator extends javax.swing.JFrame {

    /**
     * Creates new form ReportGenerator
     */
    public ReportGenerator() {
        initComponents();
        reportHeader();
        
    }
    
    private void reportHeader(){
        txtReportField.setText("======================================================================================================== \n "  
                             + "                        ASIA PACIFIC UNIVERSITY CAFETERIA         " + "\n"
                             + "                                                Fulbari,Pokhara                    " + "\n"
                             + "========================================================================================================"+ "\n"
                             + "                                                CAFETERIA BILL                    " + "\n"
                             + "========================================================================================================"+ "\n"
                             + "                         ENJOY YOUR MEAL AND HAVE A GOOD HEALTH         " + "\n\n"
                             + "  ----------------------------------------------------------------------------------------------------  "+ "\n"
                             + " | Item Name                         |      ItemQuantity          |                 Price        \n"
                             + "  ----------------------------------------------------------------------------------------------------  "+ "\n" );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtOrderID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        txtOrderid = new javax.swing.JTextField();
        txtOrderedBy = new javax.swing.JTextField();
        txtTotalPrice = new javax.swing.JTextField();
        txtReportField = new java.awt.TextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Enter Order ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, -1, -1));

        txtOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 230, 50));

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 160, 40));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Items", "Quantity", "Total Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setResizable(false);
            orderTable.getColumnModel().getColumn(1).setResizable(false);
            orderTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 480, 290));

        txtOrderid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOrderid.setText("OrderID");
        jPanel1.add(txtOrderid, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 90, 30));

        txtOrderedBy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOrderedBy.setText("Ordered By");
        jPanel1.add(txtOrderedBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 700, 190, 30));

        txtTotalPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalPrice.setText("Total Price");
        jPanel1.add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 700, 130, -1));
        jPanel1.add(txtReportField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 273, 520, 510));

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cafeteria/images/ReportGenerator.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 790));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderIDActionPerformed

           
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
    txtReportField.setText("");
    reportHeader();
    DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
    dtm.setRowCount(0);   
    String orderID = txtOrderID.getText();
    OrdersHandler handler = new OrdersHandler();
    List<Orders> matchingOrders = handler.orderReportGiver(orderID);

    if (!matchingOrders.isEmpty()) {

        double total = 0.0; // Initialize total price
        String orderId = ""; // Initialize orderId
        String orderedBy = ""; // Initialize orderedBy
        StringBuilder reportBuilder = new StringBuilder(); //1
        int count = 0;
        
        for (Orders data : matchingOrders) {
            count = count+1;
            String ItemName = data.ItemName;
            String Quantity = data.Quantity;
            String ItemTotalPrice = data.ItemTotalPrice;           
            dtm.addRow(new Object[]{ItemName, Quantity, ItemTotalPrice});
            //reportBuilder.append(    ItemName   ).append("\t\t\t\t").append(Quantity).append("         \t\t          ").append(ItemTotalPrice).append("\n");//2
            // Accumulate total price 
            reportBuilder.append(String.format(" %-2d. %-50s  %-40s %-20s \n",count, ItemName, Quantity, ItemTotalPrice));
            total += Double.parseDouble(ItemTotalPrice);

            // Assign orderId and orderedBy from the first matching order
            if (orderId.isEmpty()) {
                orderId = data.OrderID;
                orderedBy = data.OrdererID;
            }
        }
        txtTotalPrice.setText(String.valueOf(total));
        txtOrderid.setText(orderId);
        txtOrderedBy.setText(orderedBy);
        
        reportBuilder.append("  ----------------------------------------------------------------------------------------------------------------  ");
        reportBuilder.append("\n\t\t\t\t\tTotal Amount: Rs.").append(total).append("\n\n");
        reportBuilder.append("============================================================================================\n");
        reportBuilder.append("Ordered By :").append(orderedBy.toUpperCase()).append("\n");
        reportBuilder.append("Invoice Number:").append(orderId).append("\n");
        reportBuilder.append("============================================================================================\n");
        reportBuilder.append("****************************** VISIT US AGAIN! ************************\n");
        reportBuilder.append("****************************** VISIT US AGAIN! ************************\n");
        reportBuilder.append("****************************** VISIT US AGAIN! ************************\n");
        
        txtReportField.append(reportBuilder.toString());
        // Disable editing for order ID and orderer ID
        txtOrderid.setEditable(false);
        txtOrderedBy.setEditable(false);
        txtTotalPrice.setEditable(false);

        System.out.println("OK");
    } else {
        System.out.println("No matching orders found for OrderID: " + orderID);
    }



        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    try {
        String content = txtReportField.getText();

        // Create a file chooser dialog
        FileDialog fileDialog = new FileDialog(this, "Save to File", FileDialog.SAVE);
        
        // Set a file filter to suggest ".txt" extension
        fileDialog.setFile("*.txt");
        
        fileDialog.setVisible(true);

        // Get the selected file name
        String fileName = fileDialog.getDirectory() + fileDialog.getFile();

        // Ensure the file has a ".txt" extension
        if (!fileName.toLowerCase().endsWith(".txt")) {
            fileName += ".txt";
        }

        // Write the content to the selected file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        StaffMainPage smp = new StaffMainPage();
        this.hide();
        smp.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportGenerator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    private javax.swing.JTextField txtOrderID;
    private javax.swing.JTextField txtOrderedBy;
    private javax.swing.JTextField txtOrderid;
    private java.awt.TextArea txtReportField;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables
}