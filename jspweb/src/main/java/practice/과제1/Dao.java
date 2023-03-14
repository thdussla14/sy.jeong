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
	
	
	public boolean insert(Sdto sdto) {
		String sql = "insert into staff(sname,sclass,stype,fnum,edate,simg) values (?,?,?,(select fnum from field where fname=?),?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sdto.getSname());
			ps.setString(2, sdto.getSclass());
			ps.setString(3, sdto.getStype());
			ps.setString(4, sdto.getField());
			ps.setString(5, sdto.getEdate());
			ps.setString(6, sdto.getSimg());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public Sdto selectStaff(int sno) {
		String sql = "select s.sno ,s.sname, s.sclass , s.stype, f.fname ,  s.edate, s.simg, s.ddate, s.dcontent from staff s, field f where s.fnum = f.fnum and s.sno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sno);
			rs=ps.executeQuery();
			if(rs.next()) {
				Sdto sdto = new Sdto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				return sdto;
			}
		} catch (Exception e) {
			System.out.println(e);
		}return null;
	}
	
	public boolean updateStaff(Sdto sdto) {
		String sql = "update staff set sname=? , sclass=? , stype=? , fnum=(select fnum from field where fname=?) ,simg=? ,ddate=? , dcontent=? where sno =?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sdto.getSname());
			ps.setString(2, sdto.getSclass());
			ps.setString(3, sdto.getStype());
			ps.setString(4, sdto.getField());
			ps.setString(5, sdto.getSimg());
			ps.setString(6, sdto.getDdate());
			ps.setString(7, sdto.getDcontent());
			ps.setInt(8, sdto.getSno());
			int no = ps.executeUpdate();
			if(no==1) {
			return true;}
		} catch (Exception e) {
			System.out.println("여기"+e);
		}return false;
	}
	
	
	public ArrayList<Sdto> getStaff() {
		ArrayList<Sdto> list = new ArrayList<>();
		String sql = "select s.sno ,s.sname, s.sclass , s.stype, f.fname ,  s.edate, s.simg, s.ddate, s.dcontent from staff s, field f where s.fnum = f.fnum order by sno asc;";	
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
	
	public ArrayList<Sdto> seachStaff(String search) {
		ArrayList<Sdto> list = new ArrayList<>();
		String sql = "select s.sno ,s.sname, s.sclass , s.stype, f.fname ,s.edate, s.simg, s.ddate, s.dcontent from staff s, field f where s.fnum = f.fnum and s.sname like '%"+search+"%' order by sno asc;";	
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
	
	public ArrayList<Fdto> getfield() {
	       ArrayList<Fdto> list = new ArrayList<>();
	       String sql = "select f.fnum, fname, s.sname from field f, staff s where s.fnum=f.fnum and sclass='부장';";
	       try {
	         ps = con.prepareStatement(sql);
	         rs = ps.executeQuery();
	         while(rs.next()) {
	            Fdto fdto = new Fdto(rs.getInt(1), rs.getString(2), rs.getString(3));
	            list.add(fdto);            
	         }
	         return list;
	      }catch (Exception e) {System.out.println(e);}
	      return null;       
	   }
	
	
}
