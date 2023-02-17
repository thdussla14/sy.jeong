package Day13.Ex4;

public class 실행 {

	public static void main(String[] args) {
		
		// 1. 구현 객체 생성
		interfaceCImpl impl = new interfaceCImpl();
		
		// 2. 인터페이스 변수에 구현 객체 대입
		
		A ia = impl;
		ia.methodA();// 본인 추상메소드 호출 o
		//ia.methodB // 컴파일 오류 // 옆집 추상메소드 호출 x
		//ia.methodC // 컴파일 오류 // 자식 추상메소드 호출 x
		
		B ib = impl;
		//ia.methodA // 컴파일 오류 // 옆집 추상메소드 호출 x
		ib.methodB();// 본인 추상메소드 호출 o		
		//ia.methodC // 컴파일 오류 // 자식 추상메소드 호출 x
		
		C ic = impl;
		ic.methodA();// 부모 추상메소드 호출 o
		ic.methodB();// 부모 추상메소드 호출 o
		ic.methodC();// 본인 추상메소드 호출 o
		
		
	}// main e
	
}// class e
