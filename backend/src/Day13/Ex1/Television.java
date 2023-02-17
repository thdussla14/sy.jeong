package Day13.Ex1;

public class Television implements RemoteControl {
	
	// class 클래스명		implements 인터페이스명 
		// 인터페이스 안에 추상된 메소드를 해당 클래스가 구현
		// 필수 작업 : !! 추상메소드 구현
	
	// 1. 인터페이스 추상 메소드 구현
	@Override // !! 필수 !!
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

} // class e
