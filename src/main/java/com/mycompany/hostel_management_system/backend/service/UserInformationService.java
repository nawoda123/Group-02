/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.service;

import com.mycompany.hostel_management_system.backend.dao.UserInformationDao;
import com.mycompany.hostel_management_system.backend.dto.LoginStatus;
import com.mycompany.hostel_management_system.backend.entity.UserInformation;
import com.mycompany.hostel_management_system.backend.util.HostalManagementSystemStatus;

/**
 *
 * @author DELL
 */
public class UserInformationService {
    
   public void saveUserInfo(String fullName, String email, String password){
       try{
           UserInformationDao userInformationDao = new UserInformationDao();
           userInformationDao.saveUserInformation(fullName, password, email);
       }catch(Exception ex){
           System.out.println("Exception is occurred : " + ex.getMessage());
       }
   }
   
   public LoginStatus isLoginSuccess(String email, String password){
       try{
           UserInformation userInformation = this.getUserDetailsByEmail(email);
           if(userInformation == null){
               return new LoginStatus(false, HostalManagementSystemStatus.INVALID_USERNAME.getStatusCode(), 
               HostalManagementSystemStatus.INVALID_USERNAME.getNarration());
           }
           
           // check password
           if(!userInformation.getPassword().equals(password)){
                return new LoginStatus(false, HostalManagementSystemStatus.INVALID_PASSWORD.getStatusCode(), 
               HostalManagementSystemStatus.INVALID_PASSWORD.getNarration());
           }
           
            return new LoginStatus(true, HostalManagementSystemStatus.LOGIN_SUCESSFUL.getStatusCode(), 
               HostalManagementSystemStatus.LOGIN_SUCESSFUL.getNarration());
       }catch(Exception ex){
           return new LoginStatus(false, HostalManagementSystemStatus.LOGIN_VALIDATION_FAILED_BY_SYSTEM.getStatusCode(), 
               HostalManagementSystemStatus.LOGIN_VALIDATION_FAILED_BY_SYSTEM.getNarration());
       }
       
       
   }
   
   private UserInformation getUserDetailsByEmail(String email){
       UserInformationDao informationDao = new UserInformationDao();
       return informationDao.getUserDetailsByEmail(email);
   }
}
