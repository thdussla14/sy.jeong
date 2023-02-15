package Day11.Ex4.pack1;

public class B {

	// 동일 패키지 접근 가능
	public void method() {		
		A a = new A();
		a.field = "value";
		a.method();
	}
}
