package Day11.Ex1;

public class SmartPhone extends Phone {
			// 자식클래스명 extends 부모클래스명
			// 부모클래스의 멤버들을 자식클래스가 사용 가능
	
	// 1. 필드
	public boolean wifi;
	
	// 2. 생성자
	public SmartPhone() { }

	public SmartPhone(String model,String color) {
		super(model,color);
		System.out.println("--자식클래스 생성자 실행");
	}

	// 3. 메소드
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
	
	
}
