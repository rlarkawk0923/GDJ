package com.gdu.notice.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.notice.domain.NoticeDTO;
import com.gdu.notice.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper mapper; // dao가 매퍼로 바뀐것

	@Override
	public void findAllNotices(Model model) {
		model.addAttribute("notices", mapper.selectAllNotices()); // 리스트.jsp로 모델로 싣는 코드
	}

	@Override
	public void findNoticeByNo(int noticeNo, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNotice(HttpServletRequest request, HttpServletResponse response) { // 인코딩은 request용이기때모네 리스폰스용 utf-8인코딩 코드 넣어줘야함
		NoticeDTO notice = new NoticeDTO();
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		// 노티스 받아온거 매퍼로 넘기는거
		int result = mapper.insertNotice(notice);
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			PrintWriter out = response.getWriter();
		if(result >0) { // if(result == 1){ int 값은 0이나 1로 넘어오기 때문에 둘다 삽입성공 표시, 1은 삽입된 데이터 개수
			out.println("<script>");
			out.println("alert('새로운 공지사항이 등록되었습니다.');");
			
			out.println("location.href='notice/ntc/list';"); // 컨텍스트패스는 직접 적는거 지양하자
			out.println("location.href='"+request.getContextPath()+"/ntc/list';"); // 자바에서 컨텍스트패스는 리퀘스트로 받아와야함 request, 로케이션이동은 리다이렉트 이동
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('공지사항이 등록되지 않았습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
		out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifyNotice(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNotice(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
