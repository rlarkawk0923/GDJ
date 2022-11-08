package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardDetailService implements BoardService {
<<<<<<< HEAD

=======
//list-boardController-boardDetailService
// boardDao-boarddetail-boardController
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
<<<<<<< HEAD
		String str = request.getParameter("board_no");    // 파라미터 board_no가 온다.
		Optional<String> opt = Optional.ofNullable(str);  // 파라미터가 null일 수 있다.
		int board_no = Integer.parseInt(opt.orElse("0")); // 파라미터가 null이면 "0"을 쓰라.
=======
		String str = request.getParameter("board_no");	// 파라미터 board_no
		Optional<String> opt = Optional.ofNullable(str);// 파라미터가 null일 수 있다.
		int board_no = Integer.parseInt(opt.orElse("0"));// 파라미터가 null이면 "0"을 쓰라.
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
		
		// DB에서 게시글 정보 가져오기
		Board board = BoardDao.getInstance().selectBoardByNo(board_no);
		
		// 게시글 정보를 Jsp로 보내기 위해서 request에 저장
		request.setAttribute("board", board);
		
		// 어디로 / 어떻게
<<<<<<< HEAD
		ActionForward af = new ActionForward();
		af.setView("/board/detail.jsp");  // webapp/board/detail.jsp를 의미함
		af.setRedirect(false);  // 포워드
		return af;
		
	}

}
=======
		ActionForward af = new ActionForward(); 
		af.setView("/board/detail.jsp"); // webapp/board.list.jsp를 의미함
		af.setRedirect(false); // 포워드
		return af;
	}

}
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
