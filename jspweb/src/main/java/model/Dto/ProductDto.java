package model.Dto;

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
	
	
	
	public ProductDto() {  }

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

	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pcontent=" + pcontent + ", pprice=" + pprice
				+ ", pstate=" + pstate + ", plat=" + plat + ", plng=" + plng + ", pview=" + pview + ", pdate=" + pdate
				+ "]";
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
