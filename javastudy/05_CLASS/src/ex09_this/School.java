package ex09_this;

public class School {
	
	//필드
	private Student[] students; // 배열 생성한다고 지정함 SchoolMaind의 Student 클래스 값 받는
	private int idx; // students 배열의 인덱스. students 배열에 저장된 학생수와 같다
	
	//생성자
	public School(int cnt) {
		students = new Student[cnt]; // SchoolMain의 cnt 값을 가지는 배열 생성
	}
	
	//메소드
	public void addStudent(Student student) {
		if(idx == students.length) {		//full 체크
			System.out.println("Full");
			return; //일반적인 식 //실행 후 조건 만족시 종료하는 느낌
		} //else{ //도 동작가능 실행을 두가지 하는 느낌
		students[idx++] = student; //변수 순서대로 저장하기 위해 배열 필요
	}	
		//idx++; 분리 가능
	

	public void printStudents() {
		//for(int i = 0; i<students.length;i++) { //Nullpointexeption 오류 발생
		/*for(int i = 0; i<idx;i++) {
			System.out.println(students[i].getName() + "," + students[i].getStuNo());
	*/	
	
	for(Student student : students) {
		if (student != null) {//Null 오류 발생 방지
		System.out.println(student.getName()+ "," + student.getStuNo());
		
		
			}
		}
	}
}