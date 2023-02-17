package Day13.Ex2;

public interface RemoteControl {
	
	// 상수 필드 [ 인터페이스 변수 x ]
		// 생성자 X = new 사용 불가 = 객체 x = 인스턴스 멤버 x => static 멤버만 가능
		// 상수 : static final // 고정된 값 -> 초기값 필수 :  변수 선언시 값 대입!!
		// 인터페이스에서는 무조건 상수이므로 생략
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0; // 자동으로 public static final
	
	// 추상 메소드
		// 리턴타입, 메소드명, 매개변수 만 선언 !!
		// 해당 클래스들이 implements 했을때 -> 오버라이딩 필수!
	// 1. 
	public abstract void turnOn();	// { } 구현부 x
	void turnOff();					// public abstract 생략 가능
	void setVolume(int volume);
	
	// 디폴트 인스턴스 메소드
		// 클래스에서 사용하는 메소드와 동일
		// 선언부 앞에 default 선언
		// 해당 클래스들이 implements 했을때 -> 오버라이딩 필수 x
	// 2.
	default void setMute(boolean mute){
		if(mute) {
			System.out.println(" 무음 처리합니다.");
			setVolume(MIN_VOLUME);
		}
		else {System.out.println(" 무음 해제합니다."); }
	}
	
	// 정적 메소드
		// 구현 객체 필요 x => implements 없이 가능
		// static 선언
		// implements x 사용 가능
	// 3. 
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}
	
	
}
