package Day13.Ex5;

public class 실행 {

	public static void main(String[] args) {
		
		Car myCar = new Car();			// 한국타이어 2개 장착된 차 객체 생성
		
		myCar.run();					// 한국타이어 2개 장착된 차 주행
		
		myCar.tire1 = new KumhoTire();	// 한국타이어 1개 금호타이어 1개로 교체
		myCar.tire2 = new KumhoTire();  // 한국타이어 1개 금호타이어 1개로 교체
		
		myCar.run();					// 금호타이어 2개 장착된 차 주행
		
	}// main e

}// class e

