package 과제.과제7.model;

import java.util.Random;

public class 신한 extends Account{

	// 1. 필드
	private final String bankCode="04";

	// 2. 생성자
	public 신한() {
		// TODO Auto-generated constructor stub
	}
	public 신한(String accountNum, String password, String name,int balance) {
		super(accountNum,password,name,balance);
	}
	
	// 3. 메소드
	@Override
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
		account.bankCode = bankCode;
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
		}// while e
	
		// 계좌DB에 저장

		getInstance().add(account);
		
		System.out.println("------------------생성 완료-------------------");
		System.out.println("계좌주 : "	+ account.name);
		System.out.println("계좌번호: "	+ account.accountNum);
		System.out.println("계좌은행: "	+ account.bankCode);
		System.out.println("신한은행 계좌 만들어주셔서 감사합니다.." );
		
		// 생성된 계좌 반환
		return true;		
	}
	@Override
	// 예금
	public void deposit(String account,int money ) {
		
		int check = -1;

		// 계좌번호 확인
		for (int i=0; i<getInstance().size();i++)
			{if(getInstance().get(i).accountNum.equals(account))
				{ // 예금액 입금 
				getInstance().get(i).balance += money; check = i;}	
		}// for e
		
		System.out.println("-----------------입금 완료-------------------");
		System.out.println("계좌주 :  " 	+getInstance().get(check).name);
		System.out.println("계좌번호: " 	+getInstance().get(check).accountNum);
		System.out.println("계좌잔액: "	+getInstance().get(check).balance);

	
		return ;
	}
	
}
