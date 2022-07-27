package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Car car = new Car();
		
		car.addOil(100); //인수(50) 매개변수(int o)로 전달됨
		car.addOil(5);
		System.out.println(car.oil);
		
		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		
		car.pushBrake();
		car.pushBrake();
		car.pushBrake();
		
		
		//System.out.println("기름" + car.oil);
		//System.out.println("속도" + car.speed);
		car.panel();

	}

}
