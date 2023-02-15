package Day11.Ex2;

public class Computer extends Calculator{

	@Override
	public double areaCircle(double r) {// 함수 이름과 매개변수 변경 X => 변경되면 오버라이딩이 아닌 오버로딩이 되어버림
		System.out.println(" 자식 객체가 재정의 ");
		return Math.PI*r*r;
	}
}
