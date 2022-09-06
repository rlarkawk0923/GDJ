package ex02_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateSequenceMain {

	public static void main(String[] args) {
		
		// Connection 생성
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT"; // 대문자 소문자 구분 없음
			String password = "TIGER"; // 대소문자 구분함 계정 만들 때 사용한 대소문자 지켜야함
			con = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		}catch(SQLException e) {
			System.out.println("DB접속정보 오류");
		}
		
		// CREATE TABLE 실행
		PreparedStatement ps = null;
		try {
		String sql = "CREATE SEQUENCE BOARD_SEQ NOCACHE";
		ps = con.prepareStatement(sql);
		ps.execute();

	}catch(SQLException e) {
		e.printStackTrace();
	}
		try {
			if(ps != null) ps.close();
			if(con != null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
