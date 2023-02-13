package Day09.Ex9;

public class 실행 {

	public static void main(String[] args) {
		
		// 1. 생성자가 private라서 객체 생성 불가능
		// Member member = new Member();
		// 2. 객체 없이 메소드 [ static ] 호출
		Member m1 = Member.getInstance();
		Member m2 = Member.getInstance();
		
		System.out.println(m1); //Day09.Ex9.Member@49e4cb85
		System.out.println(m2); //Day09.Ex9.Member@49e4cb85
		
	}// main e
	
}// class e
