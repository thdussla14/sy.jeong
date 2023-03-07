package practice.day03;

public class ProductDto {

	private int 	pno;
	private String 	pname;
	private int		price;
	
	public ProductDto() {}

	public ProductDto(int pno, String pname, int price) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pno=" + pno + ", pname=" + pname + ", price=" + price + "]";
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
