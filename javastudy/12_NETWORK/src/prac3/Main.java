package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

//Divide and Conquer

public class Main {

	public static void main(String[] args) {//throws Runtime~ = unchecked exception이라 추가 할말 맴대로
		
		String key = "0a2f4a2277ffa59146f8144499e00437";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜(yyyymmdd) >>> ");
		String targetDt = sc.next();
		
		try {
			key = URLEncoder.encode(key, "UTF-8");
			targetDt = URLEncoder.encode(targetDt, "UTF-8");
		}catch(UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		}
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key="+ key + "&targetDt="+ targetDt;
		
		String response = getResponse(apiURL); // 주소받아서 신청하는 애
		createFile(response);
		
	}
	
	public static String getResponse(String apiURL) { //private 상관무
		
		HttpURLConnection con = getConnection(apiURL); // connection만 받는 메소드 openconnection에서 전달받음 - con으로 전달
		try {
			
		if(con.getResponseCode()==HttpURLConnection.HTTP_OK) {
			return readBody(con.getInputStream());//readbody~메소드가 String 반환(String으로 구현)
		}else {
			return readBody(con.getErrorStream());//inputstream으로 받음
		}
		}catch(IOException e) {
			throw new RuntimeException("API 요청 오류", e);
		}
	}
	
	public static HttpURLConnection getConnection(String apiURL) {
		
		try {
			URL url = new URL(apiURL);
			return(HttpURLConnection)url.openConnection();// getconnection으로 전달
		
	}catch(MalformedURLException e) {
		throw new RuntimeException("API 주소 오류", e);
	}catch(IOException e) {
		throw new RuntimeException("API 연결 오류", e); //if작성
	}
	}
	public static String readBody(InputStream in) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder(); //모든 데이터는 sb에 있음
			String line = null;
			while((line = br. readLine())!= null) {
				sb.append(line);
			}
			return sb.toString();
		}catch(IOException e) {
			throw new RuntimeException("API 응답오류", e);
		}
	}
	
	public static void createFile(String response) { // content response 둘다 상관없음
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\storage\\boxoffice.xml"))){
			bw.write(response);
			bw.flush(); //Stream에 남아있는거 보냄
		}catch(IOException e) {
			throw new RuntimeException("파일 생성 오류", e);
		}
	}
}
