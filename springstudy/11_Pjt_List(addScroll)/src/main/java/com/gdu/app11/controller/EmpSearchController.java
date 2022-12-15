package com.gdu.app11.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app11.service.EmpSearchService;

@Controller
public class EmpSearchController {

	@Autowired
	private EmpSearchService empSearchService;
	
	@GetMapping("/emp/search/form")
	public String searchForm() {
		return "employee/list_search";
	}
	
	@ResponseBody
	@GetMapping(value="/emp/autoComplete", produces="application/json")
	public Map<String, Object> autoComplete(HttpServletRequest request) {
		return empSearchService.getAutoCompleteList(request);
	}

	@GetMapping("/emp/search")
	public String search(HttpServletRequest request, Model model) {
		empSearchService.searchEmployees(request, model);
		return "employee/search";
	}
	
}
