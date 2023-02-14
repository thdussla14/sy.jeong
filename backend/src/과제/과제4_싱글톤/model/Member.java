package 과제.과제4_싱글톤.model;

import java.util.ArrayList;

// M :데이터 저장할 떄 사용되는 데이터 모델링
	// - 회원[객체] 여러명 만들어서 하나의 리스트에 저장
	// - 필드 : private => 외부의 직접접근 방지 => get,set 대체 접근 수단(필터링 가능)
	// - 생성자 : 1. 빈생성자  2. 풀생성자
public class Member {
	
	// 인스턴스 멤버 : 객체 있어야 사용 -> 스택 영역	
	// 정적 멤버 : static 객체 없이 사용 -> 메소드 영역
	
	// 1. 필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	// 한명의 회원[객체]가 여러개의 board 객체를 가질 수 있다.
	private ArrayList<Board> boardList = new ArrayList<>();
	
	// 2. 생성자
	// 2-1. 빈생성자
	public Member() { }
	// 2-2. 풀생성자
	public Member(String id, String pw, String name, String phone, ArrayList<Board> boardList) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.boardList = boardList;
	}

	// 3. 메소드

	// 3-2. get/set
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
	public ArrayList<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}
	
}
