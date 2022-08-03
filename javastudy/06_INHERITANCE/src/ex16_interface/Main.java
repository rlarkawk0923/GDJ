package ex16_interface;

public class Main {

	public static void main(String[] args) {
		
		Dog dog = new Dog("백구");
		Cat cat = new Cat("냥냥이");
		Snake snake = new Snake("낼름이");
		
		Person person = new Person();
		person.foodFeed(dog, "개껌");
		person.foodFeed(cat, "츄르");
		person.foodFeed(snake, "쥐");
		
		person.walk(dog); // 백구와 산책
		person.walk(cat); // 냥냥이와 산책
		//person.walk(snake); // 실행을 못하게 막고싶다.

	}

}
