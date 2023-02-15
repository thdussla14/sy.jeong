package 과제.과제7.model;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

	private ArrayList<Bank> bankList = new ArrayList<>();
	
	
	// 1. 필드
	private String 	bankCode;
	private String 	account;
	private String 	password;
	private String 	name;
	private int 	balance;
	
	
	// 2. 생성자
	public Bank() {	}

	public Bank(String bankCode, String account, String password, String name, int balance) {

		this.bankCode = bankCode;
		this.account = account;
		this.password = password;
		this.name = name;
		this.balance = balance;
	}
	
	// 3. 메소드
	
	// 계좌생성
	public Bank create(int ch, String pw, String name ) {
		
		// 1. 은행선택

		
		
		// 2. 자동생성
		
		Random random = new Random();
		
		Bank bank = new Bank();
		bankList.add(bank);
		
		return bank;
	}
	
	// 예금
	public int deposit(String account,int money ) {
		
		// 1. 계좌번호 입금
		
		
		return 100000;
	}
	
	
	
	
}
