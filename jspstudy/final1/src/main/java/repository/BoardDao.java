package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Board;

public class BoardDao {

	private SqlSessionFactory factory;

	private static BoardDao dao = new BoardDao();

	private BoardDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static BoardDao getInstance() {
		return dao;
	}

	// 1. 목록보기
	public List<Board> selectAllBoards() {
		SqlSession ss = factory.openSession(); // SELECT(커밋이 필요 없는 경우)
		List<Board> boards = ss.selectList("mybatis.mapper.board.selectAllBoards"); // mybatis.mapper.board 매퍼의
																					// selectAllBoards 아이디를 가진 쿼리문 실행
		ss.close();
		return boards;
	}

	// 2. 전체 게시판 수
	public int selectAllBoardsCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne("mybatis.mapper.board.selectAllBoardsCount");
		ss.close();
		return count;
	}

	// 3. 게시글 상세보기
	public Board selectBoardByNo(int boardNo) {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne("mybatis.mapper.board.selectBoardByNo", boardNo); // boardNo를 파라미터로 전달
		ss.close();
		return board;
	}
	
	
	// 4. 새 게시물 추가
	public int addBoard(Board board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("mybatis.mapper.board.addBoard", board);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;

	}


	// 5. 게시글 삭제
	public int deleteBoard(int boardNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("mybatis.mapper.board.deleteBoard", boardNo);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
}
