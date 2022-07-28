package ex08_access_modifier;

public class User {
	
	//필드는 private이다
	private String id;
	private String password;
	private String email;
	private int point;
	private boolean isVip;
	
	//메소드는 public이다
	//메소드 거의 public이나 나만 알고 싶은 기능을 private으로 둘 수 있다
	
	public String getId() {
		return id;
	}
	public void setId(String pId) {
		id = pId;
	}

	public String getPw() {
		return password;
	}
	public void setPw(String pPw) {
		password = pPw;
	}
	public String getEm() {
		return email;
	}
	public void setEm(String pEm) {
		email = pEm;
	}
	public int getPt() {
		return point;
	}
	public void setPt(int pPt) {
		point = pPt;
		setVip(point >= 10000);
	}
	public boolean getVip() {
		return isVip;
	}
	//public void setVp(boolean pVip) {
	//	isVip = pVip;
	
	private void setVip(boolean pVip) {
		isVip = pVip;
	}
	

}
