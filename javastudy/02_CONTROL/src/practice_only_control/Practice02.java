package practice_only_control;

public class Practice02 {

	public static void main(String[] args) {
		//연습
		//10~1
		for(int i = 10; i>= 1; --i) {
			System.out.print(i);
		}
		System.out.println();
				
		//연습
		//구구단 7단 출력
		for(int n = 1; n <= 9; n++) {
			System.out.println("7x" + n +"=" + (7*n));
		}
		System.out.println();
				
		//연습
		//1~100 사이의 모든 3의 배수만 출력하기
		for(int n = 1; n<=100; n++) {
			if( n % 3 ==0) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
			
		//연습
		//1~100 모든 정수 더하기(5050)
			
		int total = 0;
		for(int n = 1; n <= 100; n++) {
		total += n;
		}
		System.out.println("전체 합: " + total);
				
		//연습
		//begin~end 모든 정수 더하기
		//begin과 end 중 누가 큰 지 모르는 상황
		//begin을 end 보다 항상 작은 값으로 바꾼 뒤 begin~end 모두 더하기 진행
		//begin end보다 크다면 begin과 end를 교환
		int begin = 3;
		int end = 1;
				
		if(begin>end) {
		int temp;
		temp = begin;
		begin = end;
		end = temp;
		}
			
		int sum = 0;
		for(int n = begin; n <= end; n++) {
		sum += n;
		}
		System.out.println(sum);
		//연습
		//평점(1~5)에 따른 별(★)출력하기
		int point = 3;
		//String star;
		//star = "★";
		//star = "★";//
			
		String star = "";// 빈문자열
			
		for (int n = 0; n < point; n++) {
			star += "★";
		}
				
		System.out.println(star);
		
		// 모금목표 : 100000원
		// 한 번에 30원씩 모금
		//1회 모금 30원 현재 30원
		//2회 모금 30원 현재 60원
		//...
				
		int total1 = 0;
		int money = 30;
		int serial = 0;
		int goal = 100000;
		while(true) { // 무한루프 항상 참, 항상 조건 만족
					
		if(total1 >= goal) {
				break;
			}
					
		total1 += money;
		serial++;
		System.out.println(serial + "회 모금액 " + money + "\t현재 " + total1 + "원");
		}
	}

}
