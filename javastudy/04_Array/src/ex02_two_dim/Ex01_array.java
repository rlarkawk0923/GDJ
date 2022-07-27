package ex02_two_dim;

public class Ex01_array {

	public static void main(String[] args) {
		
		
		// 2차원 배열
		// 1. 1차원 배열을 여러 개 관리하는 자료 구조
		// 2. 1차원 배열들의 길이는 서로 다를 수 있음
		// 좌석 예약 프로그램에 사용
		
		
		// 2차원 배열의 선언 및 생성
		// 1. 2차원 배열의 선언
		// 	  int[][] arr;
		// 2. 2차원 배열의 생성
		//	  1) arr = new int[3][2]; - 3행 2열의 구조(김밥 3줄, 각 2개씩 조각)
		//	  2) arr = new int[3][]; - 3행 n열의 구조(모두 다르게 조각낼것이다)(생성 완료되지않음 추가필요)
		//		 arr[0] = new int[5]; - 1번째 1차원 배열(1번째 김밥은 5개 조각)
		//		 arr[1] = new int[3]; - 2번째 1차원 배열(2번째 김밥은 3개 조각)
		//		 arr[2] = new int[8]; - 3번째 1차원 배열(3번째 김밥은 8개 조각)
		
		// 2차원 배열의 요소
		//	1. 인덱스를 2개 사용
		//	몇번째 1차원 배열인가? 해당 배열의 몇 번째 요소인가?
		// 2. 2차원 배열이 관리하는 1차원 배열
		// arr[0]
		// arr[1]
		// arr[2]
		// 3. 각각의 1차원 배열이 관리하는 배열 요소
		// arr[0][0], arr[0][1]
		// arr[1][0], arr[1][1]
		// arr[2][0], arr[2][1]
		
		// 3행 2열 2차원 배열
		int[][] arr1 = new int [3][2];
		
		for(int i = 0; i<arr1.length;i++) { //몇 번째 1차원 배열인가?
			for(int j = 0; j<arr1[i].length; j++) {//j: 1차원 배열의 몇 번째 요소인가?
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		
		//3행 n열 2차원 배열
		int[][] arr2 = new int [3][];
		arr2[0] = new int[5];
		arr2[1]	= new int[4];
		arr2[2]	= new int[8];
		
		for(int i = 0; i<arr2.length;i++) {
			for(int j = 0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}

	}

}
