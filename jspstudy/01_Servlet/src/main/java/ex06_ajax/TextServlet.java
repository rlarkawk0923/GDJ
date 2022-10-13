package ex06_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// 요청
			request.setCharacterEncoding("UTF-8");

			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age")); // NumberFormatException 발생
			if(age < 0 || age > 100) {
				throw new RuntimeException(age + "살은 불가능한 나이입니다");
			}
			// 응답
			response.setContentType("text/plain; charset=UTF-8");// plain - text의 mime-type / text/html / text/plain /
																	// application/xml / application/json

			PrintWriter out = response.getWriter();
			out.print("이름은 " + name + "이고, 나이는 " + age + "살입니다"); // resData로 넘어감
			out.close();
		} catch (NumberFormatException e) { // 예외 발생하면 응답 건너뛰고 catch 블럭으로 넘어감
			
			// 예외 처리 응답
			response.setContentType("text/plain; charset=UTF-8");
			
			response.setStatus(1000); // 개발자가 임의로 작성한 status(응답코드)
			
			PrintWriter out = response.getWriter();
			out.println("예외발생! 파라미터 age는 정수입니다."); // 개발자가 임의로 작성한 responseText
			out.close(); 
			
		} catch(RuntimeException e) {
			
			response.setContentType("text/plain; charset=UTF-8");
			
			response.setStatus(2000); // 개발자가 임의로 작성한 status(응답코드)
			
			PrintWriter out = response.getWriter();
			out.println(e.getMessage()); // RuntimeException 예외 객체에 저장된 예외 메시지를 responseText로 처리 개발자가 임의로 작성한 responseText
			out.close(); 

			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
