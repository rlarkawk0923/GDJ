package ex02_two_dim;

public class Ex02_advanced_for {

	public static void main(String[] args) {
		
		String[][] timeTable = {
				{"국어", "윤리", "수학","영어"},
				{"영어","미술","수학"},
				{"체육", "사회","수학","영어"},
				{"사회","국어","한자", "미술","영어"},
				{"과학","국어", "수학", "영어"},
		};
		
		//일반 for 문
		for(int i = 0; i < timeTable.length; i++) {
			for(int j = 0 ; j < timeTable[i].length; j++) {
			System.out.print(timeTable[i][j] + " ");
		}
			System.out.println();
		}
		
		
		// 향상 for문
		for(String[] weekName : timeTable) {
			for(String course : weekName) {
				System.out.print(course + " ");
			}
			System.out.println();
		}
	}

}
