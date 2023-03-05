package PENGUINFLIGHT.model;

public class Reservation{
	private int rno;//예약 번호
	private int sno;//스케줄 번호
	private int mno;//회원번호 
	private int men;//인원수
	private int tprice;//총 가격
	
	private String lname; // 항공사 이름
	private String aname; // 비행기 이름
	private String departure; // 출발지
	private String arrival; // 출발지
	private String date; // 비행일
	private String adate; // 도착일
	private String tier;
	
	private float discount; // 할인가
	private float arate; // 적립
	private int rseats ; // 좌석
	
	

	
	public Reservation() {}

	
	//ticketReservation
	public Reservation(int sno, String lname, String aname, String departure, String arrival, String date, 
			String adate , int tprice, int rseats, int mno , float discount ,float arate  ) {
		super();
		this.sno = sno;
		this.lname = lname;
		this.aname = aname;
		
		this.departure = departure;
		this.arrival = arrival;
		this.date = date;
		
		this.adate = adate;
		this.tprice = tprice;
		this.rseats = rseats;
		
		this.mno = mno;
		this.discount = discount;
		this.arate = arate;
	}



	//flightSelect
	public Reservation( int sno , String lname , String aname ,String departure,  String arrival  , String date , String adate, int tprice ,int men) {
		super();
		this.sno = sno;
		this.lname = lname;
		this.aname = aname;
		
		this.departure = departure;
		this.arrival = arrival;
		this.date = date;
		
		this.adate = adate;
		this.tprice = tprice;
		this.men = men;
	}


	//Myreser
	public Reservation(int rno, int sno, int mno, int men, int tprice, String lname, String departure, String arrival,
			String date , String tier , float discount , float arate) {
		super();
		this.rno = rno;
		this.sno = sno;
		this.mno = mno;
		this.men = men;
		this.tprice = tprice;
		this.lname = lname;
		this.departure = departure;
		this.arrival = arrival;
		this.date = date;
		this.tier = tier;
		this.discount = discount;
		this.arate = arate;
	}



	@Override
	public String toString() {
		return "Reservation [rno=" + rno + ", sno=" + sno + ", mno=" + mno + ", men=" + men + ", tprice=" + tprice
				+ "]";
	}

	
	
	
	
	public String getAname() {
		return aname;
	}



	public void setAname(String aname) {
		this.aname = aname;
	}



	public String getAdate() {
		return adate;
	}



	public void setAdate(String adate) {
		this.adate = adate;
	}



	public String getTier() {
		return tier;
	}


	public void setTier(String tier) {
		this.tier = tier;
	}


	public float getDiscount() {
		return discount;
	}


	public void setDiscount(float discount) {
		this.discount = discount;
	}


	public float getArate() {
		return arate;
	}


	public void setArate(float arate) {
		this.arate = arate;
	}


	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getMen() {
		return men;
	}

	public void setMen(int men) {
		this.men = men;
	}

	public int getTprice() {
		return tprice;
	}

	public void setTprice(int tprice) {
		this.tprice = tprice;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getDeparture() {
		return departure;
	}


	public void setDeparture(String departure) {
		this.departure = departure;
	}


	public String getArrival() {
		return arrival;
	}


	public void setArrival(String arrival) {
		this.arrival = arrival;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getRseats() {
		return rseats;
	}


	public void setRseats(int rseats) {
		this.rseats = rseats;
	}


	
}
