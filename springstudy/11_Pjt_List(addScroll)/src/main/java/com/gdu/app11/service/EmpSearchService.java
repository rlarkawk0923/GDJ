package com.gdu.app11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmpSearchService {
	public Map<String, Object> getAutoCompleteList(HttpServletRequest request);
	public void searchEmployees(HttpServletRequest request, Model model);
}
