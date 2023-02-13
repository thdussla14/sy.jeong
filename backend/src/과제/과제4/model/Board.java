package 과제.과제4.model;

public class Board {

	// 1. 필드	
	public String writer;
	public String title;
	public String content;
	public int view;
	
	// 2. 생성자	
	// 2-1. 빈생성자
	public Board() { }	
	// 2-2. 풀생성자
	public Board(String writer, String title, String content, int view) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.view = view;
	}

	// 3. 메소드
	// 3-1. toString()
	@Override
	public String toString() {
		return  "\t"+view +"\t"+ writer +"\t"+ title ;  
	}
	// 3-2. getter/setter

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

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

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}
	
}// class e
