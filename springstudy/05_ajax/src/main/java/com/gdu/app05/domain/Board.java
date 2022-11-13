package com.gdu.app05.domain;

public class Board {
	
	private String title;
	private String content;
	
	public Board() {
		
	}
	
	public Board(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getcontent() {
		return content;
	}
	public void setcontent(String content) {
		this.content = content;
	}
	
	

}
