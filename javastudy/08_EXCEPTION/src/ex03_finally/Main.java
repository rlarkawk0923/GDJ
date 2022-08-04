package ex03_finally;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//finally 블록
		// 1.try-catch문 마지막에 추가하는 블록
		// 2.언제나 마지막에 실행되는 블록
		// 3.생략가능
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			System.out.println(age >= 20 ? "성인" : "미성년자");
		} catch(Exception e) {
			System.out.println("예외 발생");
		}finally {
			sc.close();//예외발생해도 닫고 예외발생안해도 닫음 // 자원을 반납할때 주로 사용됨
			System.out.println("finally 블록 실행");
		}

	}

}
