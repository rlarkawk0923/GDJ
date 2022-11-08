package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class DetailService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long freeNo = Long.parseLong(request.getParameter("freeNo"));
		request.setAttribute("free", FreeDAO.getInstance().selectFreeByFreeNo(freeNo));
		return new ActionForward("free/detail.jsp", false);
		
	}

}
