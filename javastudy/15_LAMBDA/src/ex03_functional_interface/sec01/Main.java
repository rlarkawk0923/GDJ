package ex03_functional_interface.sec01;

public class Main {

	public static void main(String[] args) {

		/*
		 * MyInterface1 myInterface1 = new MyInterface1() {
		 * 
		 * @Override public void method() { System.out.println("집에 준내 가고십다.");
		 * 
		 * } };
		 */

		MyInterface1 myInterface1 = () -> System.out.println("집에 준내 가고십다.");

		myInterface1.method();
		MyInterface1 myInterface2 = () -> System.out.println("집에 매우 가고십다.");

		myInterface2.method();
		MyInterface1 myInterface3 = () -> System.out.println("집에 많이 가고십다.");

		myInterface3.method();
		MyInterface1 myInterface4 = () -> System.out.println("집에 흑흑 가고십다.");

		myInterface4.method();

	}

}
