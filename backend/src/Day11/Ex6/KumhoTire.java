package Day11.Ex6;

public class KumhoTire extends Tire {
	
	// 메소드 오버라이딩
	@Override
	public void roll() {
		System.out.println("금호타이어가 회전합니다.");
	}
	@Override
	public void stop() {
		System.out.println("금호타이어가 정지");
	}
}
