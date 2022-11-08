package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeAddService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content =request.getParameter("content");
		String ip = request.getRemoteAddr();


		Free board = new Free();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setIp(ip);

		
		// DB로 Free board 보내기(삽입)
		int result = FreeDAO.getInstance().insertBoard(board);
		
		// 삽입 성공 / 실패
		PrintWriter out = response.getWriter();
		if(result > 0 ) {
			
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='" + request.getContextPath()+ "/free/list.do'");
			out.println("</script>");
		
		}
		out.close();
		
		return null;
	}
}
