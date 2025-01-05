/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.dao;

import com.mycompany.hostel_management_system.backend.config.DatabaseConnection;
import com.mycompany.hostel_management_system.backend.entity.GradeFee;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class GradeFeeDao {
        public ArrayList<GradeFee> getAllFeeDetails(){
            try{
                ArrayList<GradeFee> gradeFeeDetails = new ArrayList<>();
                
                String getGradeFeeDetailsQuery = "select id, grade, fee_amount from grade_fee";
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getGradeFeeDetailsQuery);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    gradeFeeDetails.add(new GradeFee(resultSet.getInt("id"), 
                            resultSet.getString("grade"), 
                            resultSet.getDouble("fee_amount")));
                }
                preparedStatement.close();
                return gradeFeeDetails;
            }catch(Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("Error was occurred when get the grade ee details : " + ex.getMessage());
            }finally{
                DatabaseConnection.closeConnection();
            }
        }
        
        
}
