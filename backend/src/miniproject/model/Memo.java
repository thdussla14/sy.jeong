package miniproject.model;

public class Memo {
	
	// 필드 영역
	// 관계 필드 영역
	private int fromNo;
	// 용도: 참조용 FK로, 쪽지를 보낸 회원 번호 추적에 사용
	private int pNo;
	// 용도: 참조용 FK로, 받는사람과 현재 쪽지의 제품 정보 추적에 사용
	private int meNo;
	// 용도: 식별용 PK로, 쪽지번호 로그에 사용
	
	// 일반 필드 영역
	private String title;
	private String content;
	
	// 생성자 영역
	// Empty 생성자 생성
	public Memo() {}

	// Full 생성자 생성
	public Memo(int fromNo, int pNo, int meNo, String title, String content) {
		super();
		this.fromNo = fromNo;
		this.pNo = pNo;
		this.meNo = meNo;
		this.title = title;
		this.content = content;
	}

	// 메소드 영역
	public String searchID( int mno ) {		
		
		// 1. product에 등록된 mno와 현재 mno가 일치하는지 확인 필요
		// 2. 같으면, fromNo와 같은 Member에 저장되어 있는 아이디 출력
		// Member.getInstance().get
		return null;
	}
	
	@Override
	public String toString() {
		return "MMemo [fromNo=" + fromNo + ", pNo=" + pNo + ", meNo=" + meNo + ", title=" + title + ", content=" + content
				+ "]";
	}

	public int getfromNo() {
		return fromNo;
	}

	public void setfromNo(int fromNo) {
		this.fromNo = fromNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getMeNo() {
		return meNo;
	}

	public void setMeNo(int meNo) {
		this.meNo = meNo;
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
}
