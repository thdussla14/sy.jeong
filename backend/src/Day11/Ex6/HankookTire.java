package Day11.Ex6;

public class HankookTire extends Tire{ // 하위클래스
			// 하위클래스명  extends 상위클래스명 
	// 메소드 오버라이딩 // 부모클래스의 메소드를 불러와 재정의
	@Override
	public void roll() {
		System.out.println("한국타이어가 회전합니다.");
	}
	@Override
		public void stop() {
		System.out.println("한국타이어가 정지");
	}
}
