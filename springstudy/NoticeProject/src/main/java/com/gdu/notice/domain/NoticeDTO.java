package com.gdu.notice.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeDTO {
	
	private int noticeNo;
	private String title;
	private String content;
	private int hit;
	private Timestamp createDate;
	private Timestamp modifyDate;

		
	}
	


