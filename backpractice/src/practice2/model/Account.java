package practice2.model;

public class Account {

	// 1. 필드
	private String name;
	private String account;
	private String password;
	private int balance;
	
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;

	// 2. 생성자
	// 2-1. 빈생성자
	public Account() { }


	// 2-2. 풀생성자
	public Account(String name, String account, String password, int balance) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.balance = balance;
	}

	// 3. 메소드
	// 3-1. toString
	@Override
	public String toString() {
		return account + "\t" + name + "\t" + balance ;
	}

	// 3-2. getter / setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	
}
