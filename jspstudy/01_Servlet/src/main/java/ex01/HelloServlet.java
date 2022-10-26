package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 	Servlet
 	
 	1. 웹 화면을 만드는 자바 클래스
 	2. JSP/Servlet Container(Tomcat)에 의해서 실행
 	3. 서블릿을 실행하면 웹 브라우저가 실행됨
 	4. URL
 		프로토콜://호스트:포트번호/컨텍스트패스(프로젝트이름)/URLMapping(서블릿이름)
 		http://localhost:9090/01_Servlet/HelloServlet
 */
@WebServlet("/HelloServlet") // URL Mapping
public class HelloServlet extends HttpServlet { // Servlet은 HttpServlet을 상속 받으면 된다.
	private static final long serialVersionUID = 1L;
       
    /*
     	1. 생성자
     		1) 가장 먼저 호출
     		2) 생성자 호출 뒤 init() 메소드가 호출
     */
    public HelloServlet() {
        super();
        System.out.println("생성자");
    }

	/*
	 	2. 초기화
	 		1) 각종 초기화 정보 실행
	 		2) 서블릿 환경 설정 처리
	 		3) init() 메소드 호출 뒤 service() 메소드 호출	 
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	/*
	 	3. 서비스
	 		1) 클라이언트의 요청마다 매번 호출
	 		2) Get 방식의 요청은 doGet() 메소드 호출, POST 방식의 요청은 doPost() 메소드 호출
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service");

	
	//service 메소드가 존재하는 경우 doGet()/doPost()가 자동으로 호출되지 않기 때문에
	// 코드를 직접 작성
	
	// 요청 메소드(GET/POST) 확인 : request.getMethod()
	switch(request.getMethod()) {
	case "GET" :
		doGet(request, response); // doGet() 메소드 호출
		break;
	case "POST" :
		doPost(request, response); // doPost() 메소드 호출
		break;
		//서비스가 요청응답에대한 정보를 가지고 있는데 이것을 doGET으로 전달
	}
	
}
	/*
	 	4. doGet
	 		1) GET 방식의 요청을 처리
	 		2) 요청 메소드가 GET인 경우
	 			(1) $.ajax({
	 				'type' : 'GET',
	 				'url' : '/01_Servlet/HelloServlet'
	 			});
	 			(2) <a href="http://localhost:9090/01_Servlet/HelloServlet">링크</a>
	 			(3) <form method="GET"> 또는 <form>
	 			(4) location.href='http://localhost:9090/01_Servlet/HelloServlet'
	 				(window)open('http://localhost:9090/01_Servlet/HelloServlet')
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// response : 사용자에게 전달할 때 사용
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/*
	 	5. doPost
	 		1) Post 방식의 요청을 처리
	 		2) 요청 메소드가 POST인 경우
	 			(1) $.ajax({
	 				'type' : 'POST',
	 				'url' : 'http://localhost:9090/01_Servlet/HelloServlet'
	 			});
	 			(2) <form method="POST" action="http://localhost:9090/01_Servlet/HelloServlet">
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청과 응답 정보를 doGET메소드로 넘겨버림
		doGet(request, response);//doGet 메소드 호출
	}

}
