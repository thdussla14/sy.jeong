package 과제.과제5.model;

public class Member {
	
	// 1. 필드
	// 단방향보다 양방향이 메모리 효율성이 좋음 [ 작은 프로젝트에서는 크게 차이나지 않으나 대형 프로젝트에서 차이 있음 ]
	// 1-1. 관계 필드  = 식별자 [PK] 
	private int mno; // 회원번호 // 객체를 식별하기 위한 데이터 = 인덱스 // 중복이 없어야 함..ㅎ	
	// 1-2. 일반필드
	private String id;
	private String pw;
	private String phone;
	
	// 2. 생성자
	// 2-1. 빈
	public Member() { }
	// 2-2. 풀
	public Member(int mno, String id, String pw, String phone) {
		super();
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}
	// 3. 메소드
	@Override
	public String toString() {
		return "Member [mno=" + mno + ", id=" + id + ", pw=" + pw + ", phone=" + phone + "]";
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}// class e
