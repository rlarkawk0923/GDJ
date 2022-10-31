package com.gdu.app03.domain;

public class Board {
	
	private int boardNo;
	private String title;
	private String createDate;
	
	public Board() {
		
	}
	public Board(int boardNo, String title,  String createDate) {
		super();
		this.title = title;
		this.boardNo = boardNo;
		this.createDate = createDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	
	}
	


}
