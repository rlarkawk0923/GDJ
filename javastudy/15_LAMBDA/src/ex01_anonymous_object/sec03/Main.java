package ex01_anonymous_object.sec03;

public class Main {
	
	public static void main(String[] args) {
		
		Soil soil = new Soil();
		
		soil.sellOil();
		soil.sellOil();// 자동차가 올때마다 기름팔겠다.차종바꾸는 건아님
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());
		
	}

}
