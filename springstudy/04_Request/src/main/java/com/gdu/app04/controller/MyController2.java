package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app04.domain.Board;


@RequestMapping("/board")  // URL Mapping이 board로 시작하는 모든 요청을 처리하는 컨트롤러
@Controller
public class MyController2 {

	
	
	/*
		redirect 확인하기
		
		return이 "redirect:"로 시작하면 response.sendRedirect()가 자동 호출된다.
		
		return이 "redirect:/app"이라면 response.sendRedirect("/app")가 실행된다.
	*/
	
	
	
	@GetMapping("/detail1")
	public String detail1(HttpServletRequest request) {
		
		String title = request.getParameter("title");  // title이 있을거다.
		String hit = request.getParameter("hit");      // hit가 있을거다.
		
		System.out.println(title + ", " + hit);
		
		return "redirect:/board/go1";  // /board/go1 매핑으로 이동하시오.(바로 아래 있는 @GetMapping("/go1")를 의미한다.)
		
	}
	
	@GetMapping("/go1")
	public String go1(HttpServletRequest request   // redirect는 기존 request를 전달하지 않으므로 /detail1으로 전달된 파라미터가 없을 것이다.
			        , Model model) {
		
		String title = request.getParameter("title");  // null일거다.
		String hit = request.getParameter("hit");      // null일거다.
		
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		
		return "board/detail";
		
	}
	
	
	
	/*
		redirect할 때 요청 파라미터를 전달하는 방법
		
		1. 파라미터를 다시 붙여서 요청한다. (원래 사용하던 방식)
		2. RedirectAttributes를 사용한다. (스프링에서 지원하는 방식)
	*/
	
	
	
	/* 1. 파라미터를 다시 붙여서 요청한다. */
	
	@GetMapping("/detail2")
	public String detail2(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String hit = request.getParameter("hit");
		
		return "redirect:/board/go2?title=" + title + "&hit=" + hit;  // 파라미터를 다시 붙여준다.
		
	}
	
	@GetMapping("/go2")
	public String go2(HttpServletRequest request
			        , Model model) {
		
		String title = request.getParameter("title");
		String hit = request.getParameter("hit");
		
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		
		return "board/detail";
		
	}
	
	
	/* 2. RedirectAttributes를 사용한다. */
	@GetMapping("/detail3")
	public String detail3(HttpServletRequest request
			            , RedirectAttributes redirectAttributes) {
		
		String title = request.getParameter("title");
		String hit = request.getParameter("hit");
		
		redirectAttributes.addFlashAttribute("title", title);  // addAttribute 아님 주의!
		redirectAttributes.addFlashAttribute("hit", hit);
		
		return "redirect:/board/go3";  // 새로운 요청에 파라미터를 추가하지 않았지만 redirectAttributes에 저장해 놓은 Flash 속성이 전달될거다.
		
	}
	
	@GetMapping("/go3")
	public String go3() {
		return "board/detail";
	}
	
	
	// RedirectAttributes 각자 연습
	// 1. @RequestParam 애너테이션으로 요청 파라미터를 처리해서 /detail4 + /go4 요청으로 redirect 해 보기
	// 2. 커맨드 객체 Board를 만들어서 /detail5 + /go5 요청으로 redirect 해 보기
	
	
	@GetMapping("/detail4")
	public String detail4(@RequestParam("title") String title
			            , @RequestParam("hit") int hit
			            , RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("title", title);
		redirectAttributes.addFlashAttribute("hit", hit);
		
		return "redirect:/board/go4";
		
	}
	
	@GetMapping("/go4")
	public String go4() {
		return "board/detail";
	}
	
	
	
	@GetMapping("/detail5")
	public String detail5(Board board
			            , RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("board", board);
		
		return "redirect:/board/go5";
		
	}
	
	@GetMapping("/go5")
	public String go5() {
		return "board/detail";
	}
	
	
	
	/*
		속성(Attribute) 전달 방식
		
		구분        |   forward           |   redirect
		----------------------------------------------------------
		인터페이스  |   Model             |   RedirectAttributes
		메소드      |    addAttribute()   |     addFlashAttribute()
	*/
	
	
	/*
		최종 정리. 이걸 까먹으면 앞으로 죽음뿐이다.
		
		1. forward
			return "board/detail";
			board 디렉터리 아래에 있는 detail.jsp로 forward 하시오.
		
		2. redirect
			return "redirect:/board/detail";
			URL Mapping값이 /board/detail인 새로운 요청으로 redirect 하시오.
	*/
	
	
}