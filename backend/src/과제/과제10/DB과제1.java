package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB과제1 {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		
		
		while(true) {
			
			try {
				System.out.println("1. DB연결 2. SQL 구문 작성 3. 매개변수 입력");
				int ch = scanner.nextInt();
				
				if (ch==1) {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB과제1","root","1234");
					System.out.println("[알림] DB 연동 성공");
				}
				else if(ch==2) { 
					System.out.println("--SQL 구문 입력");
					
					scanner.nextLine();
					String sql = scanner.nextLine();
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.execute();
				}
				else if(ch==3) { 
					System.out.println("--매개변수 입력");
					System.out.println("제품번호 : "); 	int 	pno 	 = scanner.nextInt();
					System.out.println("제품명 : ");  	String 	pname 	 = scanner.next();
					System.out.println("제품설명 : "); 	String 	pcontent = scanner.next();
					System.out.println("제품가격 : "); 	int 	price 	 = scanner.nextInt();
					
					String sql = "insert into product values (?,?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(sql);

					ps.setInt	(1, pno);
					ps.setString(2, pname);
					ps.setString(3, pcontent);
					ps.setInt	(4, price);
					
					ps.executeUpdate();
				}
				
			}
			catch (InputMismatchException e) {
				System.out.println("[알림] 알 수 없는 번호입니다.");
			}
			catch (SQLException e) {
				System.out.println("[알림] SQL 오류 "+e);
				scanner = new Scanner(System.in);	// 기존 입력 데이터 제거
			}
			catch (Exception e) {
				System.out.println("[알림] DB 연동 실패");
			}
			
			
		}// while e
		
	}// main e
	
}// class e
