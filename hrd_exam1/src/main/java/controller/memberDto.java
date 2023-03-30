package controller;

public class memberDto {
	
	private int			custno;		
	private String		custname;	
	private String		phone	;	
	private String		address	;	
	private String		joindate;	
	private String		grade	;	
	private String		city	;	

	// 추가
	private int 		price;
	
	public memberDto() {}


	public memberDto(int custno, String custname, String phone, String address, String joindate, String grade,
			String city) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	public memberDto(int custno, String custname, String grade, int price) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.price = price;
	}


	@Override
	public String toString() {
		return "memberDto [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
				+ ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + "]";
	}

	
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCustno() {
		return custno;
	}


	public void setCustno(int custno) {
		this.custno = custno;
	}


	public String getCustname() {
		return custname;
	}


	public void setCustname(String custname) {
		this.custname = custname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getJoindate() {
		return joindate;
	}


	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
}
