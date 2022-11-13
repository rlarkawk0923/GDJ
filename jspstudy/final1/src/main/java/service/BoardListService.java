package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardListService implements BoardService {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	BoardDao dao = BoardDao.getInstance();
	   
      request.setAttribute("boards", dao.selectAllBoards());
	  request.setAttribute("count", dao.selectAllBoardsCount());

	  ActionForward af = new ActionForward();
      af.setView("/board/list.jsp");
      af.setRedirect(false);
      return af;
   }

}