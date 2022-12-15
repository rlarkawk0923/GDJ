package com.gdu.app15.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.app15.service.GoodService;

@RestController  // @Controller + @ResponseBody
public class GoodController {

	@Autowired
	private GoodService goodService;
	
	@GetMapping(value="/good/getGoodCheck", produces="application/json")
	public Map<String, Object> getGoodCheck(HttpServletRequest request) {
		return goodService.getGoodCheck(request);
	}
	
	@GetMapping(value="/good/getGoodCount", produces="application/json")
	public Map<String, Object> getGoodCount(int blogNo) {
		return goodService.getGoodCount(blogNo);
	}
	
	@GetMapping(value="/good/mark", produces="application/json")
	public Map<String, Object> mark(HttpServletRequest request) {
		return goodService.mark(request);
	}
	
}
