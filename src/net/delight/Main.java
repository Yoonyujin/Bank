package net.delight;

import java.util.Scanner;

public class Main {
	
	private Bank bank;
	private Scanner scanner;
	
	public Main() {
		scanner = new Scanner(System.in);
	}
	
	public void mediation() {
		
		//계좌를 생성합니다.
		System.out.println("안녕하세요 00은행입니다.");
		
		System.out.println("예금주 명을 입력하세요.");
		String accountName = scanner.next();
		
		System.out.println("계좌번호를 입력하세요.");
		String accountNumber = scanner.next();
		
		System.out.println("개설일자를 입력하세요.");
		String accountDate = scanner.next();
		
		System.out.println("입금 금액을 입력하세요.");
		long deposit = scanner.nextLong();
		
		System.out.println("계좌가 생성되었습니다.");
		bank = new Bank(accountName, accountNumber, accountDate, deposit);
		//계좌조회
		bank.showMyBalance();
		
		this.operate();
		
	}
	
	private void operate() {
		
		int selectedMenu = 0;
		long money = 0;
		
		// 업무선택(무한반복)
		while(true){
			
			System.out.println("업무를 선택하세요.");
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 종료");
			selectedMenu = scanner.nextInt();
			
			//입금 업무
			if(selectedMenu == 1) {
				System.out.println("입금 금액을 입력하세요.");
				money = scanner.nextLong();
				bank.deposit(money);
			}
			
			//출금 업무
			else if(selectedMenu == 2) {
				
				boolean isSuccess = false;
				
				//잔액이 모자랄 경우 출금업무 반복
				while(true) {
					System.out.println("출금 금액을 입력하세요");
					money = scanner.nextLong();
					
					isSuccess = bank.withdraw(money);
					
					if(isSuccess) {
						//출금 업무 후, true 반환 -> 출금업무 무한반복 종료 
						break;
					}
				}
			}
			
			//업무 종료
			else if(selectedMenu == 3) {
				//업무선택 무한반복 종료 
				System.out.println("안녕히가세요.");
				break;
			}
			
			//다른 번호 입력 시, 잘못 선택하셨습니다.
			else {
				System.out.println("잘못 선택하셨습니다.");
			}


			
		}
	}
	
	public static void main(String[] args){
		
		new Main().mediation();
	}

}
