package ex08_override;

public class Rectangle extends Shape {
	
	private double width;
	private double height;
	
	
	public Rectangle(String type, double width, double height) {
		super(type);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		super.info();
		System.out.println("너비 : " + width + "높이 : " + height);
		System.out.println("넓이 : "+ getArea());
	}
	
}
