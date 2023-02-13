package Day09.Ex8.pack2;

import Day09.Ex8.pack1.A;//

public class C {

	// 1. A 클래스가 pubic 일때
	A a0; // 가능 : 다른 패키지여도 import 하면 가능 
	
	// 2. A 클래스가 default 일때
	A a; // 불가능 : 같은 패키지만 가능
	
	A a1 = new A (true);	// public 가능
	//A a2 = new A(1);		// default 다른 패키지 불가능
	//A a3 = new A("문자열");	// private 무조건 다른 클래스 사용 불가능
	
	public static void main(String[] args) {
		A a4 = new A (true);
		a4.field1 = 10;		// public 가능
		//a4.field2 = 10;	// default 다른 패키지 불가능
		//a4.field3 = 10;	// private 무조건 다른 클래스 사용 불가능
	
	}//main e
}// class e
