/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class StudentFee {
    
    private int id;
    private int studentIndex;
    private String date;
    private double amaount;
    private String accadamic_year;
    private String grade;
    private String status;
    
    public StudentFee(int id,int studentIndex,String date,double amaount,String accadamic_year,String grade, String status){
        this.id=id;
        this.studentIndex=studentIndex;
        this.date=date;
        this.amaount=amaount;
        this.accadamic_year=accadamic_year;
        this.grade=grade;
        this.status = status;
    }
    
}
