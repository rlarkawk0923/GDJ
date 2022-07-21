package practice_only_control;

public class Practice01 {

	public static void main(String[] args) {
		
		//나이에 따른 결과출력
		//0~7   : 미취학 아동
		//8~13  : 초등학생
		//14~16 : 중학생
		//17~19 :고등학생
		//20~   :성인
		
		int age = 10;
		
		if(age < 0 || age >100) {
			System.out.println("잘못 된 나이");
		} else if(age<=7) {
			System.out.println("미취학아동");
		} else if(age<=13) {
			System.out.println("초등학생");
		} else if(age<=16) {
			System.out.println("중학생");
		} else if(age<=19) {
			System.out.println("고등학생");
		} else {
			System.out.println("성인");
		}
		
		//연습
		//월에 따른 계절 출력
		//봄   : 3 ~ 5
		//여름 : 6 ~ 8
		//가을 : 9 ~ 11
		//겨울 : 12,1~2
		
		int month1 = 1;
		if(month1 < 1 || month1 > 12) {
			System.out.println("잘못 된 월");
		} else if( month1 == 12 || month1 <=2) {
			System.out.println("겨울");
		} else if( month1 <= 5 ) {
			System.out.println("봄");
		} else if( month1 <= 8 ) {
			System.out.println("여름");
		} else  {
			System.out.println("가을");
		} 
		
		int mod = month1 % 12;
		if(month1<1 || month1>12) {
			System.out.println("겨울");
		}else if(mod<=5) {
			System.out.println("봄");
		}else if(mod<=8) {
			System.out.println("여름");
		}else {
			System.out.println("가을");
		}
		
		// 연습
		// 점수에 따른 학점
		// score    grade
		// 100 ~ 90 A
		// 89 ~80   B
		// 79~70    C
		// 69~60    D
		// 59~0     F
		
		int score1 = 100;
		char grade1;
		
		if (score1>100 || score1<0) {
			grade1= 'X';
		} else if(score1>=90 ) {
			grade1='A';
		} else if(score1>=80 ) {
			grade1='B';
		} else if(score1>=70) {
			grade1='C';
		} else if(score1>=60) {
			grade1='D';
		} else {
			grade1='F';
		}
		
		System.out.println("점수는 " + score1 + "점");
		System.out.println("학점은 " + grade1+ "학점");
		
		// 연습
		// 오직 일 수만 고려
		//1일이 수요일이다.
		// n일 후 무슨 요일인지 출력하기.
		int day =1;
		int n =1;
		String weekName; //목요일
		
		day += n;
		
		if( day % 7 == 0) {
			weekName = "화";
		} else if(day%7==1) {
			weekName = "수";
		} else if(day%7==2) {
			weekName = "목";
		} else if(day%7==3) {
			weekName = "금";
		} else if(day%7==4) {
			weekName = "토";
		} else if(day%7==5) {
			weekName = "일";
		} else {
			weekName = "월";
		}
		
		System.out.println(weekName + "요일");
	
		//연습
		//각 층별 관리자를  출력
		//1~2층:전지현
		//3~5층:한지민
		//5~6층:박은빈
		//나머지:박보검
				
		int floor = 1;
		String manager;
				
		switch(floor) {
		case 1 : 
		case 2 : manager = "전지현"; break;
		case 3 :
		case 4 : manager = "한지민"; break;
		case 5 :
		case 6 : manager = "박은빈"; break;
		default: manager = "박보검";
		}
				
		System.out.println(floor + "층 관리자는 " + manager + "입니다.");
				
		//연습
		//짝수, 홀수
		int n2 = 2;
		switch(n2 % 2) {
		case 0 : System.out.println("짝수"); break;
		default: System.out.println("홀수");
		}
				
		// 연습
		// 분기 출력하기
		// 1~3월   : 1분기
		// 4~6월   : 2분기
		// 7~9월   : 3분기
		// 10~12월 : 4분기
		int month2 = 7;
		switch((month2-1)/3) {
		case 0:System.out.println("1분기"); break;
		case 1:System.out.println("2분기"); break;
		case 2:System.out.println("3분기"); break;
		case 3:System.out.println("4분기"); break;
				}
				
		//연습
		//점수에 따른 학점
		// score    grade
		// 100 ~ 90 A
		// 89 ~80   B
		// 79~70    C
		// 69~60    D
		// 59~0     F
				
		int score2 = 40;
		String grade2;
				
		switch ( score2 / 10 ) {
		case 10 : 
		case 9 : grade2 ="A"; break;
		case 8 : grade2 ="B"; break;
		case 7 : grade2 ="C"; break;
		case 6 : grade2 ="D"; break;
		default : grade2 ="F";
		}
		System.out.println(score2 + "점은 " + grade2 + "학점입니다.");
				
		// 연습
		// 등급(1,2,3)에 따른 권한 출력
		// 1등급 : 쓰기 실행 읽기
		// 2등급 : 실행 읽기
		// 3등급 : 읽기
		//나머지 : 없음
		int level = 2;
		String right = ""; // 권한
				
		switch(level) {
		case 1 : right += "쓰기";
		case 2 : right += "실행";//break 없으면 문자열 누적됨
		case 3 : right += "읽기"; break;
		default: right += "없음"; 
		}
		System.out.println(right);
	}

}
