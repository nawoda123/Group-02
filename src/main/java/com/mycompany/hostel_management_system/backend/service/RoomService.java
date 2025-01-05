/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.service;

import com.mycompany.hostel_management_system.backend.dao.RoomDao;
import com.mycompany.hostel_management_system.backend.dto.RoomSaveResponse;
import com.mycompany.hostel_management_system.backend.entity.RoomDetail;
import com.mycompany.hostel_management_system.backend.util.HostalManagementSystemStatus;
import com.mycompany.hostel_management_system.backend.util.RoomStatus;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class RoomService {
    public RoomSaveResponse saveRoomDetail(int roomNum,String status){
        try{
            RoomDao roomdao=new RoomDao();
            roomdao.saveRoom(roomNum,status);
            return new RoomSaveResponse(HostalManagementSystemStatus.ROOM_SAVE_SUCCESS.getStatusCode(), 
            HostalManagementSystemStatus.ROOM_SAVE_SUCCESS.getNarration());
        }
        catch(Exception e){
            return new RoomSaveResponse(HostalManagementSystemStatus.ROOM_SAVE_FAILED.getStatusCode(), 
            HostalManagementSystemStatus.ROOM_SAVE_FAILED.getNarration());
        }
    }
    
    
    public ArrayList<RoomDetail> getAvailableRoomDetails(){
        try{
            return  new RoomDao().getAvailableRooms();
        }catch(Exception ex){
            System.out.println("Exception is occurred : " + ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public ArrayList<RoomDetail> getAllRooms(){
        RoomDao roomdao=new RoomDao();
        return roomdao.getAllRooms();
    }
    
    
    public void updateFreeCount(int roomNumber, int freeBoardingCount){
        try{
            String status = RoomStatus.FREE.toString();
            if(freeBoardingCount == 0){
                status = RoomStatus.OCCUPIED.toString();
            }
            RoomDao roomdao=new RoomDao();
            roomdao.updateRoomStatus(roomNumber, freeBoardingCount, status);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    public RoomDetail getRoomDetailsById(int roomNumber){
        try{
          RoomDao roomDao = new RoomDao();
          return roomDao.findRoomById(roomNumber);
        }catch(Exception ex){
          ex.printStackTrace();
          throw new RuntimeException(ex.getMessage());
        }
    }
}


