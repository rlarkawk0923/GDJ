package ex01_exception;

import java.util.Scanner;

public class Main {

	public static void m1() { // static은 static이 부를수 있음

		// NullPointerException : null값이 어떤 메소드를 호출할 때 발생
		String[] hobbies = new String[5];

		hobbies[1] = "수영";
		hobbies[2] = "골프";
		hobbies[3] = "영화";
		hobbies[4] = "집콕";

		for (int i = 0; i < hobbies.length; i++) {
			if (hobbies[i].equals("수영")) {
				System.out.println("취미가 나와 같군요");
			}
		}

	}

//nullpointexception 회피	
	public static void m2() { // static은 static이 부를수 있음

		String[] hobbies = new String[5];

		hobbies[1] = "수영";
		hobbies[2] = "골프";
		hobbies[3] = "영화";
		hobbies[4] = "집콕";

		for (int i = 0; i < hobbies.length; i++) {

			if (hobbies[i] != null && hobbies[i].equals("수영")) {
				// if( hobbies[i].equals("수영") && hobbies[i] != null ) { //순서 주의
				System.out.println("취미가 나와 같군요");
			}
		}

	}

	public static void m3() {

		// NumberFormatException : String을 Number타입으로 변경할 때 발생
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력(필수) >>> ");
		String name = sc.nextLine();
		System.out.println("나이 입력(선택) >>> ");
		String strAge = sc.nextLine(); // 입력없이 Enter만 누르면 strAge는 빈 문자열을 가짐
		int age = Integer.parseInt(strAge);

		System.out.println("이름 : " + name + ", 나이 : " + age + "살");
	}

	public static void m4() {

		// NumberFormatException 회피
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력(필수) >>> ");
		String name = sc.nextLine();
		System.out.println("나이 입력(선택) >>> ");
		String strAge = sc.nextLine(); // 입력없이 Enter만 누르면 strAge는 빈 문자열을 가짐
		int age;
		if (strAge.isEmpty()) {
			age = 0;
		} else {
			age = Integer.parseInt(strAge);

		}
		System.out.println("이름 : " + name + ", 나이 : " + age + "살");
	}

	public static void main(String[] args) { // 에러요인은 밑에서부터 확인 맨밑오류가 첫 오류포인트
		m3();
	}

}
