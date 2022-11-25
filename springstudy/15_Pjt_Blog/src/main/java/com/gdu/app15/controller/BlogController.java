package com.gdu.app15.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app15.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/blog/list")
	public String list(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); // model에 request를 저장하기
		blogService.getBlogList(model); // model만 넘기지만 이미 모델에는 request가 들어있음 //  매개변수를 모델로 통일할때 쓰는 법 서비스 asMap써보라고
		return "blog/list";
	}
	
	@GetMapping("/blog/write")
	public String write() {
		return "blog/write";
	}

	
	
}