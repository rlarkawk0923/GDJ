package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	
	private Scanner sc;
	//private Book[] books;
	private List<Book> books;
	//private int idx;
	//어느 인덱스에 저장되었는지 관리할 필요가 없어짐
	
	public Library() { //
		sc = new Scanner(System.in);
		books = new ArrayList<Book>();
	}
	private void addBook() {
		//배열 사라짐 풀체크 필요없음
		
		System.out.println("===책등록===");
		
		System.out.println("책 번호 입력 >>> ");
		int bookNo =sc.nextInt();
		System.out.print("제목 입력 >>> ");
		String title = sc.next();
		System.out.print("저자 입력 >>> ");
		String author = sc.next();
		Book book = new Book(bookNo, title, author); // 롬복 @allargsconstructor에 포함됨 모든요소 생성
		books.add(book);
		//books[idx++] = book;
	}
	private void removeBookByIndex() {
		// Book remove(int index) 메소드 이용
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다."); //예외처리
			return;
		}
		
		//(idx == 0) {
		//	System.out.println("등록된 책이 한 권도 없습니다.");
		//	return;
		//}
		
		System.out.println("===책삭제===");
		System.out.print("삭제할 책의 번호 >>> ");
		int bookNo = sc.nextInt();
		for(int i = 0 , length = books.size(); i<length; i++) {
			if(books.get(i).getBookNo()==bookNo);
			Book removeBook = books.remove(i);
		//for(int i =0; i < idx; i++) {
			//if(books[i].getBookNo() == bookNo) {
				//System.arraycopy(books,i + 1, books, i, idx - i - 1);
				//books[--idx] = null;
			
				//System.out.println("책 번호가 " + bookNo + "인 책을 삭제했습니다.");
			System.out.println(removeBook + " 책을 삭제했습니다.");
				return; //break 도 가능
			}
		
			//System.out.println("책 번호가 " + bookNo + "인 책은 없습니다.");
		throw new RuntimeException("책 번호가 " + bookNo + "인 책은 없습니다.");
		}
}
	
	private void removeBookByObject() {
		//boolean remove(Object obj)
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
			
		//if(idx == 0) {
			//System.out.println("등록된 책이 한 권도 없습니다.");
			//return;
		}
		private void findBook() {
			if(book.isEmpty()) {
				throw new RuntimeException("등록된 책이 한 권도 없습니다.")
			}
		System.out.println("===책조회===");
		System.out.print("조회할 책 제목 입력 >>> ");
		String title = sc.next();
		for(int i = 0; length= books.size(); i<length; i++ ) {
			//저장된 책 제목 : books[i].getTitle
			//조회할 책 제목 : title(private으로숨겨져있어서 getter 필요함)
			//String의 동등비교 : equals()메소드
			if(books[i].getTitle().equals(title)) { //if(title.equals(books[i].getTitle())도 가능
				System.out.print(books[i]);
				return; // findBook()메소드 종료 break는 for문만 끝내고 제목이~~출력함
			}
			
		}
		System.out.println("제목이 " + title + "인 책은 없습니다.");//for 문이 끝난 상황, 
	}
	
	
	
	private void printAllBooks() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		
		System.out.println("===전체조회===");
		for(int i=0; i < idx; i++) {
			System.out.println(books[i]);
		}
	}
	
	public void manage() {
		while(true) {
			System.out.print("1. 추가 2.삭제 3. 조회 4. 전체목록 0. 프로그램 종료");
			int choice = sc.nextInt();
			sc.nextLine(); //받기만 하고 출력은 안함 불필요한 엔터 버림
			switch(choice) {
			case 1 : addBook(); break;
			case 2 : removeBook(); break;
			case 3 : modifyBook(); break;
			case 4 : findBook(); break;
			case 5 : printAllBooks(); break;
			case 0 : System.out.println("Library 프로그램을 종료합니다. 감사합니다.");
					 return; // 메소드의 끝을 의미함 manage() 메소드 종료
			default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요.");
			
			}
			
			}
		
	}
}
