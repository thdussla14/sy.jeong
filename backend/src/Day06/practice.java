package Day06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class practice {

	public static void main(String[] args) throws Exception {
		
		
		// 1. 입력 객체 생성
		Scanner scanner = new Scanner(System.in);
	
		while(true){
				
			System.out.println("메뉴> -1 : 쓰기   -2 : 나가기");
			int ch = scanner.nextInt();
				
			//  2-1. 쓰기 선택
			if(ch==-1)		
			{// 2-2. 데이터 입력받기/ 데이터 변수 선언/초기화
			System.out.println("---------------게시물 작성-----------------");	
			System.out.println("제목: ")	;  String title 	= scanner.next();
			System.out.println("내용: ")	;  String content	= scanner.next();
			System.out.println("작성자: ");  String writer	= scanner.next();
			System.out.println("비밀번호: "); String password	= scanner.next();
			
			// 2-3. 입력받은 데이터 배열 선언
			String outstr = title+","+content+","+writer+","+password+"\n";
			
			// 2-4. 윈도우 txt. 파일 처리 (누적)
			FileOutputStream fout = new FileOutputStream("c:/JAVA/board.txt", true);
			fout.write(outstr.getBytes());
	
			// 2-5. 윈도우 txt. 파일 불러오기
			FileInputStream fin = new FileInputStream("c:/JAVA/board.txt");
			
			// 2-6. 불러온 파일을 담을 배열 선언
			byte[] inbytes = new byte [1000];		
	
			// 2-7. 문자열 변환
			int bytecount = fin.read(inbytes);
			String fstr = new String(inbytes,0,bytecount);
	
			// 2-8. 출력
			System.out.println("---------------게시물-----------------");	
			System.out.printf("%1s %5s %5s","번호","제목","작성자\n");
			String[] rows = fstr.split("\n");
			for( int i=0 ; i<rows.length ; i++)
				{String[] cols = rows[i].split(",");
				String titlein 	= cols[0];
			    String contentin= cols[1];
			    String writerin	= cols[2];
			    String passwordin= cols[3];
				
			    System.out.printf("%1s %5s %5s \n",i+1,titlein, writerin);
	
				}
			
				
			}// 2-1. 나가기 선택	
			else if(ch==-2) { break; }	
			
		}	// while e		
	}	// main	
}	// class e
