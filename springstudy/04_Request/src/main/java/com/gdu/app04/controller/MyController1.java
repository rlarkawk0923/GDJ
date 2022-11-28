package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app04.domain.Member;


@RequestMapping("member")  // URL Mapping이 member로 시작하는 모든 요청을 처리하는 컨트롤러
@Controller
public class MyController1 {
	
	/*
	요청 파라미터 UTF-8 인코딩 하는 방법
	
	매번 request.setCharacterEncoding("UTF-8")을 작성하는 것이 비효율적이므로
	인코딩 필터를 달아준다. (필터는 요청 이전에 항상 먼저 처리됨)
	web.xml에 인코딩 필터를 달아주었으니 살펴보자.
*/



/*
	요청 파라미터를 처리하는 방법
	
	1. HttpServletRequeest로 처리하기
	2. @RequestParam 애너테이션으로 처리하기
	3. 커맨드 객체로 처리하기
*/

	
	// <a href="${contextPath}/member/detail1">
	@GetMapping("detail1")        // member/detail1 요청을 처리하시오.
	public String detail1(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member(id, pw);
		
		// forward할 데이터를 request에 담아 두는 방법
		request.setAttribute("member", member);
		
		return "member/detail";  // member 폴더 아래 detail.jsp로 forward 하시오.
		
	}
	
	// location.href='${contextPath}/member/detail2?id=admin&pw=1234';
	@GetMapping("detail2")
	public String detail2(@RequestParam(value="id", required=false, defaultValue="master") String id  // 파라미터 id를 String id에 저장하시오.
			            , @RequestParam(value="pw", required=false, defaultValue="1111")   String pw  // 파라미터 pw를 String pw에 저장하시오.
			            , Model model) {
		
		/*
			@RequestParam
			1. value        : 파라미터 이름
			2. required     : 파라미터의 필수 여부(디폴트는 true)
			3. defaultValue : 파라미터가 없을 때 사용할 값
		*/
		
		Member member = new Member(id, pw);
		
		// forward할 데이터를 model에 담아 두는 방법(이것이 스프링의 방식)
		// request를 이용하는 방식에 비해 보안이 향상되었다.
		model.addAttribute("member", member);  // model은 request를 저장소로 사용한다.
		
		return "member/detail";  // member 폴더 아래 detail.jsp로 forward 하시오.
		
	}
	
	/* 3. 커맨드 객체로 처리하기 */
	/*
		요청 파라미터를 필드로 가지고 있는
		객체를 커맨드 객체라고 한다.
		필드값이 저장되려면 setter가 선언되어 있어야 한다.
	*/
	
	// location.href='${contextPath}/member/detail3?id=admin&pw=1234';
	@GetMapping("detail3")
	public String detail3(String id  // @RequestParam은 생략할 수 있다. 파라미터 id가 없는 경우 null이 저장된다.
			            , String pw  // @RequestParam은 생략할 수 있다. 파라미터 pw가 없는 경우 null이 저장된다.
			            , Model model) {
		
		Member member = new Member(id, pw);
		
		model.addAttribute("member", member);
		
		return "member/detail";
		
	}
	/*
	 * //<form action"${contextPath}/member.detail4" method="get">
	 * 
	 * @GetMapping("detail4") public String getDetail4(Member member // 파라미터 id, pw를
	 * setId(), setPw() 메소드를 이용해서 member 객체에 저장한다. ,Model model) {
	 * model.addAttribute("member", member); return "member/detail";
	 * 
	 * }
	 */
	
	/*
	 * //<form action"${contextPath}/member.detail4" method="post">
	 * 
	 * @PostMapping("detail4") // 요청 : URLMapping + 요청메소드 public String
	 * postDetail4(Member member , Model model) { // model.addAttribute("member",
	 * member); return "member/detail"; }
	 */
	
	
	@PostMapping("/detail4")
	public String detail4(Member m) {  // 파라미터 id, pw를 setId(), setPw()메소드를 이용해서 member 객체에 저장해 준다.
		
		// Model에 아무 것도 저장하지 않았음을 생각하고 확인하자.
		// 커맨드 객체는 자동으로 Model에 저장된다.
		// Model에 저장되는 이름은 객체이름 m이 아니고, 클래스이름 Member가 member로 변환되어 사용된다.
		// 뷰에서 ${m}게 하면 안되고, ${member}게 해야 한다.
		
		return "member/detail";
		
	}
	
	// 뷰로 전달할 커맨드 객체 이름을 바꾸고 싶으면 @ModelAttribute 애너테이션을 사용하면 된다.
	@PostMapping("/detail5")
	public String detail5(@ModelAttribute(value="guest") Member m) {  // 파라미터 id, pw를 이용해 Member m를 만들고, Model에 guest라는 이름의 속성으로 저장하시오.
	                                                                  // 뷰에서 ${guest.id}, ${guest.pw} 방식으로 확인 가능하다.
		
		return "member/guest";  // 뷰를 guest.jsp로 바꿔서 확인
		
	}
	
}