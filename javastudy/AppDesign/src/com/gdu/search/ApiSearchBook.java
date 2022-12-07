package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {

	public static void main(String[] args) {

		String clientId = "8FX9RTss9uUSzKTQbyMP";
		String clientSecret = "dlK13osJsN";
		Scanner sc = new Scanner(System.in);
		String targetDt = sc.next();
		try {
			targetDt = URLEncoder.encode(targetDt, "UTF-8");

			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + "targetDt=" + targetDt;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			BufferedReader br = null;
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			con.disconnect();

			File dir = new File("C:/download");// 분석한 코드로 파일만들기
			if (dir.exists() == false) {
				dir.mkdirs();
			}
			File file = new File(dir, "targetDt" + ".html");
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>검색결과 : <title>");
			out.println("</head>");
			out.println("<body>");
			JSONObject obj = new JSONObject(sb.toString());

			JSONObject title = obj.getJSONObject("title");
			JSONObject link = obj.getJSONObject("link");
			JSONObject image = obj.getJSONObject("image");
			JSONObject items = link.getJSONObject("items");
			JSONArray item = items.getJSONArray("item");
			for (int i = 0; i < item.length(); i++) {
				JSONObject element = item.getJSONObject(i);
				System.out.println(element.getString("link") + " : " + element.getString(line));
			}

			out.println("</body>");
			out.println("</html>");
			out.close();
			System.out.println("성공");

		} catch (

		Exception e) {
			try {
				File dir = new File("C:/download/log");
				if (dir.exists() == false) {
					dir.mkdirs();

				}
				File file = new File(dir, "파일명");
				PrintWriter out = new PrintWriter(file);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				out.println("예외메시지 : " + e.getMessage());
				out.println("예외발생시간 : " + timestamp);
				out.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
