package com.gdu.rest.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.service.MemberService;

/*
  	REST : Representational State Transfer
  	
  	1. 자원을 정의하고 자원의 주소를 지정하는 방식에 대한 하나의 형식이다.
  	2. REST 방식을 따르는 시스템을 "RESTful하다"라고 표현한다.
  	3. 동작을 URL + Method 조합으로 결정한다.
  	4. 파라미터가 URL에 경로처럼 포함된다.(?를 사용하지 않는다.)
  	5. CRUD 처리 방식
  			         URL			METHOD
  		1)삽입	  /members			POST
  		2)목록	  /members			GET
  		3)상세	  /members/1		GET
  		4)수정	  /members  		PUT (post와 이름구분하기 위해 put이라고함)
  		5)삭제	  /members/1  		DELETE(사실상 get방식)
  	
  	
 */
@RestController // 이 컨트롤러는 모든 메소드에 @ResponseBody 애너테이션을 추가한다.
public class MemberRestController {
	
	@Autowired
	private MemberService memberService;
	
	// 삽입
	@PostMapping(value="/members", produces = "application/json")
	public Map<String, Object> addMember(@RequestBody MemberDTO member, HttpServletResponse response){ // @requestbody 요청 본문을 뒤져라, response 응답을 만드는 용도
		return memberService.register(member, response);
		
	}
	
	// 목록
	@GetMapping(value="/members/page/{page}", produces="application/json")
	public Map<String, Object> getMemberList(@PathVariable(value="page", required = false) Optional<String> opt){// @PathVariable 리퀘스트파람과 비슷하지만 디폴트 밸류없이 null값 받기 가능한 option으로 처리함
		int page = Integer.parseInt(opt.orElse("1"));
		return memberService.getMemberList(page);
	}
	  
	// 상세
	@GetMapping(value="/members/{memberNo}", produces = "application/json")
	public Map<String, Object> getMember(@PathVariable(value="memberNo", required = false) Optional<String> opt){
		int memberNo = Integer.parseInt(opt.orElse("0"));
		return memberService.getMemberByNo(memberNo);
	}
	
	// 수정
	@PutMapping(value="/members", produces = "application/json")
	public Map<String, Object> modifyMember(@RequestBody Map<String, Object>map, HttpServletResponse response){
		return memberService.modifyMember(map, response);
	}
	
	// 삭제
	@DeleteMapping(value="/members/{memberNoList}", produces="application/json")
	public Map<String, Object> removeMemberList(@PathVariable String memberNoList){
		return memberService.removeMemberList(memberNoList);
	}
	   
	
}
