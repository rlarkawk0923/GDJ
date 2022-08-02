package ex08_override;

public class Shape {
	
	private String type;

	public Shape(String type) {
		//super(); 없어도 됨
		this.type = type;
	}
	
	public double getArea() {
		return 0;
	}
	public void info() {
		System.out.println("도형의 종류 : " + type);
	}

}
