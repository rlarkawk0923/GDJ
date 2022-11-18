package com.gdu.app13.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app13.service.UserService;

@Controller
public class UserController {

   @Autowired
   private UserService userService;
   
   @GetMapping("/")
   public String index() {
      return "index";
   }
   
   @GetMapping("/user/agree")
   public String agree() {
      return "user/agree";
   }
   
   @GetMapping("/user/join/write")
   public String joinWrite(@RequestParam(value="location", required=false) String location, @RequestParam(value="promotion", required=false) String promotion
                     , Model model) {    // ()에 파라미터 받기
                     
      model.addAttribute("location", location);     // 스프링에서 jsp로 값을 넘겨주는 방식 model
      model.addAttribute("promotion", promotion); 
      return "user/join";   // 파라미터 location, promotion 넘겨받은거 join으로 넘겨줘야 함. ┘      
   }
   
   @ResponseBody   // ajax 처리하기 위한 애너테이션
   @GetMapping(value="/user/checkReduceId", produces=MediaType.APPLICATION_JSON_VALUE)  // produces 써줘야 json데이터를 잭슨이 바꿔옴 (mediaType은 springframework)
   public Map<String, Object> checkReduceId(String id) {
      return userService.isReduceId(id);
   }
   
   @ResponseBody   // ajax 처리하기 위한 애너테이션
   @GetMapping(value="/user/checkReduceEmail", produces=MediaType.APPLICATION_JSON_VALUE)  // produces 써줘야 json데이터를 잭슨이 바꿔옴 (mediaType은 springframework)
   public Map<String, Object> checkReduceEmail(String email) {
      return userService.isReduceEmail(email);
   }
   
   @ResponseBody   // ajax 처리하기 위한 애너테이션
   @GetMapping(value="/user/sendAuthCode", produces=MediaType.APPLICATION_JSON_VALUE)  // 요청 : sendAuthCode
   public Map<String, Object> sendAuthCode(String email) {
      return userService.sendAuthCode(email);
   }
   
   @PostMapping("/user/join")
   public void join(HttpServletRequest request, HttpServletResponse response) {  // request, response는 컨트롤러에서 선언하고 서비스로 넘겨주는 방식
      userService.join(request, response);
   }
   
   @PostMapping("/user/retire")  // 서비스에 넘겨줘야하기 때문에 request, response 다 받아온당 (데이터 흐름 : xml -> 패키지mapper -> 서비스, 서비스impl -> 컨트롤러 -> 뷰)
   public void retire(HttpServletRequest request, HttpServletResponse response) {
      userService.retire(request, response);
   }
   
   // naver로그인창 보면, 내가 있던 창에서 login창을 누르면 뒤에 붙여서 보내는 url 파라미터가 있는데, (login?url=https%3A%2F%2Fvibe.naver.com%2Ftoday)
   // 로그인을 완료하면 원래 있던 창으로 다시 돌아가게끔 하기 위한 것. 
   @GetMapping("/user/login/form")  // <a> 태그를 이용하여 값을 전달하면 GET 방식이다. @GetMapping 
   public String loginForm(HttpServletRequest request, Model model) {
      
      // 요청 헤더 referer : 이전 페이지의 주소가 저장돼 있음(요청헤더에는 그 직전에 주소가 뭔지 referer라는 값으로 저장을 해둠.)
      // referer를 참조함으로써 현재 있는 페이지가 직전에 어떤 페이지에서 요청되어 있는지 알 수 있다(방문자가 어떤 웹사이트나 웹서버에서 왔는지 파악 가능)
      model.addAttribute("url", request.getHeader("referer")); // 로그인 후 되돌아 갈 주소 url를 login.jsp에서 써먹기 위해!
      
	// 네이버 로그인
	model.addAttribute("apiURL", userService.getNaverLoginApiURL(request));
      return "user/login";
   }
   

   @PostMapping("/user/login")   // 간혹 로그인창 페이지와 로그인하고나서 페이지의 매핑방식을 맞춰야되는 경우도 있을 수 있다.
   public void login(HttpServletRequest request, HttpServletResponse response) {
      userService.login(request, response);
   }
   
   @GetMapping("/user/naver/login")
   public void naverLogin(HttpServletRequest request) {
	   userService.getNaverLoginTokenNProfile(request);
   }
   
   @GetMapping("/user/logout")  // 로그아웃 후 웰컴페이지로 이동(redirect)
   public String logout(HttpServletRequest request, HttpServletResponse response) {   // request로부터 구하기
      //request.getSession().invalidate();  -> 컨트롤러에서만 작업하던거 service로 옮겨주고, service에 있는 logout 메소드 가져오기!
      userService.logout(request, response);  
      return "redirect:/";    // 로그아웃하면 자동로그인을 푸는 작업도 이쪽에서
   }
   
   /*
    위와 같은 방식!  여기서 직접 session 선언도 가능하다
   @GetMapping("/user/logout")
   public String logout(HttpSession session) {
      session.invalidate();
      return "redirect:/";    // session을 여기서 직접 선언하고 세션초기화 해준 후, 웰컴페이지로 redirect 해주면 된다.
   }
   */
   
   @GetMapping("/user/check/form") // 마이페이지 가기 전에 비밀번호 확인
   public String requiredLogin_checkForm() {
      
      return "user/check";
   }
   
   
   @ResponseBody
   @PostMapping(value="/user/check/pw", produces="application/json")
   public Map<String, Object> requiredLogin_checkPw(HttpServletRequest request) { // 서비스에서 request로 넘겨주기 때문에 컨트롤러도 request로 받자
      
      return userService.confirmPassword(request);
   }

   @GetMapping("/user/mypage")  // 마이페이지.jsp로 이동
   public String requiredLogin_mypage() {
      return "user/mypage";
   }
   
	@PostMapping("/user/modify/pw")
	public void requiredLogin_modifyPw(HttpServletRequest request, HttpServletResponse response) {
		userService.modifyPassword(request, response);
	}
	
	@GetMapping("/user/sleep/display")
	public String sleepDisplay() {
		return "user/sleep";
	}
	@PostMapping("/user/restore")
	public void restore(HttpServletRequest request, HttpServletResponse response) {
		userService.restoreUser(request, response);
	}
	
	
	
}