package ex05_synchronized;

//Cleaner 1개
// : 공유 자원

//Cleaner 사용할 Robot 2개
// : 스레드

// Robot이 Cleaner를 차지하기 위한 쟁탈전이 벌어짐

//synchronized
// 스레드의 충돌을 방지하기 위해서 한 스레드만 접근할 수 있도록 허용
// 공유자원의 일관성을 보장
// 한 번에 한 스레드만 접근할 수 있는 영역을 임계영역(Critical Section)이라고 함

//Object 클래스의 wait() 메소드
//1. 스레드가 대기상태가 됨
//2. 다른 스레드가 깨울때까지 대기함

//Object 클래스의 notify() 메소드
// 1. 다른 스레드를 깨움
// 2. notifyAll() 메소드로 모든 스레드를 깨움

public class Cleaner {
	
	public synchronized void toiletCleaning() {
		try{
			System.out.println("화장실 청소");
			notify();// "화장실 청소 끝났다"고 알림
			wait();  // 잠깐 쉼
		}catch(InterruptedException e) {// 예외처리 필요
			e.printStackTrace();
		}
	}
	
	
	public synchronized void roomCleaning() {
		try {
			System.out.println("방 청소");
			notify();//"방청소 끝났다"고 알림
			wait(); // 잠깐 쉼
		}catch(InterruptedException e) {// 예외처리 필요
			e.printStackTrace();
	}

	}
}
