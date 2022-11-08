package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardRemoveService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));
<<<<<<< HEAD
		int board_no = Integer.parseInt(opt.orElse("0"));
		
		// DB로 board_no 보내서 삭제
=======
		//int board_no = Integer.parseInt(request.getParameter("board_no")); integerparseint는 null값 허용안되기 때문에 option으로 감싼것
		int board_no = Integer.parseInt(opt.orElse("0")); // 0을 dao 측에 전달하면 실행결과가 0=>삭제되지 않는 번호, 없는테이블
		
		//DB로 board_no 보내서 삭제
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
		int result = BoardDao.getInstance().deleteBoard(board_no);
		
		// 삭제 성공/실패 여부 콘솔에 출력
		System.out.println("삭제 여부 : " + result);
		
<<<<<<< HEAD
		// 어디로 / 어떻게
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/board/list.do");  // Redirect할때는 매핑으로 이동
		af.setRedirect(true);                                     // DELETE 이후에는 Redirect
		return af;
		
	}

}
=======
		// 어디로 어떻게
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/board/list.do"); // Redirect할때는 매핑으로 이동 목록서비스 돌려서 새 목록 가져와야함 특정 jsp로 이동하지 않음
		af.setRedirect(true); // DELETE 이후에는 Redirect(두번요청)하는게 기본
		return af;
	}

}
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
