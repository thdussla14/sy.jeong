package Day09.Ex8.pack1;

public class B {

	A a; 					// 가능 : 같은 패키지여서 import 안해도 가능	
	A a1 = new A (true);	// public 가능
	A a2 = new A(1);		// default 같은 패키지까지 가능
	//A a3 = new A("문자열");	// private 무조건 다른 클래스 사용 불가능
	
	public static void main(String[] args) {
		A a4 = new A (true);
		a4.field1 = 10;		// public 가능
		a4.field2 = 10;		// default 같은 패키지까지 가능
		//a4.field3 = 10;	// private 무조건 다른 클래스 사용 불가능
	}
}
