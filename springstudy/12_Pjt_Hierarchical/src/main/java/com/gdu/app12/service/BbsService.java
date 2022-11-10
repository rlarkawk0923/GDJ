package com.gdu.app12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


public interface BbsService {
	public void findAllBbsList(HttpServletRequest request, Model model);
	public int addBbs(HttpServletRequest request); // 왜 리퀘스트로 넘겼슬까 ip때문에 ip알려면 리퀘스트필요함ㄴ
	public int addReply(HttpServletRequest request);
	public int removeBbs(int bbsNo);
}