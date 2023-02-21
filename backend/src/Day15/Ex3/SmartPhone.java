package Day15.Ex3;

public class SmartPhone {

	// 1. 필드
	private String company;
	private String os;

	// 2. 생성자
	public SmartPhone(String company, String os) {
		super();
		this.company = company;
		this.os = os;
	}

	// 3. 메소드
	@Override
	public String toString() {
		return "SmartPhone [company=" + company + ", os=" + os + "]";
	}
}
