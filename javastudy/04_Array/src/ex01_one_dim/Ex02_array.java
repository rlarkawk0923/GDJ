package ex01_one_dim;

public class Ex02_array {
	
	public static void main(String[] args) {
		
		// 배열의 초기화 (길이 명시 안함)
		//int[] arr = new int[] {10, 20, 30, 40, 50};
		int[] arr = {10, 20, 30, 40, 50};
		
		// 최대/최소
		int max = arr[0];
		int min = arr[0];//첫번째 요소 초기값으로
		
		for(int i = 1
				; i <arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
			if(min >arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);
		
		
		
		
	}

}
