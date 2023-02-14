package 과제.과제4_싱글톤.model;

/*
		M : Member/Board 관계 
			=> 1명의 회원이 글 작성			 [ object ]
			=> 1명의 회원이 여러개의 글 작성 가능	 [ ArrayList ]	
			=> *** 양방향으로 관계시 toString X [ 무한루프에 빠짐 ]
*/

public class Board {

	// 1. 필드 => 제목, 내용, 조회수
	private String title;
	private String content;
	private int view;
	// 하나의 게시물 [객체]가 하나의 member 객체를 가질 수 있다.
	private Member member; // 글 주인 1명
	
	// 2. 생성자
	public Board() { }

	public Board(String title, String content, int view, Member member) {
		super();
		this.title = title;
		this.content = content;
		this.view = view;
		this.member = member;
	}

	// 3. 메소드

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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
