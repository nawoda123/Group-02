/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.dao;

import com.mycompany.hostel_management_system.backend.config.DatabaseConnection;
import com.mycompany.hostel_management_system.backend.entity.RoomDetail;
import com.mycompany.hostel_management_system.backend.util.RoomStatus;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class RoomDao {
     public void saveRoom(int roomNum,String status){
         try{
             String saveRoomDetails="insert into new_room(room_number,status, free_bording_count) values (?,?, ?)";
             Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveRoomDetails);
             preparedStatement.setInt(1, roomNum);
             preparedStatement.setString(2, status);
             preparedStatement.setInt(3, 4);
             int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record was inserted successfully!");
            }

            // Close the PreparedStatement
            preparedStatement.close();    
             
         }
         catch(Exception e){
             System.out.println("exception is occuredn when save room detail: " +e.getMessage());
             throw new RuntimeException();
         }finally{
             throw new RuntimeException();
     }
     }
     
     public ArrayList<RoomDetail> getAvailableRooms(){
         ArrayList<RoomDetail> rooms = new ArrayList<>();
         
         try{
             String availableRooms = "select id, room_number, status, free_bording_count from new_room where status = ?";
             
             Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(availableRooms);
             preparedStatement.setString(1, RoomStatus.FREE.toString());
             ResultSet resultSet = preparedStatement.executeQuery();
             while(resultSet.next()){
                 rooms.add(new RoomDetail(resultSet.getInt("id"), 
                         resultSet.getInt("room_number"), 
                         resultSet.getString("status"),
                         resultSet.getInt("free_bording_count")
                    )
                         );
             }
             
             preparedStatement.close();
         }catch(Exception ex){
             System.out.println("Exception is occurred when get the available room details ex : " + ex.getMessage());
         }finally{
             DatabaseConnection.closeConnection();
         }
         
         return rooms;
     }
     
     public ArrayList <RoomDetail> getAllRooms(){
         ArrayList<RoomDetail> roomList=new ArrayList<>();
          
         try{
            String roomdetails="select * from new_room";
            
            Connection connection=DatabaseConnection.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(roomdetails);
            preparedStatement=connection.prepareStatement(roomdetails);
            ResultSet resultSet=preparedStatement.executeQuery();
            
            while(resultSet.next()){
                 roomList.add(new RoomDetail(resultSet.getInt("id"), 
                         resultSet.getInt("room_number"), 
                         resultSet.getString("status"),
                         resultSet.getInt("free_bording_count")));
            }
            
            preparedStatement.close();
            
         }
         catch(Exception e){
             System.out.println("Exception is occurred when get the available room details ex : " + e.getMessage());
         }finally{
                 
                DatabaseConnection.closeConnection();
         }
         return roomList;
     }
     
     
     public void updateRoomStatus(int roomNumber, int freeCount, String status) {
         try{
          String query = "UPDATE new_room SET status = ?, free_bording_count = ?  WHERE room_number = ?";
          Connection connection = DatabaseConnection.getConnection();
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setString(1, status);
          preparedStatement.setInt(2, freeCount);
          preparedStatement.setInt(3, roomNumber);
          
          int rowsUpdated = preparedStatement.executeUpdate();
          if (rowsUpdated > 0) {
            System.out.println("Room status updated successfully!");
        }
          preparedStatement.close();
             
         }catch(Exception e){
             System.out.println("Error updating room status: " + e.getMessage());
         }finally{
             DatabaseConnection.closeConnection();
         }
     }
     
     
     public int getRoomOccupancy(int roomNumber){
         
          int count = 0;
          
          try{
              
              String query = "SELECT COUNT(*) AS occupancy FROM new_student WHERE room_number = ?";
              Connection connection = DatabaseConnection.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query);
              preparedStatement.setInt(1, roomNumber);
              
              ResultSet resultSet = preparedStatement.executeQuery();
              if (resultSet.next()) {
              count = resultSet.getInt("occupancy");
            } 
               resultSet.close();
               preparedStatement.close();
              
          }catch(Exception e){
               System.out.println("Error fetching room occupancy: " + e.getMessage());
          }finally{
              DatabaseConnection.closeConnection();
          }
          return count;
     }
     
     public RoomDetail findRoomById(int roomNumber){
         try{
            RoomDetail roomDetail = null;
            String query = "SELECT * FROM new_room WHERE room_number = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, roomNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
               roomDetail = new RoomDetail(resultSet.getInt("id"), 
                       resultSet.getInt("room_number"), 
                       resultSet.getString("status"), 
                       resultSet.getInt("free_bording_count")
               );
            }
            preparedStatement.close();
            return  roomDetail;
         }catch(Exception ex){
             ex.printStackTrace();
             throw new RuntimeException(ex.getMessage());
         }finally{
             DatabaseConnection.closeConnection();
         }
     }
     
     
               
               
}
      
      
              
         

     
    
     

