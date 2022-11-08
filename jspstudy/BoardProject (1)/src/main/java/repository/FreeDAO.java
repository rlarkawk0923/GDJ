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
	private static FreeDAO instance = new FreeDAO();
	
	private FreeDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FreeDAO getInstance() {
		return instance;
	}
	
	public List<Free> selectFreeList(){
		SqlSession ss = factory.openSession();
		List<Free> list = ss.selectList("mybatis.mapper.free.selectFreeList");
		ss.close();
		return list;
	}
	
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int res = ss.insert("mybatis.mapper.free.insertFree", free);
		if(res > 0) ss.commit();
		ss.close();
		return res;
	}
	
	public Free selectFreeByFreeNo(Long freeNo){
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne("mybatis.mapper.free.selectFreeByFreeNo", freeNo);
		ss.close();
		return free;
	}
	
	public int updateFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int res = ss.update("mybatis.mapper.free.updateFree", free);
		if(res > 0) ss.commit();
		ss.close();
		return res;
	}
	
	public int deleteFree(Long freeNo) {
		SqlSession ss = factory.openSession(false);
		int res = ss.delete("mybatis.mapper.free.deleteFree", freeNo);
		if(res > 0) ss.commit();
		ss.close();
		return res;
	}
	
	public Free selectMostView() {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne("mybatis.mapper.free.selectMostView");
		ss.close();
		return free;
	}
	
}
