package 과제.과제6.상속;

public class KumhoTire extends Tire {
	
	
	public KumhoTire(int maxRotation, String location) {
		super(maxRotation, location); // Tire 부모 클래스 상속
	}
	
	// 부모클래스 roll 상속 변형 x
	@Override
	public boolean roll() {													// Tire 회전 함수
		++accumulatedRotation;												// 누적 회전수 증가
		if( accumulatedRotation < maxRotation ) { 							// 누적 회전수가 최대 회전수보다 작을때
			System.out.println( location + " KumhoTire 수명 : " 				// "바퀴위치  타이어 수명 : 잔여 회전수" 출력
				+ (maxRotation-accumulatedRotation) + "회");
			return true; 
		}else {																// 누적회전수가 최대 회전수를 넘어설때
			System.out.println("*** " + location +" KumhoTire 펑크 ***");		// "바퀴위치 Tire 펑크" 출력
			return false; 
		}
	}
}
