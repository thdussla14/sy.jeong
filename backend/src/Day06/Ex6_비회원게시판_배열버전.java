package Day06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex6_비회원게시판_배열버전 {

	
	public static void main(String[] args) throws Exception{
		
	
		Scanner scanner = new Scanner(System.in);	
		

		
		while(true)
		{
		// 1. 파일 입력 클래스 객체 생성 (파일 경로)
		FileInputStream fin = new FileInputStream("c:/JAVA/board.txt");	
		// 2. 읽어온 바이트를 저장하기 위해 바이트 배열 1000 바이트 미리 생성
		byte[] inbytes = new byte [1000];
		// 3. .read() 메소드를 이용한 파일 읽기
			// inbytes 		: 읽어온 바이트를 배열에 저장
			// bytecount	: 읽어온 바이트의 개수를 변수에 저장
		int bytecount  = fin.read(inbytes);							
		// 4. 바이트 배열 -> 문자열
			// new String ("유재석");
			// new String ( 바이트배열 ); new String( 바이트배열, 시작인덱스, 마지막인덱스 )
		String fstr = new String(inbytes, 0 , bytecount);
		
		// fstr = "안녕,안냐세요,강호동,4567\n안녕,안냐세요,강호동,4567"
				
		String boardlist = new String (inbytes);	
		// 행 기준 자르기
		String[] boards = fstr.split("\n");// 행 기준 분리 게시글 2개 => 3조각..
		
		// board = {"안녕,안냐세요,강호동,4567","안녕,안냐세요,강호동,4567"}
		System.out.println("-----------------게시판------------------");
		System.out.printf("%1s\t %3s\t %5s\n","번호"," 제목","작성자","조회수");		
		// 열 기준 자르기 
		for ( int i=0 ; i<boards.length ; i++)
			{String[] cols = boards[i].split(",");
			String title 	= cols[0];
			String content	= cols[1];
			String writer	= cols[2];
			String password	= cols[2];
			
			System.out.printf("%1s\t %3s\t %5s\n",i,title, writer );
		}
		
		
		// cols = {"안녕","안냐세요","강호동","4567"}

		// 쓰기 페이지 실행되는 조건
			
		System.out.println("메뉴> 게시물상세보기[번호] -1 : 쓰기 -2 : 나가기 ");
		int ch = scanner.nextInt();
		if(ch==-1)
		{System.out.println("-----------------게시물 작성------------------");
		System.out.println("제목: ");		String title 	= scanner.next();
		System.out.println("작성자: ");	String writer	= scanner.next();
		System.out.println("내용: ");		String content	= scanner.next();
		System.out.println("비밀번호: ");	String password = scanner.next();
		
		//  , : 열 구분선 		\n : 행구분선
		String outstr = title + "," + content + "," + writer + "," + password +"\n";
		
		// 파일처리 객체 생성("파일경로","true"); // 최초 txt 파일 생성 이후 true 작성 
		FileOutputStream fout = new FileOutputStream("c:/JAVA/board.txt", true);
		fout.write(outstr.getBytes());

		}
		else if(ch==-2)	{ break ; }
	
		} //while e
	}// main e	
}//class e
