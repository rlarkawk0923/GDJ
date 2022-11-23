package com.gdu.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Override
	public List<StaffDTO> getStaffList() {
		
		return staffMapper.selectStaffList();
	}
	
	@Override
	public ResponseEntity<String> addStaff(StaffDTO staff) {
		
		try{
			switch(staff.getDept()) {
			case "기획부":
				staff.setSalary(5000);
				break;
			case "개발부":
				staff.setSalary(6000);
				break;
			case "영업부":
				staff.setSalary(7000);
				break;
			default:
				staff.setSalary(4000);
			}
		staffMapper.insertStaff(staff);
		return new ResponseEntity<String>("사원 등록이 성공했습니다.", HttpStatus.OK); // 성공했을때 반환값, 성공했을때 응답시켜달라 dataType:text인 이유
		}catch (Exception e) {
			return new ResponseEntity<String>("사원 등록이 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	 @Override public StaffDTO findStaffBySno(String query) {
	  
	  return staffMapper.selectStaffBySno(query);
	 }


}
