package com.gdu.app15.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.app15.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/login")
	public String login(HttpServletRequest request) {
		userService.login(request);
		return "index";
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
		
}
