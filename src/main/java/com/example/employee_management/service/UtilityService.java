package com.example.employee_management.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {

//    Tạo mã nhân viên tự động
    public String generateEmployeeCode(){
//      Dạng mã nhân viên:  EMP-<6 ký tự đầu của uuid>
        String uuidPart = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        return "EMP-" + uuidPart;
    }

//    Chuẩn hóa tên
    public String formatName(String rawName){
        String [] words = rawName.trim().toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String word: words){
            if (!word.isEmpty()){
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();
    }
}
