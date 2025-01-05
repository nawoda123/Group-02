/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hostel_management_system.frontend;

import com.mycompany.hostel_management_system.backend.dao.NewStudetDao;
import com.mycompany.hostel_management_system.backend.entity.NewStudentDetails;
import com.mycompany.hostel_management_system.backend.entity.RoomDetail;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.hostel_management_system.backend.service.NewStudentService;
import com.mycompany.hostel_management_system.backend.service.RoomService;

/**
 *
 * @author DELL
 */
public class UpdateAndDeleteStudent extends javax.swing.JFrame {
   private NewStudetDao newStudentDao=new NewStudetDao();
   NewStudentDetails student = null; 
 
    /**
     * Creates new form UpdateAndDeleteStudent
     */
    public UpdateAndDeleteStudent() {
        initComponents();
        searchButton.addActionListener((ActionEvent e) -> {
            searchStudent();
        });
        
        jButton1.addActionListener((ActionEvent e) -> {
            updateStudent();
        } // Update Button
        );
        
        DeleteStudentButton.addActionListener((ActionEvent e) -> {
            deleteStudent();
        } // Delete Button
        );
       
    }
    
    private void searchStudent() {
        String indexNumber = indexField.getText();

        if (indexNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the index number to search.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isValidIndexNumber(indexNumber)) {
        JOptionPane.showMessageDialog(this, "Index number must have exactly 6 digits.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return; // Stop the process if validation fails
    }

        student =newStudentDao.getStudentByIndex(Integer.parseInt(indexNumber));
        if (student != null) {
            nameField.setText(student.getName());
            addressField.setText(student.getAddress());
            contactNumberField.setText(String.valueOf(student.getContactNumber()));
            guardianNameField.setText(student.getGName());
            guardianContactField.setText(String.valueOf(student.getGNumber()));
            roomNumberField.setText(String.valueOf(student.getRoomNumber()));
        } else {
            JOptionPane.showMessageDialog(this, "Student not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean isValidIndexNumber(String indexNumber) {
    return indexNumber.matches("^\\d{6}$");
}
    
    private void updateStudent() {
    String indexNumber = indexField.getText().trim();
    String fullName = nameField.getText().trim();
    String address = addressField.getText().trim();
    String contactNumber = contactNumberField.getText().trim();
    String guardianName = guardianNameField.getText().trim();
    String guardianContact = guardianContactField.getText().trim();
    String roomNumber = roomNumberField.getText().trim();

    if (indexNumber.isEmpty() || fullName.isEmpty() || address.isEmpty() || contactNumber.isEmpty() ||
        guardianName.isEmpty() || guardianContact.isEmpty() || roomNumber == null) {
        JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
     if (!isValidContactNumber(contactNumber)) {
        JOptionPane.showMessageDialog(this, "Student contact number must have exactly 10 digits and start with 0.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return;
    }
     if (!isValidContactNumber(guardianContact)) {
        JOptionPane.showMessageDialog(this, "Guardian contact number must have exactly 10 digits and start with 0.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return;
    }

    NewStudentDetails student = new NewStudentDetails();

    try {
        student.setIndex(Integer.parseInt(indexNumber));
        student.setName(fullName);
        student.setContactNumber(Integer.parseInt(contactNumber));
        student.setAddress(address);
        student.setGName(guardianName); // Correct assignment
        student.setGNumber(Integer.parseInt(guardianContact));
        student.setRoomNumber(Integer.parseInt(roomNumber));

        boolean isUpdated = newStudentDao.updateStudent(student);

        if (isUpdated) {
            JOptionPane.showMessageDialog(this, "Student updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update student.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numeric values for index, contact, and room number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private boolean isValidContactNumber(String contactNumber) {
    return contactNumber.matches("^0\\d{9}$"); // Starts with 0 and has exactly 10 digits
}

    
     private void deleteStudent() {
        String indexNumber = indexField.getText().trim();

        if (indexNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the index number to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
             boolean isDeleted;// Use the DAO
            isDeleted = newStudentDao.deleteStudent(Integer.parseInt(indexNumber));

            if (isDeleted) {
                JOptionPane.showMessageDialog(this, "Student deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                clearFields();
                AllStudentLeaved leavedFrame = new AllStudentLeaved();
                leavedFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete student.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        indexField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        contactNumberField = new javax.swing.JTextField();
        guardianNameField = new javax.swing.JTextField();
        guardianContactField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        DeleteStudentButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        roomNumberField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UPDATE & DELETE STUDENTS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
        );

        jLabel2.setText("INDEX NUMBER");

        jLabel3.setText("FULL NAME");

        jLabel4.setText("PARMENENT ADDRESS");

        jLabel5.setText("CONTACT NUMBER");

        jLabel6.setText("GURDIAN'S NAME");

        jLabel7.setText("GURDIAN'S CONTACT NUMBER");

        jLabel8.setText("ROOM NUMBER");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder (3)\\updateinroompage.png")); // NOI18N
        jButton1.setText("UPDATE");

        DeleteStudentButton.setBackground(new java.awt.Color(0, 153, 102));
        DeleteStudentButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteStudentButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder (3)\\deleteinroompage.png")); // NOI18N
        DeleteStudentButton.setText("DELETE");
        DeleteStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteStudentButtonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder (3)\\clearall.png")); // NOI18N
        jButton3.setText("CLEAR");

        searchButton.setBackground(new java.awt.Color(0, 153, 102));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder (3)\\search.png")); // NOI18N
        searchButton.setText("SEARCH");

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("BACK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(81, 81, 81)
                        .addComponent(DeleteStudentButton)
                        .addGap(78, 78, 78)
                        .addComponent(jButton3))
                    .addComponent(nameField)
                    .addComponent(addressField)
                    .addComponent(contactNumberField)
                    .addComponent(guardianNameField)
                    .addComponent(guardianContactField, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(indexField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(searchButton))
                    .addComponent(roomNumberField))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton5)))
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(indexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(contactNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(guardianNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(guardianContactField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(roomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(DeleteStudentButton)
                    .addComponent(jButton3))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void DeleteStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteStudentButtonActionPerformed
          try{
            // release room occupation
            RoomService roomService = new RoomService();
            RoomDetail roomDetail = roomService.getRoomDetailsById(this.student.getRoomNumber());
            roomService.updateFreeCount(roomDetail.getRoomNumber(), roomDetail.getFreeBoardingCount()+1);
            
            // delete student from database
            NewStudentService newStudentService = new NewStudentService();
            newStudentService.deleteStudent(this.student.getIndex());
          }catch(Exception ex){
              ex.printStackTrace();
          }
          
    }//GEN-LAST:event_DeleteStudentButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        HomePage homepage = new HomePage();
        homepage.setVisible(true);
        homepage.pack();
        homepage.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new UpdateAndDeleteStudent().setVisible(true);
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateAndDeleteStudent().setVisible(true);
            }
        });
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteStudentButton;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField contactNumberField;
    private javax.swing.JTextField guardianContactField;
    private javax.swing.JTextField guardianNameField;
    private javax.swing.JTextField indexField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField roomNumberField;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        indexField.setText("");
        nameField.setText("");
        addressField.setText("");
        contactNumberField.setText("");
        guardianNameField.setText("");
        guardianContactField.setText("");
        roomNumberField.setText("");
}
}

