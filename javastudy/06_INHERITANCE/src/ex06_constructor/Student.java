package ex06_constructor;

public class Student extends Person {
	
	private String school;
	
	public Student(String name, String school) {
		super(name);
		this.school = school;
	}

	//public Student(String name, String school) {
	//	super(name);
	//	this.school =school;
	//}

	public String getSchool() {//getter
		return school;
	}

	public void setSchool(String school) {//setter
		this.school = school;
	}
	
	

}
