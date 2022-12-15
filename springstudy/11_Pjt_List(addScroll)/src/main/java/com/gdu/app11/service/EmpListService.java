package com.gdu.app11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmpListService {
	public Map<String, Object> getEmployeesUsingScroll(HttpServletRequest request, Model model);
	public void getEmployeesUsingPaging(HttpServletRequest request, Model model);
}
