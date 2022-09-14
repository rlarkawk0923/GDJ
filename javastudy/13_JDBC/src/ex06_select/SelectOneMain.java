package ex06_select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import domain.Board;

public class SelectOneMain {
	
	public static void main(String[] args) {
		
		// Select문 실행
		// 1. executeQuery()메소드 이용
		// 2. ResultSet 객체 이용
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			// OracleDriver 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// Connection 객체 생성
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
			
			// 쿼리문 작성
			// SELECT문의 결과가 단일 행인 경우
			// 1. WHERE절에서 PK 또는 UNIQUE 칼럼과 동등 비교(=/같은거 찾기)를 수행
			// 2. 집계함수의 결과를 조회(집계함수의 결과는 하나)
			String sql = "SELECT BOARD_NO, TITLE, CONTENT, HIT, CREATE_DATE FROM BOARD WHERE BOARD_NO = 2";
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문 실행
			rs = ps.executeQuery();
			
			// 조회 결과를 행 단위로 스캔하는 rs 객체
			// rs.next()메소드 호출로 조회 결과를 스캔 할 수 있음
			// rs.next()메소드 호출 1건 = 1행 스캔
			// rs.next()메소드는 스캔 성공 시 true, 스캔 실패 시 false 반환
			
			// 조회 결과 1개인 경우
			// rs.next()메소드 호출 1번
			
			if(rs.next()) { // 스캔 성공하면 (조회결과가 있으면)
				
				/* 
				   rs 객체는 행 전체를 가리키는 포인터 역할
				   rs 객체를 통해서 행을 구성하는 열(칼럼) 정보를 가져올 수 있음
				   
				   
				   |BOARD_NO| TITLE | CONTENT | HIT | CREATE_DATE |
				   |	2	| 공지2 |	내용2 |	 0	|	22/07/07  | <= rs.next() 호출 시 rs 포인터
				   
				   rs 객체의 칼럼 정보 가져오기
				   1. 칼럼의 이름
				   		1) rs.getInt("BOARD_NO")
				   		2) rs.getString("TITLE")
				   		3) rs.getString("CONTENT")
				   		4) rs.getInt("HIT")
				   		5) rs.getDate("CREATE_DATE")
				   2. 칼럼의 순서(번호)
				   		1) rs.getInt(1)
				   		2) rs.getString(2)
				   		3) rs.getString(3)
				   		4) rs.getInt(4)
				   		5) rs.getDate(5)
				 
				 */
				
				int board_no = rs.getInt("BOARD_NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("HIT");
				Date create_date = rs.getDate("CREATE_DATE");
				
				// 모든 칼럼의 정부를 하나의 Board 객체로 만듬
				Board board = new Board();
				board.setBoard_no(board_no);
				board.setTitle(title);
				board.setContent(content);
				board.setHit(hit);
				board.setCreate_date(create_date);
				
				
				// 확인
				System.out.println(board);
				
			}else {
				System.out.println("조회 결과가 없습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			// con, ps, rs 닫기/finally 안에서 close할 수 없어서 try/ 선언해 둔 데이터를 모두 닫는다
			try {
				if(rs != null)rs.close();
				if(ps != null)ps.close();
				if(con != null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
