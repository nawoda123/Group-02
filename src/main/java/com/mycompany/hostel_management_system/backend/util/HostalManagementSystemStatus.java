/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hostel_management_system.backend.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author DELL
 */
@AllArgsConstructor
@Getter
public enum HostalManagementSystemStatus {
    LOGIN_SUCESSFUL(200, "Login Successful"),
    INVALID_USERNAME(401, "Username is invalid"),
    INVALID_PASSWORD(402, "Password is invalid"),
    LOGIN_VALIDATION_FAILED_BY_SYSTEM(403, "Login validation was failed by system"),
    ROOM_SAVE_SUCCESS(201,"room save successfull"),
    ROOM_SAVE_FAILED(404, "Room save failed"),
    STUDENT_SAVE_SUCCESS(202,"student save successfully"),
    STUDENT_SAVE_FAILED(405,"student save failed"),
    STUDENT_FEESAVE_SUCCESS(203,"student fee save successfully"),
    STUDENT_FEESAVE_FAILED(406,"student fee save failed");
    
    private int statusCode;
    private String narration;
}
