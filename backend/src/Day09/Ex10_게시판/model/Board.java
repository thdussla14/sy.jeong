package Day09.Ex10_게시판.model;

import java.util.Date;

/*
	model 클래스 만들기
	1. 필드 선정 [* private 권장]-> 자동완성 불가능
	2. 생성자 [ 빈생성자/풀생성자 ]
	3. 메소드 [ 1.toString() 2. getter/setter ]
*/

public class Board {

	// 1. 필드 [ 관례적으로 모든 필드는 private]
	private String title;
	private String content;	
	private String writer;
	private String password;	
	private Date date; 
	private int view;
	
	// 2. 생성자
	// 2-1. 빈생성자
	public Board() { }
	
	// 2-2. 풀생성자
	public Board(String title, String content, String writer, String password, Date date, int view) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.date = date;
		this.view = view;
	}


	// 3. 메소드
	// 3-1. toString() // 주소값 대신 내부 정보 대입
	@Override
	public String toString() {
		return title +"\t"+  writer +"\t"+ view  +"\t"+ date ;
	}
	// 3-2. Getter/Setter ()
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	
}// class e
