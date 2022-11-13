package com.gdu.app02.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 	@Controller
 	
 	컨트롤러.
 	@Component에 의해서 자동으로 Bean으로 만들어지고 스프링에 의해서 사용됨
 	
 	컨트롤러:매핑값 좍 받아서 동작함
*/

@Controller
public class MvcController {
	
	// 메소드 1개 = 요청 1개와 응답 1개를 처리하는 단위
	
	/*
	  @RequestMapping
	  리퀘스트 매핑, 요청을 인식하는 애너테이션
	  매핑과 요청메소드(GET/POST)를 인식한다
	  
	  속성
	  	1) value : URLMapping
	  	2) method : RequestMethod
	  	
	*/
	
	// welcome 파일 작업하기
	// URLMapping으로 "/"를 요청하면 "/WEB-INF/views/index.jsp"를 열어준다. ("/"로 시작하면 웹루트에서 시작됨)
	
	@RequestMapping(value="/", method=RequestMethod.GET) // method="GET"으르 적으면 안됨, 메소드먼저 만들어야 애너테이션 임포트 가능
	
	// 메소드 작성 방법
	// 1. 반환타입 : String (응답할 뷰(JSP)의 이름을 반환)
	// 2. 메소드명 : 아무일도 안함. 맘대로 작성
	// 3. 매개변수 : 선택 (요청이 있으면 request, 응답을 만들면 response 등)
	
	public String welcome() { // 메소드 만듦
		return "index"; // DispatcherServlet의 ViewResolver에 의해서 해석된다.
						// prefix="/WEB-INF/views"
						// suffix=".jsp"
						// prefix와 suffix(servlet-context에들어있음)에 의해서 "/WEB-INF/views/index.jsp"와 같이 해석되고 처리된다.
		
		// index.jsp로 forward했을까? redirect했을까?
		// 정답 : forward했다.
		// redirect할때는 return "redirect:경로";처럼 반환한다.
	}
	
	// <a href="${contextPath}/animal">
	@RequestMapping(value="/animal", method=RequestMethod.GET)
		public String 동물보러가기() {
		// /WEB-INF/views/ + gallery/animal + .jsp 실제 경로
		return"gallery/animal";
	}
	//@RequestMapping(value="/animal", method=RequestMethod.GET) 
	//@RequestMapping(value="animal", method=RequestMethod.GET)슬래시가 없어도 됨
	//@RequestMapping(value="/animal" )GET 없어도 됨
	//@RequestMapping("/animal") value없어도 value로 인식
	//@RequestMapping("animal") 최종버전 삽가능
	
	@RequestMapping("flower")
	public String 꽃보러가기() {
		// return "/gallery/flower" 슬래시있어도됨
		return "gallery/flower"; // 슬래시없어도됨
	}

		// <a href="${contextPath}/animal/flower">
		@RequestMapping("animal/flower")
		public String 동물보고꽃보고() {
			
			// redirect: 다음에는 항상 다른 URL Mapping을 적어 준다.
			
			return "redirect:/flower";
			
		}
		
		
		
		// <a href="${contextPath}/want/animal?filename=animal5.jpg">
		
		
		@RequestMapping("want/animal")
		public String 동물5보기(HttpServletRequest request) {
			
			System.out.println(request.getParameter("filename"));
			
			return "gallery/animal5";
			
		}
		@RequestMapping("response")
		public void 응답만들기(HttpServletResponse response, HttpServletRequest request) {
			
			// 응답 만들때는 return을 하지 않는다.
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('동물 보러 가자.')");
				out.println("location.href='" + request.getContextPath() + "/animal';");
				out.println("</script>");
			}catch(Exception e) {
				e.printStackTrace();
			}
			

			
		}
}
