package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardAddService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content =request.getParameter("content");
		

		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);		
		board.setContent(content);
		

		int result = BoardDao.getInstance().addBoard(board);
		

		PrintWriter out = response.getWriter();
		if(result > 0 ) {
			
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='" + request.getContextPath()+ "/board/list.do'");
			out.println("</script>");
		
		}else {
			
			out.println("<script>");
			out.println("alert('게시글이 등록에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		out.close();
		
		return null;
	}

}
