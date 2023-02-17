package Day13.Ex3;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 구현 객체 
		RemoteControl rc = new SmartTelevision();
		
		rc.turnOn();
		rc.turnOff();
		rc.search("YOUTUBE");   // 컴파일 오류 // RemoteControl 에는 search 함수 x
								// but RemoteControl이 Searchable 상속 받으면 자식은 부모의 추상 함수 사용 가능 o
		
		// 2. 구현 객체 2
		Searchable sc = new SmartTelevision();
		
		sc.search("YOUTUBE");
		// sc.turnOn();			// 컴파일 오류 // Searchable 에는 turnOn 함수 x
								// but RemoteControl이 Searchable 상속 받아도 부모는 자식의 추상 함수 사용 x
								// 부모는 자식인지 확인하기 위해 instanceOf로 확인 
		
	}// main e
}// class e
