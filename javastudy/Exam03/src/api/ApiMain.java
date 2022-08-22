package api;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ApiMain {

	public static void m1() {

		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath";
		String serviceKey = "F+1ab/xcA+zyQUwi4kREKGJgPsP/oKt0u1lIkX01IMTq/lDrDNwbIYSpjOFhIl4VjwurwJepgJGOo6eJeH9eaA==";

		try {
			apiURL += "?ServiceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			apiURL += "&searchYear=" + URLEncoder.encode("2021", "UTF-8");
			apiURL += "&siDo=" + URLEncoder.encode("서울특별시", "UTF-8");
			apiURL += "&guGun=" + URLEncoder.encode("금천구", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("json", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100", "UTF-8");
			apiURL += "&pageNo=" + URLEncoder.encode("1", "UTF-8");

		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}

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

		System.out.println(apiURL);

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

			reader.close();

		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}

		String response = sb.toString();

		File file = new File("accident.txt");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		con.disconnect();
	}

	public static void m2() {

		File file = new File("accident.txt");

		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject obj = new JSONObject(sb.toString());
		JSONObject header = obj.getJSONObject("header");
		JSONArray columns = header.getJSONArray("columns");
		for (int i = 0; i < columns.length(); i++) {

		}

		JSONObject body = obj.getJSONObject("body");
		JSONArray items = body.getJSONArray("items");
		JSONObject item = items.getJSONObject(0);

		String[] p = { "occrrncDt", "occrrncDayCd", "dthDnvCnt", "injpsnCnt" };

		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < columns.length(); i++) {
			map.put(columns.getString(i), item.get(p[i]));//

		}

		System.out.println(map);
	}

	public static void m3() {

		File file = new File("accident.txt");
		List<Accident> accidents = new ArrayList<>();

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);

			NodeList accidentList = doc.getElementsByTagName("Accidents");

			for (int i = 0; i < accidentList.getLength(); i++) {

				Element accident = (Element) accidentList.item(i);

				String occrrncDt = accident.getElementsByTagName("occrrncDt").item(0).getTextContent();
				String occrrncDayCd = accident.getElementsByTagName("occrrncDayCd").item(0).getTextContent();
				int dthDnvCnt = accident.getElementsByTagName("dthDnvCnt").item(0).getNodeType();
				int injpsnCnt = accident.getElementsByTagName("injpsnCnt").item(0).getNodeType();

				Accident accident1 = Accident.builder()
						.occrrncDt(occrrncDt)
						.occrrncDayCd(occrrncDayCd)
						.dthDnvCnt(dthDnvCnt)
						.injpsnCnt(injpsnCnt)
						.build();

				accidents.add(accident1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Accident accident1 : accidents) {
			System.out.println(accident1);
		}

	}

	public static void main(String[] args) {

		m1();
	}

}
