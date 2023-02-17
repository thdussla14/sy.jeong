package Day13.Ex1;

public class 실행 {
	
	public static void main(String[] args) {
		
		// 1. 인터페이스를 사용하는 구현 객체
			// 1. 인터페이스는 타입이므로 변수처럼 사용 가능
				// RemoteControl control1 = new RemoteControl;
			// 2. 참조하지 않고 있는 변수는 null 대입
				RemoteControl control = null;
			// 3. 해당 인터페이스를 implements 선언한 객체의 주소 대입 O
				RemoteControl control1 = new Television();
			// 4. 해당 인터페이스를 implements 선언하지 않은 객체의 주소 대입 X
				// RemoteControl control2 = new Audio();
		
		// 2. 구현 객체 만들기
	    RemoteControl rc1 = new Television(); // 힙 영역에 객체 선언과 동시에 변수 생성해 주소 저장
		RemoteControl rc2;		// 스택 영역 변수 선언
		rc2 = new Television();	// new Television(); => 힙 영역에 객체 선언 
								// rc 스택 영역에 주소 대입
		
		// 3. 구현 객체를 이용한 메소드 실행
		rc1.turnOn();
		rc2.turnOn();
		
		// 일회성 사용의 경우 이름 없이 바로 호출
		new Television().turnOn();
		
		// 4. 리모콘 교체
		rc1 = new Audio();
		rc1.turnOn();
		
	}// main e
	
}//class e
