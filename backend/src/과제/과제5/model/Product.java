package 과제.과제5.model;

public class Product {
	
	// 1.필드
	// 1-1. 관계 필드 = 참조 필드 [FK]
	private int mno;
	// 1-1. 관계 필드 = 식별 필드 [PK]
	private int pno;
	// 1-2. 일반 필드
	private String title;
	private String content;
	private String price;
	private String state;	// 제품상태 : 판매중, 판매완료
		
	// 2. 생성자
	// 2-1. 빈
	public Product() { }
	// 2-2. 풀
	public Product(int mno, int pno, String title, String content, String price, String state) {
		super();
		this.mno = mno;
		this.pno = pno;
		this.title = title;
		this.content = content;
		this.price = price;
		this.state = state;
	}
	// 3. 메소드
	@Override
	public String toString() {
		return "Product [mno=" + mno + ", pno=" + pno + ", title=" + title + ", content=" + content + ", price=" + price
				+ ", state=" + state + "]";
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}// class e
