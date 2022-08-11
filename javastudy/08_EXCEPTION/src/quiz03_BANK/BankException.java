package quiz03_BANK;

//마이너스 입금 불가, 코드값 1000
//마이너스 출금 불가, 코드값 2000
//잔액보다 큰 출금 불가, 코드값 2001

//deposit() throws BankException
//wirhdrawl() throws BankException
//transfer() throws BankException

//addEmployee : FULL ,1
//Regular/Temporary?
//dropEmployee : EMPTY,2
//empNo가 일치하면 삭제
//findEmployee : EMPTY,2
//empNo를 입력받아 검색
//printAllEmployees : EMPTY,2

public class BankException extends Exception {

	private static final long serialVersionUID = 8819765859200147820L;
	private int errorCode;
	
	public BankException(String message, int errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	

}
