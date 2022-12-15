package com.gdu.app15.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodMapper {
	public int selectUserGoodCount(Map<String, Object> map);
	public int selectBlogGoodCount(int blogNo);
	public int insertGood(Map<String, Object> map);
	public int deleteGood(Map<String, Object> map);
}
