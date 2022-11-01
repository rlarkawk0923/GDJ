package com.gdu.app04.domain;

public class Board {
	
	private String title;
	private int hit;
	
	public Board() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Board(String title, int hit) {
		super();
		this.title = title;
		this.hit = hit;
	}
	
	

}
