/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.service;

import com.mycompany.hostel_management_system.backend.config.DatabaseConnection;
import com.mycompany.hostel_management_system.backend.dao.StudentFeeDao;
import com.mycompany.hostel_management_system.backend.dto.StudentFeeResponse;
import com.mycompany.hostel_management_system.backend.entity.FutureFeeDetails;
import com.mycompany.hostel_management_system.backend.entity.StudentFee;
import com.mycompany.hostel_management_system.backend.util.HostalManagementSystemStatus;
import com.mycompany.hostel_management_system.backend.util.StudentFeeStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentFeeService {
    
    private StudentFeeDao studentfeedao=new StudentFeeDao();
    
   public StudentFeeResponse saveStudentFeeDetails(int id,int studentIndex,String date,double amaount,String accadamic_year,String grade){
      try{
        StudentFeeDao studentfeedao=new StudentFeeDao();
        studentfeedao.saveStudentFee(studentIndex, date, amaount,accadamic_year,grade, StudentFeeStatus.PENDING.toString());
        return new StudentFeeResponse(HostalManagementSystemStatus.STUDENT_FEESAVE_SUCCESS.getStatusCode(), 
            HostalManagementSystemStatus.STUDENT_FEESAVE_SUCCESS.getNarration());
        
          
      }catch(Exception e){
          return new StudentFeeResponse (HostalManagementSystemStatus.STUDENT_FEESAVE_FAILED.getStatusCode(), 
            HostalManagementSystemStatus.STUDENT_FEESAVE_FAILED.getNarration()); 
      }
    
}
   
  
   
    public ArrayList<StudentFee> getFeesByIndex(String studentIndex) throws SQLException{
         return studentfeedao.getStudentFeeDetails(studentIndex);
    }

    public void saveFee(StudentFee fee) {
        try {
        studentfeedao.saveStudentFee(
            fee.getStudentIndex(), 
            fee.getDate(), 
            fee.getAmaount(),
            fee.getAccadamic_year(),
            fee.getGrade(),
            fee.getStatus()
        );
    } catch (Exception e) {
        throw new RuntimeException("Error saving fee: " + e.getMessage());
    }
    }
    
    public ArrayList<StudentFee> getFeesByYear(String accadamicYear) {
       return studentfeedao.getStudentFeeDetailsByYear(accadamicYear);
}

    public ArrayList<StudentFee> getPaidStudentsByAcademicYear(String academicYear) {
        ArrayList<StudentFee> paidStudents = new ArrayList<>();
    try {
        
        paidStudents = studentfeedao.getStudentFeeDetailsByYear(academicYear);
    } catch (Exception e) {
        throw new RuntimeException("Error fetching paid students for academic year " + academicYear + ": " + e.getMessage());
    }
    return paidStudents;
    }
    
    public void markFeeAsPaid( String accadamicYear, String date, String status, int id) {
    try {
        studentfeedao.updateFeeStatusToPaid(accadamicYear, date, status, id);  // Update the status to PAID
    } catch (Exception e) {
        throw new RuntimeException("Error marking fee as paid: " + e.getMessage());
    }
}

}
