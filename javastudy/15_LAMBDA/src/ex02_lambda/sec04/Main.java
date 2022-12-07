package ex02_lambda.sec04;

public class Main {
	
	public static void main(String[] args) {
		
		Soil soil = new Soil();
		
		/*
		 * soil.sellOil(new Car() {// Car 한번 쓰고 없어지는 객체
		 * 
		 * @Override public void addOil() { int oil = 30; //totalOil -= oil; 필드 바깥이라 안됨
		 * soil.setTotalOil(soil.getTotalOil()-oil); soil.setEarning(soil.getEarning()+
		 * oil * soil.getPayPerLiter()); System.out.println("감사합니다 BMV"); } });
		 */
		soil.sellOil(() -> {// Car 한번 쓰고 없어지는 객체
				int oil = 30;
				soil.setTotalOil(soil.getTotalOil()-oil);
				soil.setEarning(soil.getEarning()+ oil * soil.getPayPerLiter());
				System.out.println("감사합니다 BMV");
		}); 
		
		soil.sellOil(new Car() {// Car 한번 쓰고 없어지는 객체
			@Override
			public void addOil() {
				int oil = 50;
				//totalOil -= oil; 필드 바깥이라 안됨
				soil.setTotalOil(soil.getTotalOil()-oil);
				soil.setEarning(soil.getEarning()+ oil * soil.getPayPerLiter());
				System.out.println("감사합니다 모닝");
			}
		}); 
		soil.sellOil(new Car() {// Car 한번 쓰고 없어지는 객체
			@Override
			public void addOil() {
				int oil = 20;
				//totalOil -= oil; 필드 바깥이라 안됨
				soil.setTotalOil(soil.getTotalOil()-oil);
				soil.setEarning(soil.getEarning()+ oil * soil.getPayPerLiter());
				System.out.println("감사합니다 소나타");
			}
		}); 
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());
		
	}

}
