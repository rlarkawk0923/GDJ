package ex03_method;

public class CalculatorMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Calculator calculator = new Calculator();
		
		//calculator 객체의 add() 메소드 호출
		// 1. 2,3 : 인수(add 메소드로 전달하는 값), 인수는 매개 변수에 저장된다.
		// 2. answer : add 메소드의 반환값(return result)이 저장된다.
		int answer = calculator.add(2, 3);
		
		System.out.println(answer);
		
		
		System.out.println(calculator.sub(100, 85));
		System.out.println(calculator.mul(3, 15));
		System.out.println(calculator.div(7, 2));
		
		
		
	

	}

}
