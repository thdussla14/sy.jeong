package model.Dto;

public class BoardDto {

	private int 	bno;	
    private String 	btitle;	
    private String 	bcontent;
    private String 	bfile;
    private String 	bdate;	
    private int 	bview;	
    private int 	blike;	
    private int 	bhate;	
    private int 	mno;	
    private int 	cno;	
    
    private String 	mid	;
    private String 	cname;
    
    // 빈생성자
    public BoardDto() { }

    // 등록용 생성자
	public BoardDto(String btitle, String bcontent, String bfile, int mno, int cno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.cno = cno;
	}
	// 출력용 생성자
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int blike,
			int bhate, int mno, int cno, String mid, String cname) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.blike = blike;
		this.bhate = bhate;
		this.mno = mno;
		this.cno = cno;
		this.mid = mid;
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", blike=" + blike + ", bhate=" + bhate + ", mno=" + mno
				+ ", cno=" + cno + ", mid=" + mid + ", cname=" + cname + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public int getBlike() {
		return blike;
	}

	public void setBlike(int blike) {
		this.blike = blike;
	}

	public int getBhate() {
		return bhate;
	}

	public void setBhate(int bhate) {
		this.bhate = bhate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	
    
    
    
}
