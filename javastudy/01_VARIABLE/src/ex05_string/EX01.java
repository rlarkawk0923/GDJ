package ex05_string;

public class EX01 {

	public static void main(String[] args) {
		// 문자열 연결 연산자
		// 문자열이 포함된 + 연산은 연결
		
		String str1 = "구디" + "아카데미";
		String str2 = 100 + "번지";
		String str3 = 1 + 1 + "행사";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		// + 연산을 이용한 문자열 만들기
		// 빈 문자열("")을 + 해 줌
		String str4 = 100 + ""; // String.valueOf(100)과 동일.
		System.out.println(str4);
		
		
		//연습. 파일이름을 파일명과 확장자로 분리하시오
		//단, jpg, git, png 이미지인 경우에만 작업을 진행한다
		String fullName = "apple.jpg";
		String fileName = "";// apple
		String extName = ""; // jpg
		int idxOfDot = fullName.lastIndexOf(".");
		fileName = fullName.substring(0,idxOfDot);
		extName = fullName.substring(idxOfDot + 1);
		System.out.println(fileName);
		System.out.println(extName);

		
		
		//연습 문자열 "abcdefghij" 에서
		//아라비아 숫자 1234567890을 제외하고 한 글자씩 화면에 출력하시오.
		String str = "abc12345def67890ghijk";
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >='0' && ch<='9') {
				continue;
			}
			System.out.println(ch);
		}
		//=for(int i = 0; i <= str.length() - 1; i++) {
		//	System.out.println(str.charAt(i));
		//}
		
		
		
	}

}
