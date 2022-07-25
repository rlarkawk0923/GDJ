package ex02_datetime;

import java.util.Calendar;

public class Ex04_Calendar {

	public static void main(String[] args) {
		
		//java.util.Calendar 클래스
		//현재 날짜 또는 특정 날짜를 나타낼 때 사용
		//날짜의 특정 요소(년, 월, 일, 시, 분, 초....)
		
		Calendar cal = Calendar.getInstance();//객체 caldms 실행하는 순간의 날짜
		//클래스 타입의 객체(object)(변수 역할)
		
		//년, 월, 일
		int year = cal.get(Calendar.YEAR);//Calendar 상수의 year 값을 가져옴. int year = cal.get(1);
		int month = cal.get(Calendar.MONTH) + 1;//반환되는 값이 '0'~11 (주의 필요)
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int weekNo = cal.get(Calendar.DAY_OF_WEEK); //요일번호 일(1) 월(2)...토(7)
		switch(weekNo) {
		case 1 : System.out.println("일요일");break;
		case 2 : System.out.println("월요일");break;
		case 3 : System.out.println("화요일");break;
		case 4 : System.out.println("수요일");break;
		case 5 : System.out.println("목요일");break;
		case 6 : System.out.println("금요일");break;
		default : System.out.println("토요일");
		}
		
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(weekNo);
		//객체가 가지고 있는 기능 = 메소드(클래스 사용하지 않는 언어는 함수라고 부름)
		
		
		//시, 분, 초
		int ampm = cal.get(Calendar.AM_PM); // 오전은(0), 오후(1)
		int hour12 = cal.get(Calendar.HOUR); //시(1~12)
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 시(0~24)
		int minute = cal.get(Calendar.MINUTE);// 분(0~59)
		int second = cal.get(Calendar.SECOND);// 초(0~59)
		
		switch(ampm) {
		case 0 : System.out.println("오전");break;
		case 1 : System.out.println("오후");break;
		}
		System.out.println(hour12);
		System.out.println(hour24);	
		System.out.println(minute);
		System.out.println(second);
		
		//timestamp
		long timestamp = cal.getTimeInMillis();
		System.out.println(timestamp);
	

	}

}
