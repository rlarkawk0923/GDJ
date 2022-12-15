package com.gdu.app15.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app15.mapper.GoodMapper;

@Service
public class GoodServiceImpl implements GoodService {

	@Autowired
	private GoodMapper goodMapper;
	
	@Override
	public Map<String, Object> getGoodCheck(HttpServletRequest request) {
		int blogNo = Integer.parseInt(request.getParameter("blogNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		Map<String, Object> map = new HashMap<>();
		map.put("blogNo", blogNo);
		map.put("userNo", userNo);
		Map<String, Object> result = new HashMap<>();
		result.put("count", goodMapper.selectUserGoodCount(map));
		return result;
	}
	
	@Override
	public Map<String, Object> getGoodCount(int blogNo) {
		Map<String, Object> result = new HashMap<>();
		result.put("count", goodMapper.selectBlogGoodCount(blogNo));
		return result;
	}
	
	@Override
	public Map<String, Object> mark(HttpServletRequest request) {
		int blogNo = Integer.parseInt(request.getParameter("blogNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		Map<String, Object> map = new HashMap<>();
		map.put("blogNo", blogNo);
		map.put("userNo", userNo);
		Map<String, Object> result = new HashMap<>();
		if (goodMapper.selectUserGoodCount(map) == 0) {  // 해당 게시물의 "좋아요"를 처음 누른 상태
			result.put("isSuccess",goodMapper.insertGood(map) == 1);  // 신규 삽입			
		} else {
			result.put("isSuccess", goodMapper.deleteGood(map) == 1);  // 기존 정보 삭제		
		}
		return result;
	}
	
}
