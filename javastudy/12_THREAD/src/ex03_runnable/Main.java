package ex03_runnable;

public class Main {

	public static void main(String[] args) {
		
		// Runnable 인터페이스를 구현한 클래스는 Thread 로 바꿔야 start() 메소드를 호출 할 수 있다.
		// start 대신 Thread 생성하여 
		
		Runnable robot1 = new WashRobot("로봇1");
		WashRobot robot2 = new WashRobot("로봇2");
		
		Thread thread1 = new Thread(robot1);
		Thread thread2 = new Thread(robot2);
		
		Thread thread3 = new Thread(new WashRobot( "로봇3"));
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		//A a = new A();
		//B b = new B(a);
		//B b = new B(new A());

	}

}
