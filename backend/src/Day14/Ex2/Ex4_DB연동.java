package Day14.Ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex4_DB연동 {

	public static void main(String[] args) {
		
		try {// 1. 연결 인터페이스 
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java",		// java에서 DB생성 불가능 -> 워크밴치에서 DB생성 후 실행
					"root",
					"1234");
			System.out.println("[DB 연동 성공]");
		
			// 2. table 생성하는 sql 구문을 문자열 변수에 저장
			String sql = " create table member(mno int, mid varchar(20), mpw varchar(20))";
			
			// 3. 조작 인터페이스 (DML, DDL 사용가능)
			PreparedStatement ps = con.prepareStatement(sql);
			
			// 4. SQL 실행
			ps.execute();

			sql = " drop table member ";
			
			}
		catch (Exception e) {
			System.out.println("[DB 연동 실패] 사유 : "+e);
			}

		
	}// main e
	
}// class e
/*
	JDBC  : 자바와 DB 연결 드라이브
		- 해당 DBMS 마다 라이브러리 [.JAR] 파일 필요
		- 보관장소 : C://mysql-connector-j-8.0.32
		
	- 라이브러리 추가 
		1. 프로젝트 우클릭 -> build path -> configure build path
		2. libraries 탭에서 SE 버전변경
			JavaSE-17 -> JavaSE1.8 -> apply
		3. add external jars
		4. mysql-connector-j-8.0.32.jar 파일 찾아서 추가
		
	- DB 연동
		Connection		: DB 연결 인터페이스 다양한 객체 제공
		DriverManager	: DB 연결 클래스 구현 객체 제공
			1. DriverManager.getConnection( DB주소, 계정 , 비밀번호 );
				**  일반 예외 무조건 발생 -> 예외 처리 필수 
				- msql server주소 : jdbc:mysql://ip주소:port번호/DB명	
				- 로컬PC기준		: jdbc:mysql://localhost:3306/DB명	
				- mysql 워크벤치 DB명 	
				

	
	
*/