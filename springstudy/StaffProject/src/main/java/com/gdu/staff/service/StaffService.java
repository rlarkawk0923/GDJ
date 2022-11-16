package com.gdu.staff.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gdu.staff.domain.StaffDTO;

public interface StaffService {
   public List<StaffDTO> getStaffList();
   public ResponseEntity<String> addStaff(StaffDTO staff);// 응답할 데이터는 text라 String
   public StaffDTO findStaffBySno(String query);

   
   
}