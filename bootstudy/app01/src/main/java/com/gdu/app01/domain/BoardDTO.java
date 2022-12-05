package com.gdu.app01.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
	private int boardNo;
	private String title, content, writer, createDate, modifyDate;
	private int passDay; // 작성한지 며칠 됐는지 저장
}
