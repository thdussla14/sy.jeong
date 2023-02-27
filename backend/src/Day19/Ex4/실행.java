package Day19.Ex4;

public class 실행 {

	public static void main(String[] args) {
		
		// 1. 계산기 객체 생성
		Calculator calculator = new Calculator();		//	calculator 객체 32번지	
		
		// 2. 유저1 객체 생성
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);			//	calculator 객체 32번지
		user1Thread.start();
		
		// 3. 유저2 객체 생성
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);			//	calculator 객체 32번지
		user2Thread.start();
		
	}// main e
}// class e
