package ex07_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void printMovies(List<String>list) {
		for(int i =0,size = list.size(); i<size; i++) {
			System.out.print(list.get(i));//영화 하나
			if(i < size -1) { // size -1 : 마지막 요소의 인덱스 //마지막 요소 되기 전까지 화살표 출력해라
			System.out.print("->");
		}
	}
		System.out.println();
	}
	public static void main(String[] args) {
		
		List<String> movies = new ArrayList<String>();
		movies.add("아바타");
		movies.add("쇼생크탈출");
		movies.add("명량");
		movies.add("에일리언");
		movies.add("여인의 향기");
		
		printMovies(movies);//movies = list
		
		// movies 리스트를 오름차순 정렬 시킴
		Collections.sort(movies);
		printMovies(movies);
		
		// movies 리스트를 내림차순 정렬 시킴
		Collections.reverse(movies);
		printMovies(movies);
		
		//특정 요소의 인덱스 반환
		//이진 검색(binary search)을 이용하므로 검색 속도가 매우 빠름
		//단, 크기순으로 정렬이 되어 있어야함
		int idx = Collections.binarySearch(movies, "명량");
		System.out.println(idx);

	}

}
