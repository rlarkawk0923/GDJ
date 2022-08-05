package quiz03_BANK;

public class Bank {
	
	private String accNo;
	private long balance;
	
	public Bank(String accNo, long balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}
	
	public void deposit(long money) throws BankException{
		if(money<0) {
			throw new BanKException("마이너스 입금 불가", 1);
		}
		
		balance += money;
		
	}
	
	public long withdrawl(long money) throws BankException{
		if(money < 0) {
			throw new BankException("마이너스 출금 불가", 2);
		}
		else if(balance < money) {
			throw new BankException("잔액 부족", 3);
		}
		balance -= money;
		return money;
	}
	
	public void transfer(Bank acc, long money) throws BanKException {
		acc.deposit(withdrawl(money)); // 예외 호출 try-catch or throws
	}
	
	public void inquery() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Bank [accNo=" + accNo + ", balance=" + balance + "]";
	}

}
