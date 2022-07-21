package ex01_branch;

public class Ex01_if {

	public static void main(String[] args) {
		
		//if문
		//조건을 만족하는 경우에만 실행
		// if(조건) {
		// 		실행문(하나일때는 생략가능/가급적 지우지말기)
		//}
		
		int score = 100;
		
		if(score >=60) { 
			System.out.println("합격");
			System.out.println("축하합니다");
		}
		
		if(score < 60 ) {
			System.out.println("불합격");
		}
	}

}
