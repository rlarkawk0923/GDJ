package quiz04_cart;

public class Main {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setMoney(10000);
		
		customer.buy(new Meat("불고기", 5000));   // 구매 불가
		customer.buy(new Snack("홈런볼", 1500));     // 5000원짜리 한우를 산다.(카트에 담는다.)
		customer.buy(new Meat("한우", 5000));     // 5000원짜리 한우를 산다.(카트에 담는다.)
		customer.buy(new Milk("서울우유", 2500)); // 2500원짜리 서울우유를 산다.(카트에 담는다.)
		customer.receipt();                       // 영수증을 본다.

	}

}
