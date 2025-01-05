/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.dao;

import com.mycompany.hostel_management_system.backend.config.DatabaseConnection;
import com.mycompany.hostel_management_system.backend.entity.FutureFeeDetails;
import com.mycompany.hostel_management_system.backend.entity.StudentFee;
import com.mycompany.hostel_management_system.backend.util.StudentFeeStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentFeeDao {
    public void saveStudentFee(int indexNumber,String date,double amount,String accadamic_year,String grade, String status){
        try{
        String saveFee="insert into student_fee (index_number,date,amount,accadamic_year,grade, status) values (?,?,?,?,?,?)";
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(saveFee);
        
        preparedStatement.setInt(1, indexNumber);
        preparedStatement.setString(2, date);
        preparedStatement.setDouble(3, amount);
        preparedStatement.setString(4,accadamic_year );
        preparedStatement.setString(5, grade);
        preparedStatement.setString(6, status);
        
        int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record was inserted successfully!");
            }

            preparedStatement.close();
        
    }catch(Exception e){
         System.out.println("exception is occuredn when save fee detail: " + e.getMessage());
         throw new RuntimeException();
    }finally{
            DatabaseConnection.closeConnection();
        }
}
    
    /**
     *
     */
    public ArrayList <StudentFee> getStudentFeeDetails(String studentIndex){
         ArrayList<StudentFee> fees = new ArrayList<>();
         
         try{
         String query = "SELECT * FROM student_fee WHERE index_number = ?";
         Connection connection = DatabaseConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, studentIndex);
        
         try(ResultSet resultSet = preparedStatement.executeQuery()){
              while(resultSet.next()){
                  StudentFee fee = new StudentFee();
                  fee.setId(resultSet.getInt("id"));
                  fee.setStudentIndex(resultSet.getInt("index_number"));
                  fee.setDate(resultSet.getString("date"));
                  fee.setAmaount(resultSet.getDouble("amount"));
                  fee.setAccadamic_year(resultSet.getString("accadamic_year"));
                  fee.setGrade(resultSet.getString("grade"));
                  fee.setStatus(resultSet.getString("status"));
                  fees.add(fee);
                  
            }
            resultSet.close();
            preparedStatement.close();
         
       }    
         
         
    }catch(Exception e){
       System.out.println("exception is occuredn when show fee detail: " + e.getMessage()); 
    }finally{
              DatabaseConnection.closeConnection();
         }
         return fees;
}
    
    
    public ArrayList<StudentFee> getStudentFeeDetailsByYear(String accadamicYear){
        ArrayList<StudentFee> fees = new ArrayList<>();
        
        try{
           String query = "SELECT * FROM student_fee WHERE accadamic_year = ?";
           Connection connection = DatabaseConnection.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1, accadamicYear);
           
           try(ResultSet resultSet = preparedStatement.executeQuery()){
               while (resultSet.next()){
                StudentFee fee = new StudentFee();
                fee.setId(resultSet.getInt("id"));
                fee.setStudentIndex(resultSet.getInt("index_number"));
                fee.setDate(resultSet.getString("date"));
                fee.setAmaount(resultSet.getDouble("amount"));
                fee.setAccadamic_year(resultSet.getString("accadamic_year"));
                fee.setGrade(resultSet.getString("grade"));
                fee.setStatus(resultSet.getString("status"));
                
                fees.add(fee);
               }
               
               
           }
           preparedStatement.close();
           
        }
        catch(Exception e){
           System.out.println("Exception occurred while retrieving student fees: " + e.getMessage()); 
        }
        finally{
            DatabaseConnection.closeConnection();
        }
        return fees;
    }
    
   public ArrayList<String> getPaidGrades(String studentIndex){
       ArrayList<String> paidGrades = new ArrayList<>();
       try{
           String query = "SELECT DISTINCT grade FROM student_fee WHERE index_number = ?";
           Connection connection = DatabaseConnection.getConnection(); 
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1, studentIndex);
           
           try(ResultSet resultSet = preparedStatement.executeQuery()){
               while (resultSet.next()) { 
                   paidGrades.add(resultSet.getString("grade")); 
               }
           }
           preparedStatement.close();
           
           
       }catch(Exception e){
          System.out.println("Exception occurred while fetching paid grades: " + e.getMessage()); 
       }finally{
           DatabaseConnection.closeConnection();
       }
       return paidGrades;
   }
   
   
    public void updateFeeStatusToPaid(String academicYear, String date, String status, int id){
        try{
            String updateStatusQuery = "UPDATE student_fee SET status = ?, accadamic_year = ?, date= ? WHERE id = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateStatusQuery);
            
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, academicYear);
            preparedStatement.setString(3, date);
            preparedStatement.setInt(4, id); 
            
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
            System.out.println("Fee status updated to PAID successfully!");
        }
            preparedStatement.close();
            
            
            
        }catch(Exception e){
            System.out.println("Exception occurred while updating fee status: " + e.getMessage());
        }finally{
            DatabaseConnection.closeConnection();
        }
    }
}

    


   
   
   
  

