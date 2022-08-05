package quiz04_employee;

public class EmployeeException {
	
	
	private static final long serialVersionUID = -5434434020338266466L;
	private int errorCode;
	
	public EmployeeException(String message, int errorCode) {
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

