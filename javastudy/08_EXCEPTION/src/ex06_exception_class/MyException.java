package ex06_exception_class;

//사용자가 정의 예외 클래스
//Exceptjop 클래스를 상속받는다.

//Serializable 인터페이스 : 이 인터페이스를 구현하면 직렬화가 가능. serialVersionUID 값을 가져야함(추천)
//↑
//Throwable 클래스 : serialVersionUID 값이 필요함
//↑
//Exception 클래스 : serialVersionUID 값이 필요함
//↑
//MyException 클래스 : serialVersionUID 값이 필요함
public class MyException extends Exception{

	private static final long serialVersionUID = -7774118171104436322L;
	
	
	private int errorCode;


	public MyException(String message, int errorCode) {
		super(message); // 슈퍼클래스에 message 저장되고 myex~은 int 값만 가짐
		this.errorCode = errorCode;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	


}
