package Day11.Ex6;

public class 실행 {

	public static void main(String[] args) {
		
		// * 타이어
		Tire tire = new Tire(); // 기본타이어
		
		// 1. 자동차 객체 만들기
		Car mycar = new Car();
			// 자동차 객체에 타이어 객체 1개 포함		
		// 2. 기본 타이어 장착
		mycar.tire = new Tire();
		mycar.run();
			Tire result = mycar.parking(tire);
			
		// 3. 한국 타이어 교체
		mycar.tire = new HankookTire();
		mycar.run();
		
		HankookTire hankookTire =  new HankookTire();
			HankookTire result2 = (HankookTire)mycar.parking(hankookTire);
			
			System.out.println(result2 instanceof Tire);	// true 상속 o // 형제 관계 x
			System.out.println(result2 instanceof Object);	// true 상속 o // 형제 관계 x
			
		// 4. 금호 타이어 교체
		mycar.tire = new KumhoTire();
		mycar.run();
		
		KumhoTire kumhoTire 	=  new KumhoTire();
			KumhoTire result3 	= (KumhoTire)mycar.parking(kumhoTire);
		
			System.out.println(result3 instanceof Tire);	// true 상속 o // 형제 관계 x
			System.out.println(result3 instanceof Object);	// true 상속 o // 형제 관계 x
		
	}// main e
	
}// class e
