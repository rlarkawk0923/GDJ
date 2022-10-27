package com.gdu.app01.xml08;

import java.util.List;

public class Member {

	// field
	private String name;
	private List<String> course;  // 등록과정(헬스, 수영, 스피닝, 필라테스 등)
	private double height;
	private double weight;
	private BMICalculator bmiCalc;

	// constructor
	public Member(String name, List<String> course, double height, double weight, BMICalculator bmiCalc) {
		super();
		this.name = name;
		this.course = course;
		this.height = height;
		this.weight = weight;
		this.bmiCalc = bmiCalc;
	}
	
	// info() 메소드
	public void info() {
		System.out.println("Name: " + name);
		for(String str : course) {
			System.out.println("Course: " + str);
		}
		System.out.println("Height: " + height);
		System.out.println("Weight: " + weight);
		bmiCalc.info();
	}
	
}