package ex03_singleton;

public class Main {

	public static void main(String[] args) {
		
		// singleton 객체는 하나만 생성된다.
		//여러개의 객체가 만들어지면 안될때 사용(new User 생성 오류)
 

		User user1 = User.getInstance();
		System.out.println(user1);
		
		User user2 = User.getInstance();
		System.out.println(user2);
		
		//User user - new User();
		

	}

}
