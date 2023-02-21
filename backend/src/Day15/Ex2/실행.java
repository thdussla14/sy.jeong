package Day15.Ex2;

public class 실행 {

	public static void main(String[] args) {
		
		System.out.println("자바".hashCode());	// 큰따옴표를 이용한 문자열 리터럴의 경우 문자열이 같으면 같은 객체 공유 
		System.out.println("자바".hashCode());	// 동일 주소 번지 출력 1631876
		System.out.println("자바".hashCode() == "자바".hashCode());

		Student s1 = new Student(1, "홍길동");
			System.out.println(s1);				// Day15.Ex2.Student@626b2d4a
		Student s2 = new Student(1, "홍길동");
			System.out.println(s2);				// Day15.Ex2.Student@5e91993f
		
		System.out.println(s1.hashCode());		// 1651191114
		System.out.println(s2.hashCode());		// 1586600255
		System.out.println(s1.hashCode() == s2.hashCode());
		System.out.println(s1.equals(s2));		
		
		
		
		
	}// main e
}// class e
