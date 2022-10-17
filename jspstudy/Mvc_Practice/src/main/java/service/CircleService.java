package service;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CircleService")
public class ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	// 요청 파라미터
	double width = Double.parseDouble(request.getParameter("radius"));

	
	// 포워드 할 데이터
	request.setAttribute("radius", radius);
	request.setAttribute("area", radius * radius*Math.PI);
	request.setAttribute("shape", "rectangle");
	
	// 어디로 어떻게?
	ActionForward af = new ActionForward();
	af.setView("views/output.jsp");
	af.setRedirect(false);
	return af;

}


}
       
