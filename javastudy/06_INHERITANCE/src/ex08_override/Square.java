package ex08_override;

public class Square extends Rectangle {
	

	public Square(String type, double width) {
		super(type, width, width); // 슈퍼클래스
		
	}
	
	//@Override								없어도 됨
	//public double getArea() {
	//	// TODO Auto-generated method stub
	//	return super.getArea();
	//}
	
	//@Override
	//public void info() {
	//	// TODO Auto-generated method stub
	//	super.info();
	//}

}
