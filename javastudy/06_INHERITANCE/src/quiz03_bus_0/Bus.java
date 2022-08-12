package quiz03_bus_0;

public class Bus {
	
	private Seat[] seats; // 배열 선언
	private int limit;
	
	//Bus 생성자에서 배열 생성을 진행함
	public Bus(int cnt) {
		seats = new Seat[cnt];// 배열 생성, new Bus(25)인 경우 Seat가 25개 생성됨
		limit = cnt;
	}
	
	//ride() 메소드
	public void ride(int seatNo, Person person) {
		//존재하지 않는 시트 번호
		if(seatNo <= 0 || seatNo>limit) {
			return; //ride() 메소드 종료
		}
		//시트번호에Person 저장하기
		if(seats[seatNo -1] == null) {
		seats[seatNo - 1].setPerson(person);
	}
	}
	//info 메소드
	public void info() {
		for(int i = 0; i<limit; i++) {//limit은 seats 배열의 length와 같은
			Seat seat =seats[i];
			if(seat != null) { //Seat seat = seats[i]; 없애고 Person
				Person person = seat.getPerson();
				System.out.println((i+1) + "," + person.getName());
			}
		}
	}
}