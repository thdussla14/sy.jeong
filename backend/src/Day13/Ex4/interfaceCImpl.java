package Day13.Ex4;

public class interfaceCImpl implements C{

	// interfaceC가 상속받은 A,B의 추상 메소드
	@Override
	public void methodA() {
		System.out.println(" 메소드 A 실행 ");
		
	}
	@Override
	public void methodB() {
		System.out.println(" 메소드 B 실행 ");
		
	}
	// interfaceC 본인 추상 메소드 
	@Override
	public void methodC() {
		System.out.println(" 메소드 C 실행 ");
		
	}
}
