package repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Student;

public class StudentDao {
	
	//field -SqlSessionFactory
	private SqlSessionFactory factory;
	
	// singleton-pattern
	private static StudentDao dao = new StudentDao();
	private StudentDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static StudentDao getInstance() {
		return dao;
	}
	
	
	   // 이렇게도 가능.~
	   String mapper = "mybatis.mapper.student.";
	// method
	
	//1. 학생목록
	public List<Student> selectAllStudents(){
		SqlSession ss = factory.openSession();
		List<Student> students = ss.selectList("mybatis.mapper.student.selectAllStudents");
		ss.close();
		return students;
	}
	
	// 2. 전체 학생 수
	public int selectAllStudentsCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne("mybatis.mapper.student.selectAllStudentsCount");
		ss.close();
		return count;
	}
	
	// 3. 전체 평균
	public double selectAllStudentsAverage() {
		SqlSession ss = factory.openSession();
		double average = ss.selectOne("mybatis.mapper.student.selectAllStudentsAverage");
		ss.close();
		return average;
	}
	
	// 4. 학생 등록
	public int insertStudent(Student student) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertStudent", student);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}

	// 5. 평균범위 조회
	public List<Student> selectStudentsByAve(Map<String, Double>map){//<><=(generic) 안은 대문자로 시작
		SqlSession ss = factory.openSession();
		List<Student> students = ss.selectList(mapper+ "selectStudentsByAve", map);
		ss.close();
		return students;
		
	}
	// 6. 평균범위 조회 : 개수
	public int selectStudentsByAveCount(Map<String, Double>map){//<><=(generic) 안은 대문자로 시작
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectStudentsByAveCount", map);
		ss.close();
		return count;
		
	}
	// 7. 평균범위 조회 : 평균
	public double selectStudentsByAveAverage(Map<String, Double>map){//<><=(generic) 안은 대문자로 시작
		SqlSession ss = factory.openSession();
		double average = ss.selectOne(mapper + "selectStudentsByAveAverage", map);
		ss.close();
		return average;
		
	}
	// 8. 학생 삭제
	public int deleteStudent(int stuNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteStudent", stuNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
}