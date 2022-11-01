package com.gdu.app05.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.domain.Member;
import com.gdu.app05.service.MemberService;
import com.gdu.app05.service.MemberServiceImpl;

@Controller
public class MyController1 {

	@GetMapping("/")
	public String welcome() {
		return "index"; // index.jsp로 forward
	}
	
	@GetMapping("member")
	public String member() {
		return "member"; // member.jsp로 forward
	}
	//field
	@Autowired //Container(root-context.xml)에서 타입이 일치하는 bean을 가져와라
	private MemberService memberService = new MemberServiceImpl();
	
	/*
	  @responseBoady
	  ajax 처리하는 메소드
	  내가 반환하는 값은 뷰(jsp) 이름이 아니고 어떤 데이터(text, json, xml 등)
	 */
	
	@ResponseBody
	@GetMapping(value="member/detail1"
			, produces="text/plain; charset=UTF-8")//produce : 응답 데이터 타입(MIME-TYPEe)
	public String detail1(HttpServletRequest request, HttpServletResponse response) {
		String str = memberService.execute1(request, response);
		return str;
	}
	
	@ResponseBody
	@GetMapping(value="member/detail2"
			, produces="application/json; charset=UTF-8")
	public Member detail2(@RequestParam(value = "id") String id, @RequestParam(value="pw")String pw){
		Member member = memberService.execute2(id, pw);
		return member; // jackson이 member 객체를 {"id":아이디, "pw":패스워드} 형식의 json으로 바꿔서 전달합니다.
		/* 
		추억의 코드
		JSONObject obj = new JSONObject(member);
		return obj.toString();
	*/
	}
	@ResponseBody
	@GetMapping(value="member/detail3"
			, produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> detail3(Member member){
		Map<String, Object> map = memberService.execute3(member);

		return map;
		// return memberService.
	}
	/*
	  	@RequestBody
	  	요청데이터가 body에 포함되어 있다고 알려줌
	  	요청 파라미터에서 사용할 수 없고
	  	post 방식으로 파라미터 없이 데이터가 전달 될 때 사용할 수 있다.
	  	
	 */
	
	@ResponseBody
	@PostMapping(value="member/detail4"
				, produces=MediaType.APPLICATION_JSON_VALUE)
	public Member detail4(@RequestBody Member member){
		return memberService.execute4(member);
	}
	
	
	
}
