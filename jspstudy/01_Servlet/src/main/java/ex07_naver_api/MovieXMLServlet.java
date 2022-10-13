package ex07_naver_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MovieXMLServlet")
public class MovieXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MovieXMLServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 아이디, 시크릿
		String clientId = "8FX9RTss9uUSzKTQbyMP";
		String clientSecret ="dlK13osJsN";
		
		// 요청 파라미터
		request.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		String display = request.getParameter("display");
		
		// 검색어 UTF-8 인코딩
		try {
			query = URLEncoder.encode(query, "UTF-8");
		}catch (UnsupportedEncodingException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("검색어 인코딩 실패");// client.html 에러로 전달-jqxhr로전달 - responseText로 꺼내짐
			out.close();
			
		}
		
		// API 접속
		String apiURL = "https://openapi.naver.com/v1/search/movie.xml?query="+ query + "&display=" + display;
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
		}catch(MalformedURLException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API URL이 잘 못 되었습니다");
			out.close();
			
		}catch(IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 연결이 실패하였습니다");
			out.close();
		}
		
		// API 요청
		try {
			// 요청 메소드
			con.setRequestMethod("GET");
			// 요청 헤더
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		}catch(IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 요청이 실패하였습니다");
			out.close();
		}
		
		// 응답 스트림 생성(정상 스트림, 에러 스트림)
		BufferedReader reader = null;
		try {
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
		}catch(IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println();
			out.close();
		}
		
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		}catch(IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 응답이 실패했습니다");
			out.close();
		}
		
		// client.html로 API 응답 결과 보내기
		response.setContentType("application/xml; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
