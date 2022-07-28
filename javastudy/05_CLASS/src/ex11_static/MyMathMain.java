package ex11_static;

public class MyMathMain { 

	public static void main(String[] args) {
		
		System.out.println(MyMath.PI);
		System.out.println(MyMath.abs(-5));
		
		//Math math = new Math(); //Math는 객체 만들 필요 없음 객체마다 저장할 필요 없기 때문에
		MyMath math1 = new MyMath();
		System.out.println(math1.abs(-5));
		
		MyMath math2 = new MyMath();
		System.out.println(math1.abs(-8));
		
		MyMath math3 = new MyMath();
		System.out.println(math1.abs(12));
		
		System.out.println(MyMath.pow(2,5));//2의 5제곱(32)
		
	}

}
