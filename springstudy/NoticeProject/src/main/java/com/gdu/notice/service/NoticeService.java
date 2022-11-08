package com.gdu.notice.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface NoticeService {
	
	public void findAllNotices(Model model);
	public void findNoticeByNo(int noticeNo, Model model);//셀렉트 결과를 가지고 포워딩하기때문에 모델
	public void addNotice(HttpServletRequest request, HttpServletResponse response);
	public void modifyNotice(HttpServletRequest request, HttpServletResponse response); // 파라미터유지
	public void removeNotice(HttpServletRequest request, HttpServletResponse response);
//	public void addNotice(NoticeDTO notice, HttpServletResponse response);
//	public void modifyNotice(NoticeDTO notice, HttpServletResponse response); // 파라미터유지
//	public void removeNotice(int noticeNo, HttpServletResponse response);
	
	
}