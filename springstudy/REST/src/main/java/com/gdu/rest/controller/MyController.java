package com.gdu.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member/handle")
	public String memberHandle(HttpServletRequest request, Model model) {
		return "member/handle";
	}
	   
	   
	
}
