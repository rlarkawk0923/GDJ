package ex16_interface;

public class Person {
	
	public void foodFeed(Pet pet, String food) {
		System.out.println(pet.getPetName() + "에게" + food + "주기");
	}
	
	public void walk(Walkable pet) {
		System.out.println(((Pet)pet).getPetName() + "와 산책"); // 캐스팅 필요한지 생각해보고 구현하기
		
	}

}
