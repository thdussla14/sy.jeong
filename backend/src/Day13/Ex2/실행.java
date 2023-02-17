package Day13.Ex2;

public class 실행 {

	public static void main(String[] args) {
		
		// - 인터페이스 상수 호출
		System.out.println("리모콘 최대 볼륨 : "+ RemoteControl.MAX_VOLUME);
		System.out.println("리모콘 최대 볼륨 : "+ RemoteControl.MIN_VOLUME);
		
		// 1. 인터페이스 변수 선언
		RemoteControl rc;
		
		// 2. 인터페이스[리코컨]에 구현 객체[Television] 연결
		rc = new Television();
		// 2-1. 구현 객체[Television]에 인터페이스 기능[메소드] 사용
		rc.turnOn();
		rc.setVolume(5);
		rc.setVolume(15);
		rc.turnOff();
		
		// 3. 인터페이스[리코컨]에 구현 객체[Audio] 연결
		rc = new Audio();
		// 3-1. 구현 객체[Audio]에 인터페이스 기능[메소드] 사용
		rc.turnOn();
		rc.setVolume(-10);
		rc.setVolume(5);
		rc.turnOff();
		
		// 4. 디폴트 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		// 5. 정적 메소드 호출
		RemoteControl.changeBattery();
		
	}// main e
	
}// class e
