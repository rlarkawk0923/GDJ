package prac3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseMain {

	public static void main(String[] args) {
		
		// 영화 한 편 : Movie 객체
		// 영화 전체  : List<Movie> 리스트
		
		File file = new File("C:\\storage", "boxoffice.xml");
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList boxOfficeList = doc.getElementsByTagName("dailyBoxOffice");
			
			for(int i = 0; i < boxOfficeList.getLength(); i++) {
				
				Element boxOffice = (Element)boxOfficeList.item(i); //boxoffice 태그 1개
				/*NodeList movieCdList = boxOffice.getElementsByTagName("movieCd");
				Node movieCdNode = movieCdList.item(0);
				String movieCd = movieCdNode.getTextContent();
				*/
				String movieCd = boxOffice.getElementsByTagName("movieCd").item(0).getTextContent(); //체이닝으로 적으면 조타
				String movieNm = boxOffice.getElementsByTagName("movieNm").item(0).getTextContent(); //체이닝으로 적으면 조타
				String openDt = boxOffice.getElementsByTagName("openDt").item(0).getTextContent(); //체이닝으로 적으면 조타
				String salesAcc = boxOffice.getElementsByTagName("salesAcc").item(0).getTextContent(); //체이닝으로 적으면 조타
				String audiAcc = boxOffice.getElementsByTagName("audiAcc").item(0).getTextContent(); //체이닝으로 적으면 조타
				
				Movie movie = Movie.builder()
						.movieCd(movieCd)
						.movieNm(movieNm)
						.openDt(openDt)
						.salesAcc(salesAcc)
						.audiAcc(audiAcc)
						.build(); // builder 패턴
				// list<> 만들러가기
						
				movies.add(movie);
				
				
				}//for
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		for(Movie movie : movies) {
			System.out.println(movie);
		}
		
	}
	
}
