package practic_only_variable;

public class Practice01 {

	public static void main(String[] args) {
		
		// 연습
		// a = 7이고, b = 2이므로
		// a 나누기 b는 3.5이다.
		int a1 = 7;
		int b1 = 2;
		double result = (double)a1 / b1;//promotion진행 double 하나더 안붙여도됨 //3.5
		System.out.println(result);
				
		// 연습
		// 25를 2와 5로 나눠보기
		int n1 = 25;
		int ten = n1 / 10; //2
		int one = n1 % 10; //5
				
		System.out.println(ten);
		System.out.println(one);
				
		//연습
		//90초를 1분, 30초로 나눠보기
		int second = 90;
		int m = second / 60;
		int s = second % 60;
		System.out.println(m);
		System.out.println(s);

		
		//연습
		// x에 10이 있고, y에 20이있다.
		//x와 y에 저장된 값을 서로 교환하시오
		int x1 = 10;
		int y1 = 20;
		int temp;
		
		temp = x1;
		x1 = y1;
		y1 = temp;
		System.out.println(x1);
		System.out.println(y1);
		
		//연습
		//변수 n을 10 증가시킨뒤 n이 100보다 크다면 true, 아니면 false
		int n2 = 95;
		boolean result7 = (n2 += 10) > 100;
		System.out.println(n2); // 105
		System.out.println(result7); //true
				
		//연습
		//변수 x를 1 증가시킨 뒤 x가 10과 같으면 true, 아니면 false
		int x2 = 9;
		boolean result8 = ++x2 == 10;
		System.out.println(x2); //10
		System.out.println(result8); //true
		
		//연습
		//순위가 1이면 "금메달", 순위가 2이면 "은메달", 순위가 3이면 "동메달"
		//나머지 순위는 "없음"
		int rank = 1;
		String medal = (rank == 1) ? "금메달" : (rank ==2) ? "은메달" : (rank == 3) ? "동메달" : "없음";
		System.out.println(medal);
				
		//연습
		//홀수는 "홀수", 짝수는 "짝수"
		//힌트
		//홀수 - 2로 나눈 나머지가 1인 수
		//짝수 - 2로 나눈 나머지가 0인 수
		int n3 = 1;
		String type1 = (n3 % 2 ==1) ? "홀수" : "짝수";
		System.out.println(type1);
				
		// 연습
		// 홀수는 "홀수", 짝수는 "짝수", 3의 배수는 "3의 배수"
		//힌트
		//3으로 나눈 나머지가 0인 수 (단, 0은 고려하지 않는다.)
		int a2 =3;
		String type2 = (a2 % 3 == 0) ? "3의 배수" : (a2 % 2 ==1)? "홀수" : "짝수";
		System.out.println(type2);
				
		//연습
		//주민등록번호 뒷 7자리 중 첫 번째 숫자가 1,3,5이면 "남자", 2,4,6이면 "여자"
		int serial = 2234567;
		String gender = ((serial / 1000000)% 2 ==1) ? "남자" : "여자";
		System.out.println(gender);
		
		
	
	}
}