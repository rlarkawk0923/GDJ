package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;

public class FreeDAO {
	

	private SqlSessionFactory factory;
	
	private static FreeDAO dao = new FreeDAO();
	private FreeDAO() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	String mapper = "mybatis.mapper.free.";

	public static FreeDAO getInstance() {
		return dao;
	}
	
	public List<Free> selectAllBoards(){
		SqlSession ss = factory.openSession();
		List<Free> boards = ss.selectList("mybatis.mapper.free.selectAllBoards");
		ss.close();
		return boards;
	}
	
	public int insertBoard(Free board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("mybatis.mapper.free.insertBoard",board);
		if(result > 0) {
			ss.commit();
		
		}
		ss.close();
		return result;
	}
	
	public int selectBoardsByNO(int freeNo) {
		SqlSession ss = factory.openSession();
		Free board = ss.selectOne(mapper + "selectBoardsByNO", freeNo);
		ss.close();
		return board;
	}
	
	public int deleteBoard(Free board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteBoard", board);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	

}
