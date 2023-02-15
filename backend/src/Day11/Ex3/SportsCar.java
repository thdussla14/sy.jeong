package Day11.Ex3;

public class SportsCar extends Car{
	
	@Override
	public void speedUp() {
		super.speedUp();	// 부모 메소드 호출
	}
	
	/*  final : 오버라이딩 불가능
	 * @Override
	 *  public final void stop() { 
	 * 		System.out.println(" 차 멈춥니다. "); 
	 * 		speed = 0; 
	 * }
	 */
}
