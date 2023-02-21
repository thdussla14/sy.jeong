package Day15.Ex9_MVC패턴;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	
	// * 싱클톤 : DAO 싱클톤 사용하는 이유 : 프로그램내 DB 연동 1번만 해서 하나의 연동 객체 사용	
		// 1. 내부에 객체 만들기
	private static MemberDAO dao = new MemberDAO();
		// 2. 생성자는 private -> 외부에서 new 사용금지
		// 3. 외부에서 내부객체를 사용할 수 있게 내부 객체 반환 메소드 [getInstance]
	public static MemberDAO getInstance() {	return dao; }

	// 1. 필드
	private Connection conn;		// 1. 연결된 DB 구현 객체를 가지고 있는 인터페이스
	private PreparedStatement ps;	// 2. 연결된 SQl 조작 [+매개변수 기능] 인터페이스
	private ResultSet rs;			// 3. 실행된 SQL 결과 인터페이스 
	
	// 2. 생성자 [ 연동코드 -> 객체 생성시 바로 연동 가능하게 하려고 ] 
	private MemberDAO() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15","root","1234");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 3. SQL 처리 메소드
	// 회원가입 메소드 [ 인수 : DTO(mid,mpw), 반환 : 성공[true], 실패 [false] ]---------------------------------
	public boolean signup (MemberDTO dto ) {		
		// 1. SQL 작성 
		String sql = "insert into member (mid, mpw) values (?,?)";		
		try {	
			// 2. 연동 DB에 SQL 대입 [ ps -> 매개변수 조작 가능 ]
			ps = conn.prepareStatement(sql);
			// 3. ? 매개변수 대입
			ps.setString(1,dto.getMid());
			ps.setString(2,dto.getMpw());
			// 4. SQL 실행
			ps.executeUpdate();
			// 5. 결과 반환
			return true;	
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false; // try { } 문제 발생시 실행되는 구역 -> 저장 실패
	}
	// -------------------------------------------------------------------------------------------
	// 모든 회원 출력 [ 인수 :  x , 반환 : 여러명 회원 [ArrayList]]
	public ArrayList<MemberDTO> list( ) {
		
		
		// 반복문을 돌려서 DAO에 각 member 레코드 저장 
		String sql = "select * from member where mno = i";
		try {
			ps.getConnection().prepareStatement(sql);
			
			ps.execute(); 
			
			rs.next();
			
			MemberDTO dto = new MemberDTO();
			dto.setMno(0);
			dto.setMid(null);
			dto.setMpw(null);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	// -------------------------------------------------------------------------------------------
	public boolean update(MemberDTO dto) {
		
		
		return false;
	}
	// -------------------------------------------------------------------------------------------
	public boolean delete(int mno) {
		
		
		return false;
	}
}
