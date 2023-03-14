package practice.과제1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Dao() {
		try {
			//해당 mysql 드라이버 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("연동성공");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Sdto> getStaff() {
		ArrayList<Sdto> list = new ArrayList<>();
		String sql = "select s.sno ,s.sname, s.sclass , s.stype, f.fname ,  s.edate, s.simg, s.ddate, s.dcontent from staff s, field f where s.fnum = f.fnum;";	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Sdto sdto = new Sdto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
									rs.getString(6),  rs.getString(7),  rs.getString(8),  rs.getString(9));
				list.add(sdto);				
			}
			return list;
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	public boolean deleteStaff(int sno) {
		String sql = "delete from staff where sno = ? ";	
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sno);
			int result = ps.executeUpdate();					// 업데이트한 레코드 개수 반환
			if( result == 1) {return true;}		
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	
	
	
	
}