package Day11.Ex4.pack2;

import Day11.Ex4.pack1.A;

public class D extends A{
// 다른 패키지이지만 A의 자식클래스이므로 A의 protected 필드,생성자,메소드 접근 가능
	public D () { }
	
	public void method1() {
		this.field = "value";
		super.field = "value";
		this.method();
		super.method();		
	}
	
/* 접근은 가능하나 new 연산자를 사용한 생성자 직접 호출 불가능
	public void method2() {
		A a = new A(); a.
		field = "value"; 
		a.method(); 
	}
	 	
 */
	
	
}
