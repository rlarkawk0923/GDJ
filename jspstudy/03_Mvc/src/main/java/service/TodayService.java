package service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class TodayService implements MyService{
	@Override // 생략가능하지만 생략하지 말기
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		// Today가 하는 일
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a h:mm:ss");
		String now = sdf.format(date);
		
		// 뷰(Jsp)로 전달할 데이터는 request에 속성으로 저장
		request.setAttribute("result", now);
		
		// 어디로 갈 것인가ㄷㄷ 
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/result.jsp");
		actionForward.setRedirect(false);
		
		// ActionForward 반환
		return actionForward;
		
		
	}
	
}