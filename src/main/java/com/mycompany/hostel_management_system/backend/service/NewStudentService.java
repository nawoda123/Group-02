/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.service;

import com.mycompany.hostel_management_system.backend.dao.GradeFeeDao;
import com.mycompany.hostel_management_system.backend.dao.NewStudetDao;
import com.mycompany.hostel_management_system.backend.dao.RoomDao;
import com.mycompany.hostel_management_system.backend.dao.StudentFeeDao;
import com.mycompany.hostel_management_system.backend.dto.StudentSaveResponse;
import com.mycompany.hostel_management_system.backend.entity.GradeFee;
import com.mycompany.hostel_management_system.backend.entity.NewStudentDetails;
import com.mycompany.hostel_management_system.backend.util.HostalManagementSystemStatus;
import com.mycompany.hostel_management_system.backend.util.RoomStatus;
import com.mycompany.hostel_management_system.backend.util.StudentFeeStatus;
import java.awt.List;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class NewStudentService {
    
     private NewStudetDao newStudetDao = new NewStudetDao();
    public StudentSaveResponse saveNewStudentDetails(int index,String name,int cNumber,String address,String gName,int gNumber,int roomNum){
        try{
         NewStudetDao  newstudentdao=new NewStudetDao ();   
         newstudentdao.saveStudent( index, name, cNumber,address, gName,gNumber, roomNum);
         saveStudentFee(index);
         return new StudentSaveResponse(HostalManagementSystemStatus.STUDENT_SAVE_SUCCESS.getStatusCode(), 
            HostalManagementSystemStatus.STUDENT_SAVE_SUCCESS.getNarration());
        }
        catch(Exception e){
           return new StudentSaveResponse(HostalManagementSystemStatus.STUDENT_SAVE_FAILED.getStatusCode(), 
            HostalManagementSystemStatus.STUDENT_SAVE_FAILED.getNarration()); 
        }
    }
    
     public void updateStudent(NewStudentDetails student) {
        newStudetDao.updateStudent(student);
    }

    public void deleteStudent(int index) {
        newStudetDao.deleteStudent(index);
    }
    
    public ArrayList<NewStudentDetails> getAllLivingStudents() {
         return newStudetDao.getAllLivingStudents();
    }
    
    private void saveStudentFee(int studentIndex){
        try{
          ArrayList<GradeFee> gradeFees = getAllGradeFee();
          if(gradeFees == null || gradeFees.isEmpty()){
              throw new RuntimeException("No any grade fee details to save");
          }
          gradeFees.forEach(gredeFee -> {
             new StudentFeeDao().saveStudentFee(studentIndex, 
                     null, 
                     gredeFee.getAmount(), 
                     null, 
                     gredeFee.getGrade(), 
                     StudentFeeStatus.PENDING.toString());
          });
          
          
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Exception is occurred when save the details : ex : " + ex.getMessage());
        }
    }
    
    private ArrayList<GradeFee> getAllGradeFee(){
        return new GradeFeeDao().getAllFeeDetails();
     }
    
    
    
}
