package ex02_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class Main2_JSON {
	
	//JSON
	//light weight : XML에 비해 경량 데이터
	//모든 프로그램에서 이용할 수 있는 형식
	//직관적 파싱 가능
	//XML

	public static void m1() {

		// API주소
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		String serviceKey = "F+1ab/xcA+zyQUwi4kREKGJgPsP/oKt0u1lIkX01IMTq/lDrDNwbIYSpjOFhIl4VjwurwJepgJGOo6eJeH9eaA==";

		try {

			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("json", "UTF-8");
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
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 주소 접속 실패");
		}

		// 입력 스트림 (응답) 생성
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
				sb.append(line);//
			}
			// 스트림 종료
			reader.close();

		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}

		// API로부터 전달받은 json 데이터
		String response = sb.toString();

		// JSON File 생성
		File file = new File("C:\\storage", "api1.json");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 접속 종료
		con.disconnect();

	}

	public static void m2() {
		
		//JSONObject 클래스 : {  }, 객체를 의미 "{" -> "}" 하나의 오브젝트
		//JSONArray 클래스 : [  ], 배열을 의미
		
		File file = new File("C:\\storage", "api1.json");
		
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line = null;
			while((line = br.readLine())!= null) {
				sb.append(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		JSONObject obj = new JSONObject(sb.toString());// api1.json을 읽어서 Stringbuilder에 보관 전체 오브젝트(obj)를 읽음
		JSONObject obj2 =  obj.getJSONObject("response");
		JSONObject obj3 = obj2.getJSONObject("header");
		String resultCode = obj3.getString("resultCode");
		String resultMsg = obj3.getString("resultMsg");
		
		System.out.println(resultCode + ", " + resultMsg);
		
		/*{"프로퍼티" : 값}
		  {"property : value}
		{
		  "response":{                       obj2~ 프로퍼티 1개
				"header":{                   obj3~ 프로퍼티 2개
				"resultCode":"03",
				"resultMsg":"NODATA_ERROR"
			}                                ~obj3
		 }  (getJSONObject("response"))      ~obj2
		}*/
		
		// {key : value} //라이브러리 맵 에서 사용하는 용어
	}

	public static String m3() { //반환타입 스트링으로 바꿈
		
		String serviceKey = "F+1ab/xcA+zyQUwi4kREKGJgPsP/oKt0u1lIkX01IMTq/lDrDNwbIYSpjOFhIl4VjwurwJepgJGOo6eJeH9eaA==";

		StringBuilder urlBuilder = new StringBuilder();

		try {
			urlBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&dataType=JSON");
			urlBuilder.append("&base_date=20220819");
			urlBuilder.append("&base_time=0600");
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
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
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
				sb.append(line);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		String response = sb.toString();

		File file = new File("C:\\storage", "api2.json");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
	
	public static void m4() {
		
		JSONObject obj = new JSONObject(m3()); // 프로퍼티 1개
		JSONObject response = obj.getJSONObject("response"); 
		JSONObject body = response.getJSONObject("body"); //원하는 데이터 body에 있어서 header(x)
		JSONObject items = body.getJSONObject("items");
		JSONArray item = items.getJSONArray("item");
		for(int i= 0; i<item.length(); i++) {
			JSONObject element = item.getJSONObject(i); // 배열요소 하나하나가 element
			System.out.println(element.getString("category") + " : " + element.getString("obsrValue"));//element 에서 카테고리 값 가져오기
		}
		
	}
	
	public static String m5() {
		
		String serviceKey = "F+1ab/xcA+zyQUwi4kREKGJgPsP/oKt0u1lIkX01IMTq/lDrDNwbIYSpjOFhIl4VjwurwJepgJGOo6eJeH9eaA==";

		StringBuilder urlBuilder = new StringBuilder();

		try {
			urlBuilder.append("http://apis.data.go.kr/B553077/api/open/sdsc2/storeZoneOne");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&key=9940");
			urlBuilder.append("&type=json");
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
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
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
				sb.append(line);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		String response = sb.toString();

		File file = new File("C:\\storage", "api3.json");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
	
	public static void m6() {
		
		
		JSONObject obj = new JSONObject(m5());
		JSONObject header = obj.getJSONObject("header");
		JSONArray columns = header.getJSONArray("columns");
		for(int i = 0; i < columns.length(); i++) {
				
		}
		
		JSONObject body = obj.getJSONObject("body");
		JSONArray items = body.getJSONArray("items");
		JSONObject item = items.getJSONObject(0);
		
		String[] p = {"trarNo", "mainTrarNm", "ctprvnCd", "ctprvnNm", "signguCd", "signguNm", "trarArea", "coordNum", "coords" , "stdrDt"};
		
		Map<String, Object> map = new HashMap<String, Object>(); // 각 다른 타입의 value들을 Object로 묶기
		for(int i = 0; i < columns.length(); i++) {
			map.put(columns.getString(i), item.get(p[i]));// 9940 추출 데이터 타입이 지정되어있어도 get이 object타입 반환하기때문에 get~할필요없음
			
			
		}
		
		System.out.println(map);
		
	}
	
	public static String m7() {
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
				
				return sb.toString();
	}
	
	public static void m8() {
		
		// XML문서를 
		JSONObject obj = XML.toJSONObject(m7());
		
		JSONArray dataList = obj.getJSONObject("rss")
								.getJSONObject("channel")
								.getJSONObject("item")
								.getJSONObject("description")
								.getJSONObject("body")
								.getJSONArray("data");
		for(int i = 0; i < dataList.length(); i++) {
			JSONObject weather = dataList.getJSONObject(i);
			System.out.println(weather.getInt("hour") + "시 : " + weather.getInt("temp") + "도, " + weather.getString("wfKor"));
		}
	}
	
	public static void main(String[] args) {

		m8();

	}

}
