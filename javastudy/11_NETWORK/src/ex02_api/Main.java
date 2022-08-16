package ex02_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class Main {
	
	//요청
	//1. Request
	//2. 클라이언트 -> 서버
	
	//파라미터
	//1. Parameter
	//2, 보내는 데이터(변수개념)
	
	
public static void m1() {
	
	//요청(어떤 데이터를 (처리)달라고 요청하는것)
		//클라이언트가 서버측으로 보내는 것 다 요청
		
		//요청할 주소: apiURL
		//요청 파라미터(서버로 보내줄 데이터)
		//필수/선택
		//apiURL?파라미터=값&파라미터=값...
		//api 문서보고 만들어낼 줄 알아야함
		
	//전국종량제 봉투가격 표준데이터
	
	//API주소
	String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
	
	try {
		String serviceKey = "F+1ab/xcA+zyQUwi4kREKGJgPsP/oKt0u1lIkX01IMTq/lDrDNwbIYSpjOFhIl4VjwurwJepgJGOo6eJeH9eaA==";
		apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
		apiURL += "%numOfRows=" + URLEncoder.encode("100", "UTF-8");
		apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
		apiURL += "&CTPRVN_NM"+ URLEncoder.encode("인천광역시","UTF-8");
		apiURL += "&SIGNGU_NM" + URLEncoder.encode("계양구","UTF-8");
		apiURL += "&WEIGHTED_ENVLP_TYPE" + URLEncoder.encode("규격봉투","UTF-8");
		apiURL += "&WEIGHTED_ENVLP_MTHD" + URLEncoder.encode("소각용","UTF-8");
		apiURL += "&WEIGHTED_ENVLP_PRPOS" + URLEncoder.encode("생활쓰레기","UTF-8");
		apiURL += "&WEIGHTED_ENVLP_TRGET" + URLEncoder.encode("기타","UTF-8");
		apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey , "UTF-8");
		//apiURL += "&PRICE_1" + URLEncoder.encode("0","UTF-8");
		//apiURL += "&PRICE_1_HALF" + URLEncoder.encode("0","UTF-8");
		//apiURL += "&PRICE_2" + URLEncoder.encode("0","UTF-8");
		//apiURL += "&PRICE_2_HALF" + URLEncoder.encode("0","UTF-8");
		//apiURL += "&PRICE_3" + URLEncoder.encode("0","UTF-8");
		//apiURL += "&PRICE_5" + URLEncoder.encode("160","UTF-8");
		//apiURL += "&PRICE_10" + URLEncoder.encode("310","UTF-8");
		/*apiURL += "&PRICE_20" + URLEncoder.encode("0","UTF-8");
		apiURL += "&PRICE_30" + URLEncoder.encode("0","UTF-8");
		apiURL += "&PRICE_50" + URLEncoder.encode("0","UTF-8");
		apiURL += "&PRICE_60" + URLEncoder.encode("0","UTF-8");
		apiURL += "&PRICE_75" + URLEncoder.encode("0","UTF-8");
		apiURL += "&PRICE_100" + URLEncoder.encode("3060","UTF-8");
		apiURL += "&PRICE_120" + URLEncoder.encode("0","UTF-8");
		*///apiURL += "&PRICE_125" + URLEncoder.encode("0","UTF-8");
		//apiURL += "&CHRG_DEPT_NM" + URLEncoder.encode("청결지도팀","UTF-8");
		//apiURL += "&PHONE_NUMBER" + URLEncoder.encode("032-450-5464","UTF-8");
		//apiURL += "&REFERENCE_DATE" + URLEncoder.encode("2022-01-01","UTF-8");
		//apiURL += "&instt_code" + URLEncoder.encode("B551295","UTF-8");
	
	
		}catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
	
	//API주소 접속
	URL url = null;
	HttpURLConnection con = null;
	
	try {
		
		url = new URL(apiURL);
		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type","application/xml; charset=UTF-8");
		
	}catch(MalformedURLException e) {
		System.out.println("API 주소 오류");
	}catch(IOException e) {
		System.out.println("API 주소 접속 실패");
	}
	
	//입력 스트림(응답)
	// 1. Response
	// 2. 서버-> 클라이언트
	
	//응답 생성
	// 1. 응답 성공시 정상 스트림, 실패 시 에러 스트림 사용
	// 2. 응답 데이터는 StringBuilder에 저장
	
	BufferedReader reader = null;
	StringBuilder sb = new StringBuilder();
	
	try {
		if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
		}else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		String line = null;
		while((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		//스트림 종료
		reader.close();
			
		
	}catch(IOException e) {
		System.out.println("API 응답 실패");
	}
	
	String response = sb.toString();
	System.out.println(response);
	
	//접속 종료
	con.disconnect();
	
}

	
	public static void main(String[] args) {
		m1();

	}

}