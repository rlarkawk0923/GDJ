package ex11_downcasting;

public class Main {

	public static void main(String[] args) {
		
		Car[] cars = new Car[10];
		
		for(int i = 0; i < cars.length; i++) {
			if(Math.random()<0.33) {
				cars[i]= new Car();
			}else if(Math.random()<0.66) {
				cars[i] = new EV();
			}else {
				cars[i]= new Hybrid();
			}
		}
		
		/*
		car[0] = new Car();
		car[0] = new Ev();
		car[0] = new Hybrid();
	}*/
		
		for(int i = 0; i<cars.length;i++) {
		 if(cars[i] instanceof Hybrid) { //후손부터 먼저 체크함 car-ev-hybrid 안됨
			((Hybrid)cars[i]).addOil();
		}else if(cars[i] instanceof EV) {
			((EV)cars[i]).charge();
		}else if(cars[i] instanceof Car) {
				cars[i].drive();
			}
			
		}

	}
}