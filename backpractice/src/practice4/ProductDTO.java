package practice4;

public class ProductDTO {

	private int 	pno;
	private String 	pname;
	private int 	pprice;
	private int 	pstock;
	private int 	count;
	
	public ProductDTO() {	}

	public ProductDTO(int pno, String pname, int pprice, int pstock, int count) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.pstock = pstock;
		this.count = count;
	}

	@Override
	public String toString() {
		return "ProductDTO [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", pstock=" + pstock + ", count="
				+ count + "]";
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

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPstock() {
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
