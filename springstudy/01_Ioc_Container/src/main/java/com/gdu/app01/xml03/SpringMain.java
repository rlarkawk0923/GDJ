package com.gdu.app01.xml03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("xml03/appCtx.xml");
		
		Person person = ctx.getBean("saram", Person.class);
		System.out.println("이름: " + person.getName());
		System.out.println("나이: " + person.getAge());
		Address address =person.getAddr();
		System.out.println("지번: " + address.getJibun());
		System.out.println("도로명: " + address.getRoad());
		System.out.println("건물번호: " + address.getZipCode());
		
		ctx.close();
		
	}

}
