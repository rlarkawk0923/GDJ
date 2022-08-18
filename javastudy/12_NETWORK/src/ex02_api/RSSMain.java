package ex02_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RSSMain {
	
	public static void m1() {
		

		// 기상청 RSS
		
		// 제주특별자치도 서귀포시 중문동
		String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";
		
		//접속
		URL url = null;
		HttpURLConnection con = null;
		try {	
				url = new URL(apiURL);
				con = (HttpURLConnection)url.openConnection();
		//} catch(MalformedURLException e) {
		//	System.out.println("API 주소 오류");
		}catch(IOException e) {
			System.out.println("API 접속 실패");
		}
		
		//응답 스트림 생성 및 응답 데이터 받기
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {	
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader( new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			while((line = reader.readLine())!= null) {
				sb.append(line + "\n");
		}
		
		//reader.close();
		
		}catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		String response = sb.toString();
		
		// XML 파일 생성
		File file = new File("C:\\storage", "api4.xml");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
			
		}catch(IOException e) {
			System.out.println("파일 생성 실패");
		
		}
	}
	
	public static void m2() {
		
		File file = new File("C:\\storage", "api4.xml");
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			StringBuilder sb = new StringBuilder();
			
			Node title = root.getElementsByTagName("title").item(0);
			sb.append(title.getTextContent()).append("/n");
			
			Node pubDate = root.getElementsByTagName("pubDate").item(0);
			sb.append(pubDate.getTextContent()).append("\n");
			
			NodeList dataList = root.getElementsByTagName("data");
			for(int i = 0; i<dataList.getLength(); i++) {
				Element data = (Element)dataList.item(i);
				Node hour = data.getElementsByTagName("hour").item(0);
				Node temp = data.getElementsByTagName("temp").item(0);
				Node wfKor = data.getElementsByTagName("wfKor").item(0);
				sb.append(hour.getTextContent()).append("시 ");
				sb.append(temp.getTextContent()).append("도 ");
				sb.append(wfKor.getTextContent()).append("\n ");
			}
			
			System.out.println(sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void m3() {
		
		try {
			//접속
			String apiURL = "http://kma.go.kr/XML/weather/sfc_web_map.xml";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			//접속 확인 코드
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("API 접속 실패");
				return;
			}
			
			//바이트 입력 스트림-> 문자입력스트림-> 버퍼 추가
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			File file = new File("C:\\storage","sfc_web_map.xml");
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			//readLine()메소드를 이용한 복사
			String line = null;
			while((line = br.readLine())!= null) {
				bw.write(line + "\n");
			}
			
			//닫기
			bw.close();
			br.close();
			con.disconnect();
			
		}catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		}catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println("API 서버 오류");
		}
			

		}


	public static void m4() {
		
		File file = new File("C:\\storage","sfc_web_map.xml");
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement(); // <current xmlns="current"> 태그
			
			Element weather =  (Element)root.getElementsByTagName("weather").item(0);//<weather year="2022" month="08" day="18" hour="15">
			sb.append(weather.getAttribute("year") + "년");
			sb.append(weather.getAttribute("month") + "월");
			sb.append(weather.getAttribute("day") + "일");
			sb.append(weather.getAttribute("hour") + "시\n");
			
			NodeList locals = root.getElementsByTagName("local");
			for(int i = 0; i < locals.getLength(); i++) {
				Element local = (Element)locals.item(i);
				sb.append(local.getTextContent()+ ":");
				sb.append(local.getAttribute("ta")+ "℃ ");
				sb.append(local.getAttribute("desc")+ "\n");
			
			}
			
			System.out.println(sb.toString());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		m2();
	}

}
