package Day13.Ex6;

import java.util.Scanner;

public class 실행 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		키보드 key = null ; // 변수 선언
		
		while(true) {
			
			// 구현 객체 선택
			System.out.println("----바탕화면----");
			System.out.println("1. 피파온라인");
			System.out.println("2. 메이플스토리");
			System.out.println("선택 : ");
			
			// 입력한 번호의 구현 객체를 대입
			int ch = scanner.nextInt();
			if(ch == 1) { key = new 피파온라인();}
			else if(ch == 2) { 
				key = new 메이플스토리(); 
				System.out.println(" 1. 마법사 2. 전사 ");
				int 입력2 = scanner.nextInt();
				if( 입력2 == 1) {key = new 마법사();}
				else if(입력2 ==2) {key = new 전사();}
				}
			
			// 실제 게임 시작
			System.out.println(" 게임시작 ~~~~ ");
			while(true) {				
				String 입력 = scanner.next();
				if(입력.equals("A")) {
					key.A버튼();
				}
				else if(입력.equals("B")) {
					key.B버튼();
				}
				else if(입력.equals("E")) {
					break;
				}
				
			}// while2 e

		}// while e
		
	} // main e
	
} // class e
