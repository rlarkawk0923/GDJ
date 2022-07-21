package ex01_random;

public class Ex01 {

	public static void main(String[] args) {


		//난수(Random number) 발생
		//Random 클래스, Math 클래스를 주로 활용한다.
		
		System.out.println(Math.random());
		//클래스.메소드
		
		// 0.0<=Math.random()<1.0
		// 0% <=Math.random()<100%
		
		//확률 처리하기
		// 10% 확률로 "대박", 90% 확률로 "쪽박"
		if(Math.random()<0.1) {
			System.out.println("대박");
		}else {
			System.out.println("쪽박");
		}
		
		//2. 난수 값 생성
		//Math.random()           0.0<=n<1.0
		//Math.ramdom()*5	      0.0<=n<5.0
		//(int)(Math.random()*5)    0<=n<5
		
		for(int n = 0; n < 2; n++) {
			int dice = (int)(Math.random() * 6) + 1;
		System.out.println("주사위"+ dice);
		}
		
		// 연습
		// 6자리 숫자 인증번호 만들기
		// String code = "501924"
		String code = "";
		for(int n =0; n<6;n++) {
			code +=(int)(Math.random()*10);
		}
		System.out.println(code);
		
		System.out.println((char)((int)(Math.random() * 26) + 65));
		
		//연습
		//6자리 영문(대문자 + 소문자) 인증번호 만들기
		code = "";
		for(int n = 0; n<6; n++) {
			if(Math.random()<0.5) {
				code += (char)((int)(Math.random() * 26)+'A');
	
			} else { code +=(char)((int)(Math.random() * 26)+'a');
		}
	}
		System.out.println(code);
		
		
		
		
		
		
		
		
		
		
		

	}
}
