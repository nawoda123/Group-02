/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.dao;

import com.mycompany.hostel_management_system.backend.config.DatabaseConnection;
import com.mycompany.hostel_management_system.backend.entity.NewStudentDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class NewStudetDao {

    public void saveStudent(int index, String name, int cNumber, String address, String gName, int gNumber, int roomNum) {
        try {
            String saveNewStudentDetails = "insert into new_student(indexNumber,FullName,contact_number,address,gaurdian_name,gaudian_number,room_number) values (?,?,?,?,?,?,?)";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(saveNewStudentDetails);
            preparedStatement.setInt(1, index);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, cNumber);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, gName);
            preparedStatement.setInt(6, gNumber);
            preparedStatement.setInt(7, roomNum);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record was inserted successfully!");
            }

            preparedStatement.close();

        } catch (Exception e) {
            System.out.println("exception is occuredn when save room detail: " + e.getMessage());
            throw new RuntimeException();
        } finally {
            DatabaseConnection.closeConnection();
        }

    }

    public NewStudentDetails getStudentByIndex(int index) {
        NewStudentDetails student = null;

        try {
            String query = "SELECT * FROM new_student WHERE indexNumber = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new NewStudentDetails(
                        resultSet.getInt("indexNumber"),
                        resultSet.getString("FullName"),
                        resultSet.getInt("contact_number"),
                        resultSet.getString("address"),
                        resultSet.getString("gaurdian_name"),
                        resultSet.getInt("gaudian_number"),
                        resultSet.getInt("room_number")
                );
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("exception is occuredn when save room detail: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
        return student;
    }

    public boolean updateStudent(NewStudentDetails student) {
        try {
            String query = "UPDATE new_student SET FullName = ?, contact_number = ?, address = ?, gaurdian_name = ?, gaudian_number = ?,room_number= ? WHERE indexNumber = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getContactNumber());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getGName());
            preparedStatement.setInt(5, student.getGNumber());
            preparedStatement.setInt(6,  student.getRoomNumber());
            preparedStatement.setInt(7, student.getIndex());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student details updated successfully.");
            }

            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection();
        }

        return true;
    }

    
    public ArrayList<NewStudentDetails> getAllLivingStudents() {
          ArrayList<NewStudentDetails> studentList = new ArrayList<>();
          try{
              String query = "SELECT indexNumber, FullName, contact_number FROM new_student";
              Connection connection = DatabaseConnection.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query);
              ResultSet resultSet = preparedStatement.executeQuery();
              
              while (resultSet.next()){
                  NewStudentDetails student = new NewStudentDetails();
                  student.setIndex(resultSet.getInt("indexNumber"));
                  student.setName(resultSet.getString("FullName"));
                  student.setContactNumber(resultSet.getInt("contact_number"));
                  studentList.add(student);
              }
              resultSet.close();
              preparedStatement.close();
              
          }catch(Exception e){
               System.out.println("Error fetching living students: " + e.getMessage());
          }finally{
              DatabaseConnection.closeConnection();
          }
           return studentList;
    }
    
    public void assignStudentToRoom(int studentId, int roomNumber){
        try{
            String query = "UPDATE new_student SET room_number = ? WHERE indexNumber = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, roomNumber);
            preparedStatement.setInt(2, studentId);
            
             preparedStatement.executeUpdate();
             preparedStatement.close();
            
        }catch(Exception e){
            System.out.println("Error assigning student to room in DAO: " + e.getMessage());
        }finally{
              DatabaseConnection.closeConnection();
          }
        
    }
    
    public boolean deleteStudent(int index) {
        try {
            NewStudentDetails student = getStudentByIndex(index); // Retrieve student details
           if (student == null) {
            return false;
        }
           saveLeavedStudent(student.getIndex(), student.getName(), student.getContactNumber(), student.getRoomNumber());
            String query = "DELETE FROM new_student WHERE indexNumber = ?";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            }

            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("exception is occuredn when save room detail: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
          return true;
    }
    
    public void saveLeavedStudent(int index, String name, int cNumber, int roomNum){
        try{
            String saveLeavedStudent = "INSERT INTO leaved_student(indexNumber, FullName, contact_number, room_number) VALUES (?, ?, ?, ?)";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(saveLeavedStudent);
             preparedStatement.setInt(1, index);
             preparedStatement.setString(2, name);
             preparedStatement.setInt(3, cNumber);
             preparedStatement.setInt(4, roomNum);
             int rowsInserted = preparedStatement.executeUpdate();
             if (rowsInserted > 0) {
            System.out.println("Leaved student record inserted successfully!");
        }

        preparedStatement.close();
            
        }catch(Exception e){
          System.out.println("Exception occurred when saving leaved student detail: " + e.getMessage());
          throw new RuntimeException();  
        }finally{
             DatabaseConnection.closeConnection();
        }
    }
    
    public ArrayList<NewStudentDetails> getAllLeavedStudents() {
        ArrayList<NewStudentDetails> leavedStudents = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM leaved_student";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                leavedStudents.add(new NewStudentDetails(
                resultSet.getInt("indexNumber"),
                resultSet.getString("FullName"),
                resultSet.getInt("contact_number"),
                null, 
                null, 
                0,   
                resultSet.getInt("room_number")
            ));
            }
            resultSet.close();
            preparedStatement.close();
            
        }catch(Exception e){
          System.out.println("Exception occurred when retrieving leaved students: " + e.getMessage());  
        }finally{
            DatabaseConnection.closeConnection();
        }
        return leavedStudents;
    }
    
  
    
    
   
}
