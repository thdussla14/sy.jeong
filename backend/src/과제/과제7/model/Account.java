package 과제.과제7.model;

import java.util.ArrayList;
import java.util.Random;

public class Account {

	
	private static ArrayList<Account> accountDB = new ArrayList<>();
	public static ArrayList<Account> getInstance() {
		return accountDB;
	}
	
	
	// 1. 필드
	public String 	bankCode;
	public String  	accountNum;
	public String 	password;
	public String 	name;
	public int 		balance;
	

	// 2. 생성자
	public Account() {	}

	public Account(String accountNum, String password, String name,int balance) {

		this.accountNum = accountNum;
		this.password = password;
		this.name = name;
		this.balance = balance;
	}
	
	// 3. 메소드
	
	
	
	// 계좌생성
	public boolean create(String pw, String name ) {

		// 계좌 객체 생성
		Account account = new Account();
		// 이름, 비밀번호 대입
		account.name = name;
		account.password = pw;
		account.balance = 0;
		
		// 계좌 번호 생성
			// 은행 코드
		account.bankCode = "00";
			// 난수 생성
	aNum : 	while(true) { // 무한루프 [ 종료조건 : 중복되지 않는 계좌 번호 생성 ]
			
			Random random1 = new Random();
			Random random2 = new Random();
			String r1 = String.valueOf(random1.nextInt(89)+10);
			String r2 = String.valueOf(random2.nextInt(89)+10);		
			String random3 = bankCode+"-"+r1+"-"+r2;
			
			if (getInstance().size()>0)
				{for (Account a : getInstance())
					{if(!a.accountNum.equals(random3))
						{account.accountNum = random3;; break aNum;}}}
			else {account.accountNum = random3;; break aNum; }
			}
		
		// 계좌DB에 저장

		accountDB.add(account);
		
		System.out.println("------------------생성 완료-------------------");
		System.out.println("계좌주 : "	+ account.name);
		System.out.println("계좌번호: "	+ account.accountNum);
		System.out.println("계좌은행: "	+ account.bankCode);
		
		
		// 생성된 계좌 반환
		return true;		
	}
	

	// 예금
	public void deposit(String account,int money ) {
		
		int check = -1;
		// 계좌번호 확인
		for (int i=0; i<accountDB.size();i++)
			{if(accountDB.get(i).accountNum.equals(account))
				{ // 예금액 입금 
				accountDB.get(i).balance += money; check = i;}
		}// for e

		System.out.println("-----------------입금 완료-------------------");
		System.out.println("계좌주 :  "	+accountDB.get(check).name);
		System.out.println("계좌번호: "	+accountDB.get(check).accountNum);
		System.out.println("계좌잔액: "	+accountDB.get(check).balance);

		
		return ;
	}
	
	
	
	
}
