package 과제.과제9;

import java.util.Scanner;

import 과제.과제9.인터페이스1.Daum;
import 과제.과제9.인터페이스1.Google;
import 과제.과제9.인터페이스1.Naver;
import 과제.과제9.인터페이스1.Search;
import 과제.과제9.인터페이스2.Contact;
import 과제.과제9.인터페이스2.KakaoTalk;
import 과제.과제9.인터페이스2.Mail;
import 과제.과제9.인터페이스2.Message;
import 과제.과제9.인터페이스3.Record;
import 과제.과제9.인터페이스3.메모장;
import 과제.과제9.인터페이스3.워드;
import 과제.과제9.인터페이스3.한글과컴퓨터;
import 과제.과제9.인터페이스4.Bluetooth;
import 과제.과제9.인터페이스4.CellPhone;
import 과제.과제9.인터페이스4.Watch;
import 과제.과제9.인터페이스4.WirelessEarphone;

public class 인터페이스_실행 {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		// 인터페이스 예제 1) ----------------------------------------------------------------------------------//
		
		Search search = null;
		
		while(true) { // 무한루프 [ 종료조건 : 4. 예제2 ]
			
			// 구현 객체 선택 
			System.out.println("----------검색----------");
			System.out.println(" 1. Google");
			System.out.println(" 2. Naver");
			System.out.println(" 3. Daum");
			System.out.println(" 4. 인터페이스 예제2");
			System.out.println("선택 : ");
			
			// 입력한 번호의 구현 객체를 대입
			int ch = scanner.nextInt();
			if(ch == 1) 	{ search = new Google();}
			else if(ch == 2){ search = new Naver(); }
			else if(ch == 3){ search = new Daum(); }
			else if(ch == 4){ break;  }
			
			// 메소드 실행
			System.out.println("검색어 : ");
			String content = scanner.next();
			search.input(content);
			System.out.println("-----------------------");
			search.output(content);

			
		}// while e
		
		// 인터페이스 예제 2) ----------------------------------------------------------------------------------//		
		
		Contact contact = null;
		
		while(true) { // 무한루프 [ 종료조건 : 4. 예제3 ]
			
			// 구현 객체 선택 
			System.out.println("----------연락----------");
			System.out.println(" 1. Mail");
			System.out.println(" 2. Message");
			System.out.println(" 3. KakaoTalk");
			System.out.println(" 4. 인터페이스 예제3");
			System.out.println("선택 : ");
			
			// 입력한 번호의 구현 객체를 대입
			int ch = scanner.nextInt();
			if(ch == 1) 	{ contact = new Mail();}
			else if(ch == 2){ contact = new Message(); }
			else if(ch == 3){ contact = new KakaoTalk(); }
			else if(ch == 4){ break;  }
			
			// 메소드 실행
			System.out.println("-----------------------");
			System.out.println("보낼 내용 : ");
			String content = scanner.next();
			contact.Send();
			System.out.println("-----------------------");
			contact.REceive(content);
			System.out.println("-----------------------");
			
		}// while e
		
		// 인터페이스 예제 3) ----------------------------------------------------------------------------------//
		
		Record record = null ;
		
		while(true) { // 무한루프 [ 종료조건 : 4. 예제4 ]
			
			// 구현 객체 선택 
			System.out.println("----------기록----------");
			System.out.println(" 1. 메모장");
			System.out.println(" 2. 한글과 컴퓨터");
			System.out.println(" 3. 워드");
			System.out.println(" 4. 인터페이스 예제4");
			System.out.println("선택 : ");
			
			// 입력한 번호의 구현 객체를 대입
			int ch = scanner.nextInt();
			if(ch == 1) 	{ record = new 메모장();}
			else if(ch == 2){ record = new 한글과컴퓨터(); }
			else if(ch == 3){ record = new 워드(); }
			else if(ch == 4){ break;  }
			
			// 메소드 실행
			System.out.println("-----------------------");
			record.write();
			System.out.println("내용 : ");
			String content = scanner.next();
			System.out.println("-----------------------");
			record.save();
			System.out.println("-----------------------");
			record.view(content);
			
			
		}// while e
		
		// 인터페이스 예제 4) ----------------------------------------------------------------------------------//
		
		Bluetooth bluetooth = null ;
		
		while(true) { // 무한루프 [ 종료조건 : 4. 종료 ]
			
			// 구현 객체 선택 
			System.out.println("--------무선연결--------");
			System.out.println(" 1. 핸드폰");
			System.out.println(" 2. 무선이어폰");
			System.out.println(" 3. 워치");
			System.out.println("선택 : ");
			
			// 입력한 번호의 구현 객체를 대입
			int ch = scanner.nextInt();
			if(ch == 1) 	{ bluetooth = new CellPhone();}
			else if(ch == 2){ bluetooth = new WirelessEarphone(); }
			else if(ch == 3){ bluetooth = new Watch(); }
			else if(ch == 4){ break;  }
			
			// 메소드 실행
			System.out.println("-----------------------");
			bluetooth.Pairing();
			System.out.println("-----------------------");
			System.out.println(" [배터리 부족] 충전이 필요합니다. ");
			System.out.println("-----------------------");
			bluetooth.disconnect();
			
			
		}// while e

		
	}// main e
}// class e
