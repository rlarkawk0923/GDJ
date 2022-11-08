package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class RemoveService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long freeNo = Long.parseLong(request.getParameter("freeNo"));
		
		int res = FreeDAO.getInstance().deleteFree(freeNo);
		
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.println("<script>");
			out.println("alert('게시글이 삭제되었습니다.')");
			out.println("location.href='/BoardProject/list.do'");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}
