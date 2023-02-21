package Day15.Ex1;

public class 실행 {

	public static void main(String[] args) {
		
		// new 연산자를 사용할 떄마다 새로운 주소 할당
		Member obj1 = new Member("blue");
			System.out.println(obj1);		  	// Day15.Ex1.Member@6f2b958e
		Member obj2 = new Member("blue");
			System.out.println(obj2);		  	// Day15.Ex1.Member@5e91993f
		Member obj3 = new Member("red");
			System.out.println(obj3);		  	// Day15.Ex1.Member@1c4af82c
		
		// equals 는 값이 아닌 주소 비교 
		// Member 클래스에서 주소 번지 비교가 아닌 내부 값 비교로 equals 재정의 [ 오버라이딩 ]
		System.out.println(obj1.equals(obj2));	// false	// true
		System.out.println(obj1.equals(obj3));	// false	// false
		
		
		
	}// main e

}// class e
