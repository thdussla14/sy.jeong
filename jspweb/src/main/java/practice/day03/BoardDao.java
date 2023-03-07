package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static BoardDao dao = new BoardDao();
	private BoardDao() {
		try {
			// * [웹서버] : 해당 MYSQL 드라이버[라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");	// console 프로젝트는 사용x -> web 프로젝트는 필요!!!
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("DB연동성공");
		}catch (Exception e) {System.out.println("DB연동오류"+e);}
	}
	public static BoardDao getInstance() {return dao;}
	
	// 1. 등록
	public boolean onwrite(BoardDto dto) {
		String sql  = "insert into ex3 (bcontent, bwriter) values (?,?) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBcontent());
			ps.setString(2, dto.getBwriter());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 출력
	public ArrayList<BoardDto> onlist() {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select * from ex3";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4));
				list.add(dto);
			}
			return list;
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	// 3. 삭제
	public boolean onDelete(int bno) {
		String sql = "delete from ex3 where bno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 4. 수정
	public boolean onUpdate(int bno, String newContent) {
		String sql = "update ex3 set bcontent = ? where bno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newContent);
			ps.setInt(2, bno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
}
