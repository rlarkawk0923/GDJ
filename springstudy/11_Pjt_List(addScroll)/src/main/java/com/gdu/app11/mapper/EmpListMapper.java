package com.gdu.app11.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app11.domain.EmpDTO;

@Mapper
public interface EmpListMapper {
	public int selectAllEmployeesCount();
	public List<EmpDTO> selectEmployeesUsingScroll(Map<String, Object> map);
	public List<EmpDTO> selectEmployeesUsingPaging(Map<String, Object> map);
}
