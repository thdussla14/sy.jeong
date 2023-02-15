package 과제.과제7.view;

import java.util.Scanner;

import 과제.과제7.model.Account;
import 과제.과제7.model.국민;
import 과제.과제7.model.신한;
import 과제.과제7.model.우리;

public class Front {

	// 싱글톤
	private static Front front = new Front();
	private Front () { }
	public static Front getInstance() {
		return front;
	}
	
	Scanner scanner = new Scanner(System.in);
	Account bankA = new 국민();
	Account bankB = new 신한();
	Account bankC = new 우리();
	
	// 초기 페이지------------------------------------------------------------------------------
	public void index() {
		while(true) {// 무한루프  [종료조건 : 없음 ]
			System.out.println("-----------------계좌 관리-------------------");
			System.out.println("은행명\t계좌번호\t\t예금액 ");
			for(Account a : Account.getInstance())
				{String bank = null;
				if	   (a.accountNum.split("-")[0].equals("03")) {bank = "국민";}
				else if(a.accountNum.split("-")[0].equals("04")) {bank = "신한";}
				else if(a.accountNum.split("-")[0].equals("05")) {bank = "우리";}
				System.out.println(bank+"\t"+a.accountNum.toString()+"\t"+a.balance);
				
				} // for e
			System.out.println("-------------------------------------------");
			System.out.println("메뉴>  1.계좌생성  2.예금 ");
			System.out.println("-------------------------------------------");
			int ch = scanner.nextInt();
			if(ch==1) { bankselect_page();}
			else if(ch==2) { deposit_page(); }
			else {System.err.println("[알림] 알 수 없는 행동입니다.");  }
	
		}// while e
	}// index e
	
	// 계좌 생성 은행 선택------------------------------------------------------------------------
	public void bankselect_page() {

		System.out.println("-----------------계좌 생성-------------------");
		System.out.println("메뉴>  1.국민  2.신한  3.우리 "); 
		
		int ch = scanner.nextInt();
		String bank = null;
		if 		( ch==1 ) 	{System.out.println("국민은행을 선택하셨습니다."); bank = "03"; create_page(bank);}
		else if ( ch==2 ) 	{System.out.println("신한은행을 선택하셨습니다."); bank = "04"; create_page(bank);}
		else if ( ch==3 ) 	{System.out.println("우리은행을 선택하셨습니다."); bank = "05"; create_page(bank);}
		else {System.err.println("[알림] 알 수 없는 행동입니다.");  }

	}// bankselect_page e
	
	// 계좌 생성 정보 입력------------------------------------------------------------------------	
	public void create_page(String bank) {
		
		System.out.println("------------------정보 입력------------------");
		System.out.println("계좌주 	: ");	String name = scanner.next();
		System.out.println("계좌비밀번호: ");	String pw   = scanner.next();	

		if 		( bank.equals("03")) 	{bankA.create(pw, name); }
		else if ( bank.equals("04")) 	{bankB.create(pw, name); }
		else if ( bank.equals("05")) 	{bankC.create(pw, name); }

	}// create_page e

	// 계좌 입금------------------------------------------------------------------------------	
	
	private void deposit_page() {

		System.out.println("-----------------계좌 입금-------------------");
		System.out.println("입금할 계좌번호: ");	String account = scanner.next();
		System.out.println("예금액 	   : ");int		money  = scanner.nextInt();
		
		
		
		if	   (account.split("-")[0].equals("03")) {bankA.deposit(account, money);}
		else if(account.split("-")[0].equals("04")) {bankB.deposit(account, money);}
		else if(account.split("-")[0].equals("05")) {bankC.deposit(account, money);}

		
	}
	
	
	
	
	
	
	
	
	
	
	
}// class e
