package 과제.과제9.클래스_상속3;

public class Rose extends Flower{

	@Override
	public void color() {
		System.out.println(" 장미의 대표색은 빨강이다. ");
	}
	@Override
	public void floriography() {
		System.out.println(" 장미의 꽃말은 [사랑과 존경] 이다. ");
	}
	
}
