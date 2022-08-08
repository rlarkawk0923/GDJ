package quiz01_library;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Book {
	
	private int bookNo; 	// 1~100번까지 자동부여
	private String title;	//사용자입력
	private String author;	//사용자입력
	
	
	public Book(int bookNo, String title, String author) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		
	}


	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", title=" + title + ", author=" + author + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookNo != other.bookNo)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	//Book[] books -> List books
	
	//Library.java
	
	//addBook()-full 체크 없어짐
	//removebook()empty check 필요함(예외처리로 변경)
	//	removebookbyindex()인덱스 정보를 이용해서 제거
	//	removebookbyobject()-객체(book) 정보를 이용해서 제거
	//findbook()-empty check 필요함(예외처리로 변경)
	//printallbooks empty check 필요함
	
	//*추가
	//modifybook - 책 제목을 입력받아서 일치하는 책의 정보를 변경
}
