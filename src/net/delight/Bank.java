package net.delight;

public class Bank {
	
	/**
	 * 1. 은행 계좌는 다음 특징을 가지고 있습니다.
	 * 1. 계좌번호
	 * 2. 예금주
	 * 3. 개설일자
	 * 4. 잔액
	 * 
	 * 2. 은행 계좌로 다음과 같은 행동을 할 수 있습니다.
	 * 1. 입금한다
	 * 2. 출금한다.
	 * 3. 잔액을 조회한다.
	 */
	
	private String accountName;
	private String accountNumber;
	private String accountDate;
	private long balance;
	
	public Bank(String accountName, String accountNumber, String accountDate, long balance) {
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.accountDate = accountDate;
		this.balance = balance;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public void deposit(long money) {
		this.balance += money;
		System.out.printf("%,d원 입금 되었습니다.\n", money);
		showMyBalance(); //체이닝 - 바로 불러줌 
	}
	
	public boolean withdraw(long money) {
		
		if ( balance < money ) {
			//출금 금액이 잔액보다 클 경우, false 반환
			System.out.println("잔액이 모자랍니다. 출금 할 수 없습니다.");
			return false;
		}
		else {
			//출금업무
			this.balance -= money;
			showMyBalance();
			return true;
		}

	}
	
	
	
	public void showMyBalance() {
		
		System.out.printf("[계좌번호 : %s, 예금주 : %s] 잔액 : %,d원 \n", accountNumber, accountName, balance);
	}

	

}
