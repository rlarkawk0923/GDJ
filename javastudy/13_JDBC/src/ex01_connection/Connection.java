package ex01_connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	public static void main(String[] args) {

		// OracleDriver 열기(메모리에 로드하기)
		// 1.oracle.jdbc.OracleDriver
		// 2.oracle.jdbc.driver.OracleDriver

		try {
			//
			Class.forName("oracle.jdbc.OracleDriver");// ""안에 들어간 클래스가 없을때 발생하는 예외 처리가 필요함
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		}
		java.sql.Connection con = null;
		// DriverManager로부터 Connection 받아오기
		try {

			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT"; // 대문자 소문자 구분 없음
			String password = "TIGER"; // 대소문자 구분함 계정 만들 때 사용한 대소문자 지켜야함
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속 성공");

		} catch (SQLException e) {
			System.out.println("DB접속 오류");

		}

		// Connection 종료
		// JDBC에서는 접속종료가 굉장히 중요!
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}