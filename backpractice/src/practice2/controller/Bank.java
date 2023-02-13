package practice2.controller;

import java.util.ArrayList;

import practice2.model.Account;

public class Bank {
	// 1. DB 대용 리스트
	ArrayList<Account> accountDB = new ArrayList<>();
	
	// 2. 싱글톤
	private static Bank bank = new Bank();
	private Bank () { }
	public static Bank getInsetance() {
		return bank;
	}
	
	// 3. 계좌생성
	public int creat(String name, String account, String password, int balance) {
		// 3-1. 계좌 객체 생성 / 속성값 대입
		Account ac = new Account(name, account,password,balance);
		// 3-2. DB에 추가
		accountDB.add(ac);
	
		return 0;
	}
	
	// 4. 계좌목록 출력
	public ArrayList<Account> print() {	
		return accountDB;
	}

	// 5. 예금
	public int deposit(String account, int money) {

		int save =0;	
		// 일치하는 계좌찾기
		for (int i=0; i<accountDB.size() ; i++)
			{if(accountDB.get(i).getAccount().equals(account)) 
				{// 계좌 잔액 확인
				save = accountDB.get(i).getBalance();
				 // 계좌 잔액에 예금 추가
				save += money;
				 // 계좌 잔액 수정
				accountDB.get(i).setBalance(save);
				} 
			}// for e

		// 예금 완료 후 잔액 반환
		return save; 
	}
	// 6. 출금
	public int withdraw(String account, String password, int money) {

		int save =0;	
		// 일치하는 계좌찾기
		for (int i=0; i<accountDB.size() ; i++)
			{if(accountDB.get(i).getAccount().equals(account)) 
				{// 비밀번호 확인
				if(accountDB.get(i).getPassword().equals(password))
					// 계좌 잔액 확인
					{save = accountDB.get(i).getBalance();
					if(save>money) 
						{save -= money;accountDB.get(i).setBalance(save);
						// 출금 후 잔액 반환
						return save;}
					// 잔액 부족
					else {return -3;}
				}// 비밀번호 불일치
				else {return -2;}
				}
			}// for e
		// 계좌 불일치
		return -1;
		
	}// withdraw e

}// class e
