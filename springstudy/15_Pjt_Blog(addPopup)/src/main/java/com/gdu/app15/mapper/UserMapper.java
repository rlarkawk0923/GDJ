package com.gdu.app15.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app15.domain.UserDTO;

@Mapper
public interface UserMapper {
	public UserDTO selectUserByMap(Map<String, Object> map);
}
