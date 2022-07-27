package ex02_two_dim;

public class examination {

	public static void main(String[] args) {
		
		
		
		String serial = "1234567"; // 
		if(serial.startsWith("1")|| serial.startsWith("2")){
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		System.out.println();
		
		int a = 7;
		int b = 2;
		int result1 = a + b;
		int result2 = a - b;
		int result3 = a * b;
		int result4 = a / b;
		
		System.out.println(a +" + "+ b + " = " + result1);
		System.out.println(a +" - "+ b + " = " + result2);
		System.out.println(a +" * "+ b + " = " + result3);
		System.out.println(a +" / "+ b + " = " + result4);
		
	}

}
