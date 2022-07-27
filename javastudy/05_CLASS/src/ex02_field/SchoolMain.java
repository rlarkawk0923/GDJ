package ex02_field;

public class SchoolMain {

	public static void main(String[] args) {
		
		//스쿨 클래스에 학생 학번과 이름 저장하고 출력하기
		
		School school = new School();// 객체선언, 객체 생성
		
		school.name = "경인중학교"; //학교 이름 지정
		
		Student student1 = new Student(); // student1 주소값 생성
		student1.stuNo = "11025"; //
		student1.name = "전지현";
		
		//School school = new School();
		
		//school.name = "경인중학교";
		
		//Student student1 = new Student();
		//student1.stuNo = "11025";
		//student1.name = "전지현";
		//Student student2 = new Student();
		//student2.stuNo = "11026";
		//student2.name = "정우성";
		
		//school.students[0]= student1;
		//school.students[1]= student2;
		
		
		//for(int i = 0; i < school.students.length; i++) {
		//	System.out.println(school.students[i].stuNo);
		//	System.out.println(school.students[i].name);
		}
	}

