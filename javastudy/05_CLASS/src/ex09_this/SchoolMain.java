package ex09_this;

public class SchoolMain {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		student1.setStuNo("11025");
		student1.setName("전지현");
		
		
		//System.out.println(student);
		//student.printThis();
		
		//student와 this는 같다
		//this.stuNo = student.stuNo
		//this.name = student.name
		
		Student student2 = new Student("11026", "정우성");
		
		School school = new School(2);
		school.addStudent(student1);
		school.addStudent(student2);
		school.addStudent(student1);
		//school.addStudent(student3); //없는인덱스
		
		school.printStudents();
	}

}
