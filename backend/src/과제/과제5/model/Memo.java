package 과제.과제5.model;

public class Memo {

	// 1. 필드
	// 1-1. 관계 필드 = 참조 필드 [FK]
	private int sendmno;		// 쪽지 보낸 회원 번호
	private int pno;			// 받는 사람 + 현재 쪽지의 제품 번호
	// 1-1. 관계 필드 = 식별 필드 [PK]
	private int meno;			// 쪽지번호
	// 1-2. 일반 필드
	private String mContent;	
	
	// 2. 생성자
	// 2-1. 빈
	public Memo() {	}
	// 2-2. 풀
	public Memo(int sendmno, int pno, int meno, String mContent) {
		super();
		this.sendmno = sendmno;
		this.pno = pno;
		this.meno = meno;
		this.mContent = mContent;
	}
	// 3. 메소드
	@Override
	public String toString() {
		return "Memo [sendmno=" + sendmno + ", pno=" + pno + ", meno=" + meno + ", mContent=" + mContent + "]";
	}
	public int getSendmno() {
		return sendmno;
	}
	public void setSendmno(int sendmno) {
		this.sendmno = sendmno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getMeno() {
		return meno;
	}
	public void setMeno(int meno) {
		this.meno = meno;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

}// class e
