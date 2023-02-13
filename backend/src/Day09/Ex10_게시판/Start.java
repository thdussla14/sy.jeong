package Day09.Ex10_게시판;

import Day09.Ex10_게시판.view.Front;

/*
	Ex10_게시판 패키지
		controller 패키지
			Bcontoller.java
		model 패키지
			Board.java
		view 패키지
			Front.java
		Start.java

	1. Start [main 함수] 클래스가 front 클래스 호출
	2. Front 클래스에서 사용자로부터 입 출력 받기
	3. Bcontroller 클래스에서 front로부터 전달받은 데이터를 처리/로직
	4. Board 클래스에서 게시물의 모델링

*/

public class Start {

	public static void main(String[] args) {
		
		// 1-1. 싱글톤 객체 사용하지 않은 경우
		//Front front = new front();
		//front.index();
		
		// 1-2. Front 싱글톤 사용한 경우
		Front.getInstance().index();
		
		
	}// main e
}// class e
