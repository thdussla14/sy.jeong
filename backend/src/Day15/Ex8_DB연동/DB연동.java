package Day15.Ex8_DB연동;

// java.sql 패키지 사용!!!!!!!!!
// import java.sql * 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB연동 {

	//DriverManager.getConnection()		// * 해당 DB 주소와 연결 성공시 성공한 DB 구현 객체 반환 [** 예외처리 필수 **]
	private Connection conn;			// 1. DB 연결된 구현객체를 받아서 다양한 메소드 제공
	private PreparedStatement ps;		// 2. 연결된 SQL 조작 메소드 제공 [ ? 매개변수 사용 ] [** 예외처리 필수 **]
	private ResultSet rs;				// 3. SQL 결과 조작 메소드 제공	
	
	public DB연동() {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","1234");
			System.out.println("[연동 성공]");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public static void main(String[] args) {		
		DB연동 db연동 = new DB연동();
	}
	
	
}// class e

// 준비물
// 1. DB서버 주소 [ localhost vs 개인ip vs AWS ]
// 2. 해당 DB 서버의 계정
// 3. 해당 계정의 비밀번호
// 자바에서 DB 조작 클래스 및 인터페이스
// 1. DriverManager.getConnection("DB주소","계정","비밀번호");	
