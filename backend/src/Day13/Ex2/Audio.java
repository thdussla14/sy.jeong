package Day13.Ex2;

public class Audio implements RemoteControl{

	// 필드
	private int volume;
	
	// 추상 메소드 오버라이드 -------------------------------------------------------------------
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
		
	}
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
		
	}
	@Override
	public void setVolume(int volume) {
		
		if ( volume > RemoteControl.MAX_VOLUME) {		// 요청한 소음이 최대 소음보다 크면
			this.volume = RemoteControl.MAX_VOLUME; 	// 현재 소음에 최대 소음 대입
			System.out.println("최대 소음보다 커질 수 없습니다. 최대 소음 설정");
		}
		else if ( volume < RemoteControl.MIN_VOLUME) {	// 요청한 소음이 최대 소음보다 작으면
			this.volume = RemoteControl.MIN_VOLUME; 	// 현재 소음에 최소 소음 대입
			System.out.println("최소 소음보다 작아질 수 없습니다. 최소 소음 설정");
		}
		else { this.volume = volume; }
		
		System.out.println("현재 Audio 볼륨 : "+this.volume);
		
	}
	// 추가  ----------------------------------------------------------------------------
	private int memoryVolume ;  // 추가 필드 선언	

	// 디폴트 메소드 오버라이드 -----------------------------------------------------------------
	@Override
	public void setMute(boolean mute) {
		
		if(mute) {
			this.memoryVolume = this.volume;
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VOLUME);
		}
		else { 
			System.out.println("무음 해제합니다.");
			setVolume(memoryVolume);
		}
	}
	
}
