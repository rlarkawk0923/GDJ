package quiz03_BANK;

public class Main {

	public static void main(String[] args) { //main에서도 throws 가능
		
		Bank me = new Bank("1111", 10_000);
		Bank mom = new Bank("2222", 100_000);
		
		try {
		//me.deposit(-1);
		mom.transfer(me,  50000);
		}catch(BankException e) {
			System.out.println(e.getMessage() + "," + e.getErrorCode());
		}
		
		me.inquery();
		mom.inquery();
		
	}

}
