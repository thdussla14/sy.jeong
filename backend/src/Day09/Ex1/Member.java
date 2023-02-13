/*
  클래스의 사용 용도
  1. 라이브러리 : 다른 클래스로부터 사용되는 클래스
   		협업에서 사용되는 디자인 패턴 : MVC
   		
  2. 실행클래스 : main 메소드를 가지고 있는 클래스
 
  JVM
  
  메소드 영역 		vs 스택 영역 			vs 힙 영역
  
  String		String name; - 변수
  				String name  - 변수	new String ("유재석") - 인스턴스
  
  클래스(필드)		지역변수				객체
  
  String name;
  String name = new String ("유재석")
  
 */

package Day09.Ex1;

public class Member {

	//클래스 멤버
	
	// 1. 필드
	String name;	// 초기값 null
	int num;		// 초기값 0
	double num2;	// 초기값 0.0
	boolean cheak;	// 초기값 false
	String[] array = new String[3]; // 초기값 null	 null null
	// 2. 생성자
	
	// 3. 메소드
	void setname() {
		String inputName;// 로컬변수
		System.out.println(name);
		//System.out.println(inputName);
	}
	
}// class e
