package com.gdu.app11.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app11.service.EmpListService;

@Controller
public class EmpListController {

	@Autowired
	private EmpListService empListService;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/emp/list/scroll/page")
	public String listScrollpage() {
		return "employee/list_scroll";
	}
	
	@ResponseBody
	@GetMapping(value="/emp/list/scroll", produces="application/json")
	public Map<String, Object> listScroll(HttpServletRequest request, Model model) {
		return empListService.getEmployeesUsingScroll(request, model);
	}
	
	@GetMapping("/emp/change/list")
	public String changeList(HttpServletRequest request, int recordPerPage) {
		// 세션에 recordPerPage를 변경해서 올린 뒤 다시 목록으로 돌아감
		request.getSession().setAttribute("recordPerPage", recordPerPage);
		return "redirect:" + request.getHeader("referer");
	}
	
	@GetMapping("/emp/list/paging")
	public String listPaging(HttpServletRequest request, Model model) {
		empListService.getEmployeesUsingPaging(request, model);
		return "employee/list_paging";
	}
	
}
