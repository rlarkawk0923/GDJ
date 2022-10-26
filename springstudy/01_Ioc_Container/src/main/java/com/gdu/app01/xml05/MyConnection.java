package com.gdu.app01.xml05;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	
	String driverClassName;
	String url;
	String username;
	String password;
	
	
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Connection 반환 메소드
	public Connection getConnection() {
		Connection con = null;
		try {
			con= DriverManager.getConnection(url, username, password);
			System.out.println("Connection 생성완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
