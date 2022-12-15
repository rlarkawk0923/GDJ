package com.gdu.app11.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.mapper.EmpSearchMapper;
import com.gdu.app11.util.NaverPageUtil;

@Service
public class EmpSearchServiceImpl implements EmpSearchService {

	@Autowired
	private EmpSearchMapper empSearchMapper;
	
	@Autowired
	private NaverPageUtil naverPageUtil;
	
	@Override
	public Map<String, Object> getAutoCompleteList(HttpServletRequest request) {
		
		String column = request.getParameter("column");
		String query = request.getParameter("query");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("query", query);
		
		List<EmpDTO> list = empSearchMapper.selectAutoCompleteList(map);
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(list.size() == 0) {
			result.put("status", 400);
			result.put("list", null);
		} else {
			result.put("status", 200);
			result.put("list", list);
		}
		
		switch(column) {
		case "FIRST_NAME": result.put("column", "firstName"); break;
		case "PHONE_NUMBER": result.put("column", "phoneNumber"); break;
		case "EMAIL": result.put("column", "email"); break;
		}
		
		return result;
		
		/*
			Map<> result가 jackson에 의해서 아래 JSON으로 자동 변경된다.
			result = {
				"status": 200,               => result.status 또는 result["status"]
				"list": [
					{
						"employeeId": null,
						"firstName": null,
						"lastName": null,
						...
						"email": "MHARTSTE"  => result.list[i].email
					},
					{
						...
					},
					...
				],
				"column": "email"            => result.column
			}
		*/
	}
	
	@Override
	public void searchEmployees(HttpServletRequest request, Model model) {
		
		// page 파라미터가 전달되지 않는 경우 1로 처리한다.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 검색 대상
		String column = request.getParameter("column");
		
		// 검색어
		String query = request.getParameter("query");
		String start = request.getParameter("start");
		String stop = request.getParameter("stop");
		
		// 조회와 검색된 사원수를 알아낼 때 사용하는 Map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		map.put("query", query);
		map.put("start", start);
		map.put("stop", stop);
		
		// 검색된 사원수
		int totalRecord = empSearchMapper.selectSearchCount(map);
		
		// 네이버 웹툰 방식으로 페이징 계산
		naverPageUtil.setNaverPageUtil(page, totalRecord);
		
		// 조회에서 사용하는 Map
		map.put("begin", naverPageUtil.getBegin());
		map.put("end", naverPageUtil.getEnd());
		
		// 검색된 사원목록
		List<EmpDTO> employeeList = empSearchMapper.selectSearchEmployeeList(map);
		
		// search.jsp로 보낼 데이터
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("beginNo", totalRecord - (page - 1) * naverPageUtil.getRecordPerPage());
		
		String path = null;
		switch(column) {
		case "EMPLOYEE_ID":
		case "FIRST_NAME":
		case "PHONE_NUMBER":
		case "EMAIL":
		case "DEPARTMENT_ID":
			path = request.getContextPath() + "/emp/search?column=" + column + "&query=" + query;
			break;
		case "HIRE_DATE":
		case "SALARY":
			path = request.getContextPath() + "/emp/search?column=" + column + "&start=" + start + "&stop=" + stop;
			break;
		}
		model.addAttribute("paging", naverPageUtil.getNaverPaging(path));
		
	}
	
}
