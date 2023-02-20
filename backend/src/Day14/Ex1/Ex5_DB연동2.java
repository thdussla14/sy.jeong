package Day14.Ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5_DB연동2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection conn = null; // 여러 if { }안에서 사용하려고 while 밖에 선언
		
		while(true) {
			
			try {// 1. 예외 발생 가능성이 높은 코드 [ 예상 : nextInt() 인데 문자열 입력시 예외 발생 ]
				System.out.println("1. DB연결 2. SQL 구문 삽입 3. 매개변수 구문 삽입 ");
				int ch  = scanner.nextInt();
				if (ch==1) {
					System.out.println("--연동할 DB명 입력 : "); 
					String dbname = scanner.next();
					System.out.println(dbname+"에 연결합니다.");
					// 입력받은 DB와 연결 
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname, "root", "1234");
					System.out.println("**연결 성공");
					
				}
				else if(ch==2) {
					System.out.println("--SQL 구문 입력 : ");
					scanner.nextLine();	// ** .nextLine(); 앞에 다른 .next() 있을때 오류 방지
					String sql = scanner.nextLine();				
					// 연결된 DB 객체에 SQL 대입 [ prepareStatement 매개변수 처리 ] 
					PreparedStatement ps = conn.prepareStatement(sql);
					// 실행
					ps.execute();
				}
				else if(ch==3) {
					System.out.println("번호 : ");	int mno = scanner.nextInt();
					System.out.println("아이디 : ");	String mid = scanner.next();
					System.out.println("비밀번호 : ");	String mpw = scanner.next();
					// sql 구문 작성	[ ? : 변수 대입 자리 ]
					String sql = "insert into member values (?,?,?);";
					PreparedStatement ps = conn.prepareStatement(sql);
					// 매개변수에 데이터 대입
					ps.setInt	(1, mno);	// 1. sql 구문 첫번쨰 ? 자리 대입
					ps.setString(2, mid);	// 2. sql 구문 두번쨰 ? 자리 대입
					ps.setString(3, mpw);	// 3. sql 구문 세번쨰 ? 자리 대입
					// 실행
					ps.executeUpdate();

				}
			}
			catch (InputMismatchException e) {
				System.out.println("[알림] 알 수 없는 번호입니다. ");
				scanner = new Scanner(System.in);	// 기존 입력 데이터 제거
			}
			catch (SQLException e) {
				System.out.println("[알림] SQL 오류 "+e);
				scanner = new Scanner(System.in);	// 기존 입력 데이터 제거
			}
			catch (Exception e) {
				System.out.println("[알림] DB연결 후 다시 실행");
			}
			
			
			
		}
		
		
		
		
		
	}// main e
}// class e
