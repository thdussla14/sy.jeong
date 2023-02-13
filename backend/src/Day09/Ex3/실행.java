package Day09.Ex3;

public class 실행 {

	public static void main(String[] args) {
		
		// 1. 객체 생성
		
		// 1-1. 객체의 필드 초기화 방법
		
			// 1. 필드 [직접 - 관례적으로 사용 X]
			Car car = new Car();
			car.gas = 5;
			
			// 2. 생성자[간접] : 객체의 필수 데이터
			Car yourCar = new Car();
			yourCar = new Car(5);
				
			// 3. 메소드[간접] : 객체 생성 후 데이터
			Car myCar = new Car();	// 객체 생성
			myCar.setGas(5);		// 3-1. 객체내 함수 호출
		
			if(myCar.isLeftGas()) { // 3-2. 객체내 함수 호출
				System.out.println("출발합니다.");
				myCar.run();		// 3-3. 객체내 함수 호출
			}
			
			System.out.println("gas를 주입하세요.");
			
			
			
	}// main e
	
}// class e
