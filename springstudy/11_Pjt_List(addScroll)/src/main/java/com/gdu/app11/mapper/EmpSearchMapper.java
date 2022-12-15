package com.gdu.app11.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app11.domain.EmpDTO;

@Mapper
public interface EmpSearchMapper {
	public List<EmpDTO> selectAutoCompleteList(Map<String, Object> map);
	public int selectSearchCount(Map<String, Object> map);
	public List<EmpDTO> selectSearchEmployeeList(Map<String, Object> map);
}
