package Day15.Ex3;

public class 실행 {

	public static void main(String[] args) {
		
		SmartPhone myphone = new SmartPhone("삼성전자", "안드로이드");
		
		System.out.println(myphone.toString());
		
		System.out.println(myphone); // print 함수의 경우 객체를 인수로 받으면 자동으로 toString 
		
	}// main e
	
}// class e
