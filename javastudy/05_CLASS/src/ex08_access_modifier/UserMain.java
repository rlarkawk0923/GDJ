package ex08_access_modifier;

public class UserMain {

	public static void main(String[] args) {
		
		//System.out.println(user.id); //private으로 불허 메소드를 통해 확인하려고 함
		User user = new User();
		

		
		//user.id = "admin" private으로 불허
		user.setId("admin");
		System.out.println(user.getId());
		
		user.setPw("rla");
		System.out.println(user.getPw());
		
		user.setEm("giwon0923@naver.com");
		System.out.println(user.getEm());
		
		user.setPt(10000);
		System.out.println(user.getPt());
		
		//user.setVip(false); // vip 여부를 포인트에 따라 출력함
		System.out.println(user.getVip());
	}

}
