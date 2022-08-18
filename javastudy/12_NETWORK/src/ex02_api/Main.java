package ex02_api;

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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	// 요청
	// 1. Request
	// 2. 클라이언트 -> 서버

	// 파라미터
	// 1. Parameter
	// 2. 보내는 데이터(변수개념)

	// 응답
	// 1. Response
	// 2. 서버 -> 클라이언트

	public static void m1() {

		// 요청(어떤 데이터를 (처리)달라고 요청하는것)
		// 클라이언트가 서버측으로 보내는 것 다 요청

		// 요청할 주소: apiURL
		// 요청 파라미터(서버로 보내줄 데이터)
		// 필수/선택
		// apiURL?파라미터=값&파라미터=값...
		// api 문서보고 만들어낼 줄 알아야함

		// 전국종량제 봉투가격 표준데이터

		// API주소
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";

		try {
			String serviceKey = "F+1ab/xcA+zyQUwi4kREKGJgPsP/oKt0u1lIkX01IMTq/lDrDNwbIYSpjOFhIl4VjwurwJepgJGOo6eJeH9eaA==";
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("인천광역시", "UTF-8");
			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("계양구", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_PRPOS=" + URLEncoder.encode("생활쓰레기", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8");
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}

		// API주소 접속
		URL url = null;
		HttpURLConnection con = null;

		try {

			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");

		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 주소 접속 실패");
		}

		// 입력 스트림(응답)
		// 1. Response
		// 2. 서버-> 클라이언트

		// 응답 생성
		// 1. 응답 성공시 정상 스트림, 실패 시 에러 스트림 사용
		// 2. 응답 데이터는 StringBuilder에 저장

		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();

		try {
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			// 스트림 종료
			reader.close();

		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}

		// API로부터 전달받은 xml 데이터
		String response = sb.toString();

		// File 생성
		File file = new File("C:\\storage", "api1.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // ---------------------

		// xml 분석
		try {
			// dom : 문서를 객체로 바꾸는
			// <><>:덩어리안에있는거 ELEMENT NODE라고 부름
			//

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);

			Element root = doc.getDocumentElement(); // <response> 최상위노드
			System.out.println(root.getNodeName());

			NodeList nodeList = root.getChildNodes(); // <header>,<body>
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i); // <header>와 <body>
				System.out.println("  " + node.getNodeName());
				NodeList nodeList2 = node.getChildNodes(); // <header>의 자식 태그(), <body>
				for (int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j); //
					System.out.println("    " + node2.getNodeName());
					if (node2.getNodeName().equals("items")) { // <items> 태그 대상
						NodeList items = node2.getChildNodes(); // <items>의 자식 태그(<item>)
						for (int k = 0; k < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("      " + item.getNodeName());
							NodeList itemChildren = item.getChildNodes(); // <item>의 자식 태그
							for (int l = 0; l < itemChildren.getLength(); l++) {
								Node itemChild = itemChildren.item(l);
								System.out.println(
										"        " + itemChild.getNodeName() + ":" + itemChild.getTextContent());

							}
						}
					}
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 접속 종료
		con.disconnect();

	}

	public static void m2() {

		// 보건복지부_코로나 19 감염현황 조회 서비스

		// 인증키(Decoding)
		String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";
		// API 주소 (주소 + 요청 파라미터)
		StringBuilder urlBuilder = new StringBuilder();
		try {
			urlBuilder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&startCreateDt=20220808");
			urlBuilder.append("&endCreateDt=20220812");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String apiURL = urlBuilder.toString();

		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;

		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 실패");
		}

		// 입력 스트림 생성
		// 1. 서버가 보낸 데이터를 읽어야 하므로 입력 스트림이 필요
		// 2. 서버와 연결된 입력 스트림은 바이트 스트림이므로 문자 스트림으로 변환해야 함
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			// 스트림 종료
			reader.close();

		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}

		// API로부터 전달받은 xml 데이터
		String response = sb.toString();

		// XML File 생성
		File file = new File("C:\\storage", "api2.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void m3() {

		// xml 파싱

		File file = new File("C:\\storage", "api2.xml");

		try {

			// api2.xml 문서 -> doc 객체
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);

			// api2.xml 문서의 최상위 태그 -> root
			Element root = doc.getDocumentElement();

			// <item>...</item> 태그 하나 == 특정 날짜의 데이터
			StringBuilder sb = new StringBuilder();

			NodeList items = root.getElementsByTagName("item"); // 태그 이름으로 찾기
			for (int i = 0; i < items.getLength(); i++) {
				Node item = items.item(i);
				NodeList itemChildren = item.getChildNodes();
				Node stateDt = itemChildren.item(4);// 5번째 노드
				for (int j = 0; j < itemChildren.getLength(); j++) {
					Node itemChild = itemChildren.item(j);
					if (itemChild.getNodeName().equals("stateDt")) {// 노드의 이름을 직접 비교해서 데이터 가져오는 방식
						sb.append(" 날짜 : ").append(itemChild.getTextContent());
					} else if (itemChild.getNodeName().equals("decideCnt")) {
						sb.append(" 확진자 수 : ").append(itemChild.getTextContent());
					} else if (itemChild.getNodeName().equals("deathCnt")) {
						sb.append(" 사망자수 : ").append(itemChild.getTextContent());
					}
				}
				sb.append("\n");

				// Node stateDt == <stateDt>20220812</stateDt>
				// stateDt.getNodeName() == stateDt(태그이름)
				// stateDt.getTextContent() == 20220812(태그내부텍스트)

			}
			System.out.println(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void m4() {

		String serviceKey = "F+1ab/xcA+zyQUwi4kREKGJgPsP/oKt0u1lIkX01IMTq/lDrDNwbIYSpjOFhIl4VjwurwJepgJGOo6eJeH9eaA==";

		StringBuilder urlBuilder = new StringBuilder();

		try {
			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&base_date=20220818");
			urlBuilder.append("&base_time=1100");
			urlBuilder.append("&nx=59");
			urlBuilder.append("&ny=124");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String apiURL = urlBuilder.toString();

		URL url = null;
		HttpURLConnection con = null;

		try {

			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 실패");
		}

		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		String response = sb.toString();

		File file = new File("C:\\storage", "api3.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void m5() {

	}

	public static void m6() {
		File file = new File("C:\\storage", "api3.xml");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc= builder.parse(file);
		
			Element root = doc.getDocumentElement();
		
			NodeList items = root.getElementsByTagName("item");
			for(int i = 0; i< items.getLength(); i++) {
			Element item = (Element)items.item(i);//node->element로 다운캐스팅 node에 태그말고 다른것들 많이 포함되어있어서
			//NodeList categories = item.getElementsByTagName("category");
			//Node category = categories.item(0);
			Node category = item.getElementsByTagName("category").item(0);
			Node obsrValue = item.getElementsByTagName("obsrValue").item(0);
			String strCategory = null;
			switch(category.getTextContent()) {
			case "PTY" : strCategory = "강수형태"; break;
			case "REH" : strCategory = "습도"; break;
			case "RN1" : strCategory = "강수량(1시간)"; break;
			case "T1H" : strCategory = "기온"; break;
			case "UUU" : strCategory = "동서바람성분"; break;
			case "VEC" : strCategory = "풍향"; break;
			case "VVV" : strCategory = "남북바람성분"; break;
			case "WSD" : strCategory = "풍속"; break;
			
			}
			
			System.out.println(strCategory+ ":"+obsrValue.getTextContent());
				
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void m7() {
		
	}
		
	
	public static void main(String[] args) {
		m6();

	}

}
