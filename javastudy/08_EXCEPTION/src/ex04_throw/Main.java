package ex04_throw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//throw
		// 1. 예외 객체를 만들어서 직접 throw 할 수 있다.
		// 2. 자바는 예외로 인식하지 않지만 실제로는 예외인 경우에 주로 사용된다.
		// 3. 예외 메시지를 만들고 .getMessage로 확인한다
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			if(age < 0 || age > 100) {
				throw new RuntimeException("나이는 0 이상 100이하만 가능합니다.");
			}
			System.out.println(age >= 20 ? "성인" : "미성년자");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			sc.close();//예외발생해도 닫고 예외발생안해도 닫음 // 자원을 반납할때 주로 사용됨
			System.out.println("finally 블록 실행");
		}

	}
}
	
	
	/*class Exception{
		private String message;
		public Exception(String message) {
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}
	}
	class RuntimeException extends Exception{
		public RuntimeException(String message) {
			super(message);
		}
	}
	
	Exception e = new RuntimeException("이 나이는 잘못되었어요");
	System.out.println(e.getMessage);
		// TODO Auto-generated method stu
	}
*/ //get.message과정

