package com.gdu.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/ntc/list")// 폴더이름이랑 매핑 분리한것
	public String list(Model model) { // 모델을 선언해서 노티스서비스에 전달
		noticeService.findAllNotices(model);
		return "notice/list";
	}
	
	@GetMapping("/ntc/write")
	public String write() {
		return "notice/write";
	}
	
	@PostMapping("/ntc/add")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		noticeService.addNotice(request, response); // 서비스가 응답(성공했을때 갈곳 실패했을때 갈곳 ) 만들었기 때문에 리턴 필요없음/ /서비스에 리다이렉트도 됨
	}
	
}