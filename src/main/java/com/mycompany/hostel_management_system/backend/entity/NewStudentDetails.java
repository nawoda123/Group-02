/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.hostel_management_system.backend.entity;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author DELL
 */
@NoArgsConstructor
@Getter
@Setter
public class NewStudentDetails {
    private int index;
    private String name;
    private int contactNumber;
    private String address;
    private String gName;
    private int gNumber;
    private int roomNumber;

    public NewStudentDetails(int index, String name, int contactNumber, String address, String gName, int gNumber, int roomNumber) {
        this.index = index;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.gName = gName;
        this.gNumber = gNumber;
        this.roomNumber = roomNumber;
    }

   
}