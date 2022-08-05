package quiz02_updown.copy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpDownGame {
	
	//필드
	private int rand; // 1~100사이 난수
	private int count; //시도 횟수
	private Scanner sc;
	
	//생성자
	public UpDownGame() {
		//rand, sc 만들기
		rand = (int)(Math.random()*100+1);
		sc = new Scanner(System.in);
		}
		

	//입력
	public int input() { //public int input()throws RuntimeException, InputMismatchException{생략 가능
		
			count++;
			//System.out.println("===Up? Down?===");
			System.out.print("입력 >>> ");
			int n = sc.nextInt();
			if( n < 1 || n> 100) {
				throw new RuntimeException("1~100 사이 정수만 입력할 수 있습니다");
			}
			
			return n;
	
	}
	//실행
	public void play() {
		
		while(true) {
			
		try {
		
		int n = input(); //return 0에서 받음
		
		if( n < rand ) {
			System.out.println("Up!");
		} else if (n> rand){
			System.out.println("Down!");
		}else {
			System.out.println(rand + " 정답입니다. " + count + "번만에 정답!");
			break;
		}
		}catch(InputMismatchException e) {
			sc.next();
			System.out.println("정수만 입력가능합니다");
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		}
}
}