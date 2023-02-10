package 과제.과제4.model;

public class Board {

	// 1. 필드
	public String id;
	public String title;
	public String content;
	public int count;
	
	// 2. 생성자
	
	public Board() { }

	public Board(String id, String title, String content, int count) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.count = count;
	}
	

}
