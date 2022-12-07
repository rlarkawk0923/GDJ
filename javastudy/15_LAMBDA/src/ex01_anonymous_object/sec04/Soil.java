package ex01_anonymous_object.sec04;

public class Soil {
	
	public int totalOil = 1000;
	private int payPerLiter = 2000;
	private int earning;
	
	// 3. 메소드의 매개변수로 익명 객체 저장하기
	public void sellOil(Car car) { // 기름을 팔기위해서 정보를 저장하고
		car.addOil(); // 기름 넣기
	}

	public int getTotalOil() {
		return totalOil;
	}

	public void setTotalOil(int totalOil) {
		this.totalOil = totalOil;
	}

	public int getPayPerLiter() {
		return payPerLiter;
	}

	public void setPayPerLiter(int payPerLiter) {
		this.payPerLiter = payPerLiter;
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}
	
	

}
