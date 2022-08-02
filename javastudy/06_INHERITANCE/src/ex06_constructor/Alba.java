package ex06_constructor;

public class Alba extends Student { //extends 적어주면 소스탭에서 생성가능
	
	private String company;
	
	public Alba(String name, String school, String company) {
		super(name, school);
		this.company = company;
	}

	//public Alba (String name , String school, String company) { // String name 매개변수
	//	super(name, school);
	//	this.company = company;
	//}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	


}
