package Day13.Ex2;

public class Television implements RemoteControl{
	// 해당 클래스가 인터페이스에서 추상된 메소드를 구현하겠다.
	// 필수 : 오버라이딩 !!!!

	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}
	@Override
	public void setVolume(int volume) {
		
		if (volume > RemoteControl.MAX_VOLUME) {		// 요청한 소음이 최대 소음보다 크면
			this.volume = RemoteControl.MAX_VOLUME; 	// 현재 소음에 최대 소음 대입
			System.out.println("최대 소음보다 커질 수 없습니다. 최대 소음 설정");
		}
		else if (volume < RemoteControl.MIN_VOLUME) {	// 요청한 소음이 최대 소음보다 작으면
			this.volume = RemoteControl.MIN_VOLUME; 	// 현재 소음에 최소 소음 대입
			System.out.println("최소 소음보다 작아질 수 없습니다. 최소 소음 설정");
		}
		else { this.volume = volume; }
		
		System.out.println("현재 Television 볼륨 : "+this.volume);
		
	} // set e
	
}// class e
