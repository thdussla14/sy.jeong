package model.Dto;

import java.util.List;

public class ProductDto {

	private int 	pno;
	private String 	pname ;     	
	private String 	pcontent   ;	
	private int 	pprice ;  	
	private int 	pstate;	 
	private String 	plat	;		
	private String 	plng	;	
	private int 	pview;	
	private String 	pdate	;
	
	// 추가 사항?
	private int 	mno; 			// 등록한 회원 번호	
	private String	mid; 			// 등록한 회원 아이디
	private String	mimg; 			// 등록한 회원 프로필
	private List<String> pimglist; 	// 등록한 사진 목록들
	
	// 빈생성자 
	public ProductDto() {  }

	// 등록용 생성자 [ 제품명, 제품설명, 제품가격, 위도, 경도,회원번호, 이미지목록 ]  
	public ProductDto(String pname, String pcontent, int pprice, String plat, String plng, int mno,List<String> pimglist) {
		super();
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.pimglist = pimglist;
	}
	
	// 출력용 생성자 [ 제품번호, 제품명, 제품설명, 제품가격, 위도, 경도,회원번호, 이미지목록 ]
	public ProductDto(int pno, String pname, String pcontent, int pprice, int pstate, String plat, String plng,
			int pview, String pdate) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.pstate = pstate;
		this.plat = plat;
		this.plng = plng;
		this.pview = pview;
		this.pdate = pdate;
	}
	
	
	// 풀생성자
	public ProductDto(int pno, String pname, String pcontent, int pprice, int pstate, String plat, String plng,
			int pview, String pdate, int mno, String mid, String mimg, List<String> pimglist) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.pstate = pstate;
		this.plat = plat;
		this.plng = plng;
		this.pview = pview;
		this.pdate = pdate;
		this.mno = mno;
		this.mid = mid;
		this.mimg = mimg;
		this.pimglist = pimglist;
	}

	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pcontent=" + pcontent + ", pprice=" + pprice
				+ ", pstate=" + pstate + ", plat=" + plat + ", plng=" + plng + ", pview=" + pview + ", pdate=" + pdate
				+ ", mno=" + mno + ", mid=" + mid + ", mimg=" + mimg + ", pimglist=" + pimglist + "]";
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
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

	public List<String> getPimglist() {
		return pimglist;
	}

	public void setPimglist(List<String> pimglist) {
		this.pimglist = pimglist;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPstate() {
		return pstate;
	}

	public void setPstate(int pstate) {
		this.pstate = pstate;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getPlng() {
		return plng;
	}

	public void setPlng(String plng) {
		this.plng = plng;
	}

	public int getPview() {
		return pview;
	}

	public void setPview(int pview) {
		this.pview = pview;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	   
	   
}
