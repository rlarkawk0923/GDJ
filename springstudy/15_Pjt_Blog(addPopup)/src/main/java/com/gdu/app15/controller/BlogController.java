package com.gdu.app15.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app15.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/view/popup")
	public String popup() {
		return "popup/popup";
	}	
	
	@GetMapping("/blog/list")
	public String list(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);  // model에 request를 저장하기
		blogService.getBlogList(model);          // model만 넘기지만 이미 model에는 request가 들어 있음
		return "blog/list";
	}
	
	@GetMapping("/blog/write")
	public String write() {
		return "blog/write";
	}
	
	@ResponseBody
	@PostMapping(value="/blog/uploadImage", produces="application/json")
	public Map<String, Object> uploadImage(MultipartHttpServletRequest multipartRequest) {
		return blogService.saveSummernoteImage(multipartRequest);
	}
	
	@PostMapping("/blog/add")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		blogService.saveBlog(request, response);
	}
	
	@GetMapping("/blog/increse/hit")
	public String increseHit(@RequestParam(value="blogNo", required=false, defaultValue="0") int blogNo) {
		int result = blogService.increseBlogHit(blogNo);
		if(result > 0) {  // 조회수 증가에 성공하면 상세보기로 이동
			return "redirect:/blog/detail?blogNo=" + blogNo;
		} else {          // 조회수 증가에 실패하면 목록보기로 이동
			return "redirect:/blog/list";
		}
	}
	
	@GetMapping("/blog/detail")
	public String detail(@RequestParam(value="blogNo", required=false, defaultValue="0") int blogNo, Model model) {
		model.addAttribute("blog", blogService.getBlogByNo(blogNo));
		return "blog/detail";
	}
	
	@PostMapping("/blog/edit")
	public String edit(int blogNo, Model model) {
		model.addAttribute("blog", blogService.getBlogByNo(blogNo));
		return "blog/edit";
	}
	
	@PostMapping("/blog/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response) {
		blogService.modifyBlog(request, response);
	}
	
	@PostMapping("/blog/remove")
	public void remove(HttpServletRequest request, HttpServletResponse response) {
		blogService.removeBlog(request, response);
	}
	
}
