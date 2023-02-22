package Day15.Ex9_MVC패턴;

public class MemberDTO {

	// 1. 필드	[ DB 필드와 일치]
	private int mno;
	private String mid;
	private String mpw;

	// 2. 생성자
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDTO(int mno) {
		super();
		this.mno = mno;
	}
	
	public MemberDTO(String mid, String mpw) {
		super();
		this.mid = mid;
		this.mpw = mpw;
	}
	
	public MemberDTO(int mno, String mid, String mpw) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
	}


	// 3. 메소드	
	@Override
	public String toString() {
		return "BoardDTO [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + "]";
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

}
