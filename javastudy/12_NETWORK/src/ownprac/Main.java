package ownprac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Main {
	
	public static void m1() {
		

	
	//해양 경찰청 출장소 위치
	
	//API 주소 
	
	String serviceKey = "F+1ab/xcA+zyQUwi4kREKGJgPsP/oKt0u1lIkX01IMTq/lDrDNwbIYSpjOFhIl4VjwurwJepgJGOo6eJeH9eaA==";
	
	StringBuilder urlBuilder = new StringBuilder();
	
	try {
		
		urlBuilder.append("http://apis.data.go.kr/1532000/KCG_Station_Branch_Position/list3");
		urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
		urlBuilder.append("&startPage=1");
		urlBuilder.append("&rowsCount=235");
	}catch(UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	
	String apiURL = urlBuilder.toString();
	
	URL url = null;
	HttpURLConnection con = null;
	
	try {
		
		url = new URL(apiURL);
		con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/xml, charset=UTF-8");
	}catch(MalformedURLException e) {
		System.out.println("API 주소 오류");
	}catch(IOException e) {
		System.out.println("API 접속 실패");
	}
	
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
		reader.close();
	}catch(IOException e) {
		System.out.println("API 응답 실패");
	}
	String response = sb.toString();
	
	File file = new File("C:\\storage", "prac_api.xml");
	try {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(response);
		bw.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		
		m1();

	}

}
