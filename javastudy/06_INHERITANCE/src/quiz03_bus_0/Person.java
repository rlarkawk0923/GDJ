package quiz03_bus_0;

public class Person extends Bus{
	
	private String name;
	
	
	public Person(int cnt, String name) {
		super(cnt);
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


}
