package 과제.과제6.상속;

public class Tire {
	// 1. 필드
	public int maxRotation; 					// Tire 수명 : 최대 회전수
	public int accumulatedRotation; 			// Tire 현재 : 누적 회전수
	public String location;						// 바퀴 위치
	
	// 2. 생성자
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	// 3. 메소드
	public boolean roll() {												// Tire 회전 함수
		++accumulatedRotation;											// 누적 회전수 증가
		if( accumulatedRotation < maxRotation ) {						// 누적 회전수가 최대 회전수보다 작을때
			System.out.println( location + " Tire 수명 : " 				// "바퀴위치  타이어 수명 : 잔여 회전수" 출력
				+ (maxRotation-accumulatedRotation) + "회");
			return true; 
		}else {															// 누적회전수가 최대 회전수를 넘어설때
			System.out.println("*** " + location +" Tire 펑크 ***");		// "바퀴 위치 Tire 펑크" 출력
			return false; 
		}
	}
}