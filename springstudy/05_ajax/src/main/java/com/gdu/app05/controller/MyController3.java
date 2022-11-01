package com.gdu.app05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController3 {

	@GetMapping("movie")
	public String movie() {
		return "movie";
	}
	
}