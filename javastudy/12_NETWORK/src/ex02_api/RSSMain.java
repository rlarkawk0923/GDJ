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
import org.w3c.dom.NodeList;

public class RSSMain {
	
	public static void m1() {
	
		String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";
		
		URL url = null;
		HttpURLConnection con = null;
		try {	
				url = new URL(apiURL);
				con = (HttpURLConnection)url.openConnection();
		} catch(MalformedURLException e) {
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
				reader = new BufferedReader( new InputStreamReader(con.getErrorStream()));
			}
			
		String line = null;
		while((line = reader.readLine())!= null) {
			sb.append(line + "\n");
		}
		
		reader.close();
		
		}catch(Exception e) {
			System.out.println("API 응답 실패");
		}
		String response = sb.toString();
	
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
