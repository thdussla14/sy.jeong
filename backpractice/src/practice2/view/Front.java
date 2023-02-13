package practice2.view;

import java.util.ArrayList;
import java.util.Scanner;

import practice2.controller.Bank;
import practice2.model.Account;

public class Front {

	// ** 입력 객체 생성
	Scanner scanner = new Scanner(System.in); 
	
	
	// 1. 싱글톤 객체 
		// 1-1. 클래스 내부에 객체 생성
		private static Front front = new Front();
		// 1-2. 생성자 private
		private Front() { }
		// 1-3. 내부객체 반환 함수
		public static Front getInstance() {
			return front;
		}
	
	// 2. index
	public void index() {
		while(true) { // 무한루프 [종료조건  5.종료]
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.println("선택 >");    int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("-------");
				System.out.println("계좌생성");
				System.out.println("-------");
				
				create(); }
			else if(ch==2) {
				System.out.println("-------");
				System.out.println("계좌목록");
				System.out.println("-------");
				
				print(); }
			else if(ch==3) {
				System.out.println("-------");
				System.out.println("예금");
				System.out.println("-------");
				
				deposit(); }
			else if(ch==4) {
				System.out.println("-------");
				System.out.println("출금");
				System.out.println("-------");
				
				withdraw(); }
			else if(ch==5) {System.out.println("[알림]은행 어플을 종료합니다.");break;}
			else {System.err.println("[알림] 알 수 없는 행동입니다."); }
			
		}//while e
	}// index e
		
	// 3. 계좌생성
	public void create() {
		System.out.println("계좌주 : ");		String name = scanner.next();
		System.out.println("계좌번호 :");		String account = scanner.next();
		System.out.println("비밀번호 :");		String password = scanner.next();
		System.out.println("초기입금액 : ");	int balance = scanner.nextInt();
		System.out.println("-------------------------------------------");
		
		int result = Bank.getInsetance().creat(name, account,password,balance);
		if(result == 0 ) {System.out.println("[알림] 계좌 생성되었습니다.");}
		else {System.err.println("[알림] 계좌 생성에 실패하였습니다.");}
	
	}// create e
	
	// 4. 계좌목록 출력
	public void print() {

		ArrayList<Account> result = Bank.getInsetance().print(); 
		result.forEach((o) ->{
			System.out.println(o.toString());
		});
	
	}// print e
	
	// 5. 예금
	public void deposit() {

		System.out.println("계좌번호 : ");		String account = scanner.next();
		System.out.println("예금액 : ");		int money = scanner.nextInt();
		
		int result = Bank.getInsetance().deposit(account,money);
		System.out.println("-------------------------------------------");
		System.out.println("[알림] 예금 완료되었습니다.");
		System.out.println("계좌보유액 :"+result);
		System.out.println("-------------------------------------------");
		
	}// deposit e
	
	// 6. 출금
	public void withdraw() {
		
		System.out.println("계좌번호 : ");		String account = scanner.next();
		System.out.println("비밀번호 :");		String password = scanner.next();
		System.out.println("예금액 : ");		int money = scanner.nextInt();
		
		int result = Bank.getInsetance().withdraw(account,password,money);
		if(result>0) {
			System.out.println("-------------------------------------------");
			System.out.println("[알림] 출금 완료되었습니다.");
			System.out.println("계좌보유액 :"+result);
			System.out.println("-------------------------------------------");
		}
		else if (result == -1)
			{System.err.println("[알림] 존재하지 않는 계좌입니다.");}
		else if (result == -2)
			{System.err.println("[알림] 비밀번호가 일치하지 않습니다.");}
		else if (result == -3)
			{System.err.println("[알림] 잔액이 부족합니다.");}
		
	}//withdraw e
		
		
}// class e
