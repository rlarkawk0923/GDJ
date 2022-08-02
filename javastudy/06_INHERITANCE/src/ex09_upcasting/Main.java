package ex09_upcasting;

public class Main {

	public static void main(String[] args) {
		
		//Up casting
		//슈퍼클래스 객체 = new 서브클래스();
		Person alba = new Alba();
		alba.eat();
		alba.study(); //호출은 Person의 study()이지만, 실제 실행은 new Alba()를 보고 Alba의 study호출
		alba.work(); //호출은 Person의 work()이지만, 실제 실행은 new Alba()를 보고 Alba의 work호출
		
	
	
	//new student()와 newStudent()와 new alba 모두
	
	//Person 타입으로 처리할 수있다
	
	//한 교실에 Student와 알바가 섞여있다.
	//어떻게 처리할 것인가?
	// Person 타입의 배열을 이용해서 모두 처리할 수 있다.
	
	Person[] people = new Person[10];
	
	people[0] = new Alba();
	people[1] = new Alba();
	people[2] = new Student();
	
	for(int i =0; i < people.length; i++) {
		if(people[i] !=null) {
		people[i].eat();
		people[i].study();
		people[i].work();
	}
	}
	
	
	for(Person person : people) {
		if(person != null) {
			person.eat();
			person.study();
			person.work();
			}
		}
	}
}