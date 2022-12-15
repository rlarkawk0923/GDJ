package com.gdu.app11.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.mapper.EmpListMapper;
import com.gdu.app11.util.PageUtil;

@Service
public class EmpListServiceImpl implements EmpListService {

	@Autowired
	private EmpListMapper empListMapper;
	
	@Autowired
	private PageUtil pageUtil;
	
	@Override
	public Map<String, Object> getEmployeesUsingScroll(HttpServletRequest request, Model model) {
		
		// page 파라미터가 전달되지 않는 경우 page = 1로 처리한다.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 전체 레코드(직원) 개수 구하기
		int totalRecord = empListMapper.selectAllEmployeesCount();
		
		// PageUtil 계산하기
		int recordPerPage = 9;  // 스크롤 한 번에 9개씩 가져가기
		pageUtil.setPageUtil(page, recordPerPage, totalRecord);
		
		// Map 만들기(field, order, begin, end)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		// begin~end 목록 가져오기
		List<EmpDTO> employees = empListMapper.selectEmployeesUsingScroll(map);
		
		// 응답할 데이터
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("totalPage", pageUtil.getTotalPage());
		resultMap.put("employees", employees);
		
		return resultMap;
		
	}
	
	@Override
	public void getEmployeesUsingPaging(HttpServletRequest request, Model model) {
		
		// title 파라미터가 전달되지 않는 경우 EMPLOYEE_ID로 처리한다.
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("title"));
		String title = opt1.orElse("EMPLOYEE_ID");
		
		// order 파라미터가 전달되지 않는 경우 ASC로 처리한다.
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("order"));
		String order = opt2.orElse("ASC");
		
		// page 파라미터가 전달되지 않는 경우 page = 1로 처리한다.
		Optional<String> opt3 = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt3.orElse("1"));
		
		// recordPerPage는 세션에서 가져오는데 만약 세션에 없으면 10으로 처리한다.
		HttpSession session = request.getSession();
		Optional<Object> opt4 = Optional.ofNullable(session.getAttribute("recordPerPage"));
		int recordPerPage = (int)(opt4.orElse(10));
		
		// 전체 레코드(직원) 개수 구하기
		int totalRecord = empListMapper.selectAllEmployeesCount();
		
		// PageUtil 계산하기
		pageUtil.setPageUtil(page, recordPerPage, totalRecord);
	
		// Map 만들기(field, order, begin, end)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("order", order);
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		// begin~end 목록 가져오기
		List<EmpDTO> employees = empListMapper.selectEmployeesUsingPaging(map);
		
		// 뷰로 보낼 데이터
		switch(order) {
		case "ASC":
			model.addAttribute("order", "DESC");
			break;
		case "DESC":
			model.addAttribute("order", "ASC");
			break;		
		}
		model.addAttribute("page", page);
		model.addAttribute("employees", employees);
		model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());
		model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/emp/list/paging?title=" + title + "&order=" + order));

	}
	
}
