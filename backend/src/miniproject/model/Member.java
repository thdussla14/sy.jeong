package miniproject.model;

public class Member {
	
	// 1. 필드
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private int mno;		// 고유 회원번호
	
	// 2. 생성자
	public Member() { } // 빈
	public Member(String id, String pwd, String name, String phone, int mno ) { // 풀
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.mno = mno;		// 고유 회원번호
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}

	
}
