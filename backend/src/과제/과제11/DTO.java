package 과제.과제11;

public class DTO {

	private int    pno;
	private String pname;
	private int    price;
	private int    Storage;
	
	public DTO() {
		// TODO Auto-generated constructor stub
	}
	public DTO(int pno,String pname, int price) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
	}
	public DTO(String pname, int price, int storage) {
		super();
		this.pname = pname;
		this.price = price;
		this.Storage = storage;
	}
	public DTO(int pno, String pname, int price, int storage) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.Storage = storage;
	}
	
	@Override
	public String toString() {
		return "DTO [pno=" + pno + ", pname=" + pname + ", price=" + price + ", Storage=" + Storage + "]";
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

	public int getStorage() {
		return Storage;
	}

	public void setStorage(int storage) {
		Storage = storage;
	}
	
	
	
}
