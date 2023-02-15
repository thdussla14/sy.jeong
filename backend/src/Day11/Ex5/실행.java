package Day11.Ex5;

public class 실행 {

	private void Example() {
		
		// 힙영역에 부모 객체 주소가 먼저 만들어지고 자식 객체 주소 생성 -> 자식은 부모 객체 주소를 안다!!
		
		// 1. 자식 객체 만들기
		Child child = new Child();
			child.name = "유재석";
			child.job = "방송인";

		//-------------------자동 변환---------------------------//
		// 2. 자식 객체를 부모 객체로 이동 [타입변환]
		Parent parent = child;
		
		// 3. 
		parent.method1();
		parent.method2();	// 부모 멤버인데 -> 자식이 오버라이딩한 메소드 사용
		//parent.method3(); // 자식 멤버 사용 불가
		
		System.out.println(parent.name);
		//System.out.println(parent.job); // 자식 멤버 사용 불가
		
		
		//-------------------강제 변환---------------------------//
		// 1. 부모 객체를 자식 객체로 이동
		Child child2 = (Child)parent;
		
		child2.method1();
		child2.method2();
		child2.method3();
		
		System.out.println(child2.name);
		System.out.println(child2.job);
		

		// 해당 객체의 타입을 모르는 경우 슈퍼클래스(object)에 담아둠
		// Object object =  child;
		// Member member = (Member) object;

		
		
	}// main e
	
}// class e
