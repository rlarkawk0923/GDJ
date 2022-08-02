package ex06_constructor;

public class Person {
	
	private String name;
	
	public Person(String name) { // String name 매개변수
		this.name = (name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
