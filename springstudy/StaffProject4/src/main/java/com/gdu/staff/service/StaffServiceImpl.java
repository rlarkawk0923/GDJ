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
	public List<StaffDTO> getAllStaffList() {
		return staffMapper.selectStaffList();
	}

	@Override
	public ResponseEntity<String> addStaff(StaffDTO staff) {
		try {
			int salary = 0;
			switch(staff.getDept()) {
			case "기획부": salary = 5000; break;
			case "개발부": salary = 6000; break;
			case "영업부": salary = 7000; break;
			default: salary = 4000;
			}
			staff.setSalary(salary);
			staffMapper.insertStaff(staff);
			return new ResponseEntity<String>("사원 등록이 성공했습니다.", HttpStatus.OK);				
		} catch(Exception e) {
			return new ResponseEntity<String>("사원 등록이 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public StaffDTO findStaff(String query) {
		return staffMapper.selectStaffBySno(query);
	}

}
