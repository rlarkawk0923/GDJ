package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class FreeRemoveService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("stuNo"));
		int freeNo = Integer.parseInt(opt.orElse("0"));
		

		int result = FreeDAO.getInstance().deleteBoard(freeNo);
				

		PrintWriter out = response.getWriter();
		if(result > 0 ) {
			
			out.println("<script>");
			out.println("alert('학생 정보가 삭제되었습니다.')");
			out.println("location.href='" + request.getContextPath()+ "/free/list.do'");
			out.println("</script>");
		
		}
		out.close();
		
		return null;
		
	}

}