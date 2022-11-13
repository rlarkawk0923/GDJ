package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app04.domain.Board;


@RequestMapping("board")  // URL Mapping이 board로 시작하는 모든 요청을 처리하는 컨트롤러
@Controller
public class MyController2 {

	
	/*
		까먹으면 죽음뿐이다.
		
		1. forward
		return "board/detail";
		board 폴더 아래 detail.jsp로 forward 하시오.
		
		2. redirect
		return "redirect:/board/detail";
		URL Mapping값이 /board/detail인 새로운 요청으로 redirect 하시오.
	*/
	
	// <a href="${contextPath}/board/detail1?title=공지사항&hit=10">
	@GetMapping("detail1")
	public String detail1(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String hit = request.getParameter("hit");
		
		request.setAttribute("title", title);
		request.setAttribute("hit", hit);
		
		return "redirect:/board/detail2?title=" + title + "&hit=" + hit;  // 새로운 요청을 /board/detail2?title=공지사항&hit=10 처리하시오
		
	}
	
	@GetMapping("detail2")
	public String detail2(String title, int hit, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		return "board/detail";
	}
	
	   /*
    속성(Attribute) 전달 방식
    
    구분            forward            redirect
    -------------------------------------------------------------
    인터페이스         Model            RedirectAttributes
    메소드            addAttribute()      addFlashAttribute()
                                  addAttribute()를 쓸수 있지만 forward처럼 동작하므로 사용하지 말 것
                                  Flash가 붙어있는지 확인하면 됨.
 */
	@GetMapping("detail3")// setTitle(),setHit()가 준비된 객체가 있으면 불러와서 사용한다
	public String detail3(Board board
						, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("board", board);
		return "redirect:/board/detail4"; // 새로운 요청에 파라미터를 추가하지 않았음을 주의할 것!
	}
	
	@GetMapping("detail4")
	public String detail4() {
		return "board/detail";
	}
	
}