package com.gdu.app15.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app15.domain.UserDTO;
import com.gdu.app15.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		UserDTO loginUser = userMapper.selectUserByMap(map);
		if(loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
		}
	}

}
