/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.dao;

import com.mycompany.hostel_management_system.backend.config.DatabaseConnection;
import com.mycompany.hostel_management_system.backend.entity.UserInformation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class UserInformationDao {
    
    public void saveUserInformation(String fullName, String password, String email){
        try{
         String insertQuery = "INSERT INTO user_information (full_name,password,email) VALUES (?,?,?)";
         Connection connection = DatabaseConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
         preparedStatement.setString(1, fullName);
         preparedStatement.setString(2, password);
         preparedStatement.setString(3, email);
         
         int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record was inserted successfully!");
            }

            // Close the PreparedStatement
            preparedStatement.close();
         
         }
         catch(Exception e){
                System.out.println("exception : " + e.getMessage());
         }
         finally{
           DatabaseConnection.closeConnection();
       }
    
    }
    
    public UserInformation getUserDetailsByEmail(String email){
        try{
            String getUserDetailsByUserName = "SELECT full_name, email, password FROM `user_information` WHERE email = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getUserDetailsByUserName);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                return new UserInformation(resultSet.getString("email"), 
                        resultSet.getString("full_name"), 
                        resultSet.getString("password"));
                
            }
            
            preparedStatement.close();
        }catch(Exception ex){
            System.out.println("Exception is occurred : ex = " + ex.getMessage());
        }
        finally{
             DatabaseConnection.closeConnection();
        }
        return null;
    }
    
}
