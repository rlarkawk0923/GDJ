package com.gdu.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.notice.domain.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	public List<NoticeDTO> selectAllNotices(); // 공지목록이니까 리스트, 매퍼랑 인터페이스 합쳐짐
	
	public int insertNotice(NoticeDTO notice);
	
	
	// 리저트값                       파라미터
	public NoticeDTO selectNoticeByNo(int noticeNo); 
	public int updateHit(int noticeNo); // 위 상세보기랑 같이 돌아갈
	public int updateNotice(NoticeDTO notice);
	public int deleteNotice(int noticeNo);
	
	
	
}