/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hostel_management_system.frontend;

import com.mycompany.hostel_management_system.backend.entity.FutureFeeDetails;
import com.mycompany.hostel_management_system.backend.entity.StudentFee;
import com.mycompany.hostel_management_system.backend.service.StudentFeeService;
import com.mycompany.hostel_management_system.backend.util.StudentFeeStatus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class StudentFees extends javax.swing.JFrame {

    private final StudentFeeService service = new StudentFeeService();
    private int selectedId = 0;
    
    public StudentFees() {
        initComponents();
        setTitle("Student Fee Management Page");
        idField.setVisible(false);
        
//        saveButton.addActionListener((java.awt.event.ActionEvent evt) -> {
//            try {
//                // Get the index and grade from the fields
//                int studentIndex = Integer.parseInt(indexField.getText());
//                String grade = gradeField.getSelectedItem().toString();
//                
//                // Check if the PAID checkbox is selected
//                boolean isPaid = paidCheckBox.isSelected();
//                
//                // If the PAID checkbox is selected, update the status
//                String status = isPaid ? "PAID" : "PENDING";
//                
//                // Update the fee in the database
//                service.markFeeAsPaid(studentIndex, grade);
//                
//                // Find the corresponding row in the JTable and update the status
//                for (int row = 0; row < feeTable.getRowCount(); row++) {
//                    int tableIndex = Integer.parseInt(feeTable.getValueAt(row, 1).toString()); // Column 1 is index
//                    String tableGrade = feeTable.getValueAt(row, 5).toString(); // Column 5 is grade
//                    
//                    if (tableIndex == studentIndex && tableGrade.equals(grade)) {
//                        // Update the status in the JTable model
//                        feeTable.setValueAt(status, row, 6); // Column 6 is status
//                        break;
//                    }
//                }
//                
//                JOptionPane.showMessageDialog(null, "Fee status updated to " + status + " successfully!");
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Error updating fee status: " + e.getMessage());
//            }
//        });

        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFees();
            }
        });
        
        searchByYearButton.addActionListener(new ActionListener() {
         @Override
        public void actionPerformed(ActionEvent e) {
         searchFeesByYear();
            }
       });
        
        clearButton.addActionListener(new ActionListener() {
          @Override
        public void actionPerformed(ActionEvent e) {
              clearAll();
            }
       });
        
        // Add a MouseListener to the JTable
     feeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            private int selectedId;
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        // Check for double-click
        if (evt.getClickCount() == 1) {
            
            // Get the selected row
            int selectedRow = feeTable.getSelectedRow();
            
            if (selectedRow != -1) { // Ensure a row is selected
                // Retrieve values from the selected row
                String index = feeTable.getValueAt(selectedRow, 1).toString();
                
                String amount = feeTable.getValueAt(selectedRow, 3).toString();
               
                String grade = feeTable.getValueAt(selectedRow, 5).toString();
                String status = feeTable.getValueAt(selectedRow, 6).toString();

                // Populate the fields
                indexField.setText(index);
                
                amountField.setText(amount);
                
                gradeField.setSelectedItem(grade); // Assuming gradeField is a JComboBox
                
                idField.setText(feeTable.getValueAt(selectedRow, 0).toString());
                // Optionally, handle the status if required
            }
        }
    }
        });

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        indexField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        amountField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        feeTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        academicYearField = new javax.swing.JTextField();
        searchByYearButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        gradeField = new javax.swing.JComboBox<>();
        paidCheckBox = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STUDENT FEE MANAGEMENT PAGE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setText("INDEX");

        jLabel3.setText("DATE");

        jLabel4.setText("AMOUNT");

        searchButton.setBackground(new java.awt.Color(0, 153, 102));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder (3)\\search.png")); // NOI18N
        searchButton.setText("SEARCH");

        feeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "INDEX NUMBER", "DATE", "AMOUNT", "ACCADAMIC YEAR", "GRADE", "STATUS"
            }
        ));
        feeTable.setGridColor(new java.awt.Color(0, 0, 0));
        feeTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        feeTable.setShowGrid(true);
        jScrollPane1.setViewportView(feeTable);

        saveButton.setBackground(new java.awt.Color(0, 153, 102));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder (3)\\save.png")); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("ACADAMIC YEAR");

        searchByYearButton.setBackground(new java.awt.Color(0, 153, 102));
        searchByYearButton.setForeground(new java.awt.Color(255, 255, 255));
        searchByYearButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder (3)\\search.png")); // NOI18N
        searchByYearButton.setText("SEARCH BY YEAR");

        clearButton.setBackground(new java.awt.Color(0, 153, 102));
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder (3)\\deleteinroompage.png")); // NOI18N
        clearButton.setText("CLEAR ALL");

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("GRADE");

        gradeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "grade 6", "grade 7", "grade 8", "grade 9", "grade 10", "grade 11", "grade 12", " ", " ", " " }));

        jLabel8.setText("PAID");

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(saveButton)
                            .addComponent(clearButton)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(indexField)
                                            .addComponent(dateField)
                                            .addComponent(amountField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                                        .addGap(101, 101, 101)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(searchByYearButton)
                                            .addComponent(searchButton)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(idField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(gradeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(academicYearField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paidCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(indexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(academicYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchByYearButton))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(gradeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paidCheckBox)
                            .addComponent(jLabel8))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6)
                        .addGap(43, 43, 43)
                        .addComponent(saveButton)
                        .addGap(31, 31, 31)
                        .addComponent(clearButton)
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomePage homeList = new HomePage();
        homeList.setVisible(true);
        homeList.pack();
        homeList.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
       
    }//GEN-LAST:event_idFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String payDate = dateField.getText();
        String academicYear = academicYearField.getText();
        String  paymentStatus = paidCheckBox.isSelected() ? StudentFeeStatus.PAID.toString() : StudentFeeStatus.PENDING.toString();
        
        int feeId = Integer.parseInt(idField.getText());
        
        StudentFeeService studentFeeService = new StudentFeeService();
        studentFeeService.markFeeAsPaid(academicYear, payDate, paymentStatus, feeId);
    }//GEN-LAST:event_saveButtonActionPerformed

   
    public static void main(String args[]) {
        new StudentFees ();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentFees().setVisible(true);
            }
        });
    }
    
    private void saveFee(){
        try{
             StudentFee fee = new StudentFee();
             fee.setStudentIndex(Integer.parseInt(indexField.getText()));
             fee.setDate(dateField.getText());
             fee.setAmaount(Double.parseDouble(amountField.getText()));
             fee.setAccadamic_year(academicYearField.getText());
             String selectedGrade = gradeField.getSelectedItem().toString();
             fee.setGrade(selectedGrade);
             fee.setStatus(paidCheckBox.getText());
             service.saveFee(fee);
             JOptionPane.showMessageDialog(this, "Fee saved successfully!");
              
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error saving fee: " + e.getMessage());
        }
    }
    
    
    private void searchFees(){
        try{
            String studentIndex = indexField.getText();
            ArrayList<StudentFee> fees = service.getFeesByIndex(studentIndex);
            
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Index", "Date", "Amount","Accadamic_year","grade","status"}, 0);
            for (StudentFee fee : fees) {
                model.addRow(new Object[]{fee.getId(), fee.getStudentIndex(), fee.getDate(), fee.getAmaount(),fee.getAccadamic_year(),fee.getGrade(),fee.getStatus()});
                feeTable.setModel(model);
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error retrieving fees: " + e.getMessage());
        }
    }
    
    private void searchFeesByYear(){
        try{
            String academicYear = academicYearField.getText();
            ArrayList<StudentFee> fees = service.getPaidStudentsByAcademicYear(academicYear);
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Index", "Date", "Amount", "Academic Year","grade","status"}, 0);
            for (StudentFee fee : fees){
                model.addRow(new Object[]{fee.getId(), fee.getStudentIndex(), fee.getDate(), fee.getAmaount(), fee.getAccadamic_year(),fee.getGrade(),fee.getStatus()});
                
            }
            feeTable.setModel(model);
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error retrieving fees by year: " + e.getMessage()); 
        }
    }
    
    
    private void clearAll(){
       indexField.setText("");
       dateField.setText("");
       amountField.setText("");
       academicYearField.setText("");
       
      gradeField.setSelectedItem(0);
       
       DefaultTableModel tableModel = (DefaultTableModel) feeTable.getModel();
       tableModel.setRowCount(0);
      
   }
    
    // Add a MouseListener to the JTable


    
   
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField academicYearField;
    private javax.swing.JTextField amountField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JTable feeTable;
    private javax.swing.JComboBox<String> gradeField;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField indexField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox paidCheckBox;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchByYearButton;
    // End of variables declaration//GEN-END:variables
}
