package ex03_string;

import java.util.Scanner;

public class Ex02_StringBuilder {

	public static void main(String[] args) {
		
		// java.lang.StringBuilder 클래스
		// java.lang 소속 클래스는 import 없음
		
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		sb.append(true);
		sb.append('T');
		sb.append(3.14);
		sb.append("hello");
		
		System.out.println(sb);
		
		//StringBuilder로 만든 문자열은 반드시 마지막에 String으로 변환해야함
		String result = sb.toString();
		System.out.println(result);
		System.out.println(result.equals("1trueT3.14hello"));
		
		//String 과 StringBuilder의 성능 테스트
		//abcdefghijklmnopqrstuvwxyz 만들기
		String alphabet1 = "";
		long begin1 = System.nanoTime();
		for(char ch = 'a'; ch <='z'; ch++) {
			alphabet1 += ch;
		}
		long end1 = System.nanoTime();
		System.out.println((end1 - begin1) + alphabet1);
		
		StringBuilder sb2 = new StringBuilder();
		long begin2 = System.nanoTime();
		for(char ch = 'a'; ch <= 'z'; ch++){
			sb2.append(ch);
		}
		long end2 = System.nanoTime();
		String alphabet2 = sb2.toString();
		System.out.println((end2- begin2) + alphabet2);
		
		//연습 대문자 6자리로 구성된 인증코드 작성하기
		StringBuilder sbCode = new StringBuilder();
		for(int n = 0; n < 6; n++) {
			sbCode.append((char)((int)(Math.random() * 26)+'A'));
		}
		String code = sbCode.toString();
		System.out.println("인증코드 : " + code);
		
		
		//연습. 1 2 3 4 5 6 7 8 9 10 만들기
		StringBuilder sbPaging = new StringBuilder();
		for(int n =1; n<=10; n++) {
			sbPaging.append(n + " ");
		}
		
		String paging = sbPaging.toString();
		System.out.println(paging);
		
		//연습. char 타입의 성별을 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("성별(남/여)을 입력하세요>>> ");
		char gender = sc.next().charAt(0);
		System.out.println(gender);
		
		sc.close();
		
		
	}

	


}