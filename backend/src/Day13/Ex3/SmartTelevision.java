package Day13.Ex3;

public class SmartTelevision implements RemoteControl, Searchable {
			// 다중인터페이스 : 클래스명 implements 인터페이스명1, 인터페이스명2
	
	// RemoteControl 추상 메소드 구현 ( 오버라이딩 ) 
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}
	// Searchable 추상 메소드 구현 ( 오버라이딩 ) 
	@Override
	public void search(String url) {
		System.out.println(url+"을 검색합니다.");
		
	}
}
