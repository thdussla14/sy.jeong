package Day14.Ex1;

public class Ex3_p477 {

	public static void findClass() throws Exception {
		Class.forName("java.lang.String2");	// 일반 예외
	}	
	
	public static void main(String[] args) throws Exception {
		try{
			findClass();
		}
		catch (Exception e) {

		}
		System.out.println("확인");
	}// main e
}// class e
/*
	예외 떠넘기기
	- 메소드 내부에서 예외 발생시 메소드 호출했던 곳으로 예외를 넘기기
	- throws
	- 메소드 마다 예외 처리하면 코드가 많아진다 -> 이동 후 한곳에서 처리

*/