package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	private static DAO dao = new DAO();
	private DAO () {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/과제11","root","1234");
		}
		catch (Exception e) {
			System.out.println("[알림]"+e.getMessage());
		}
	}
	public static DAO getInsetance() {return dao;}
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public boolean register(DTO dto) {		
		String sql = "insert into Icecream (pname,price,storage) values (?,?,?)";
		try {
			ps = conn.prepareStatement(sql);			
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPrice());
			ps.setInt(3, dto.getStorage());			
			ps.execute();		
			return true;
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		return false;
	}
	public ArrayList<DTO> list() {
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select * from Icecream";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();			
			while(rs.next()) {
				DTO dto = new DTO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				list.add(dto);
			}// while e
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		return list;
	}
	public boolean update(DTO dto) {
		
		String sql = "update Icecream set pname = ? , price = ? where pno = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPrice());
			ps.setInt(3, dto.getPno());
			ps.execute();
			return true;
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		return false;
	}
	public boolean storage_update(int pno,int stock) {
		String sql = "update Icecream set storage = ? where pno = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setInt(2, pno);
			ps.execute();
			return true;
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		return false;	
	}
	public boolean delete(int pno) {
		String sql = "delete from Icecream where pno = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.execute();
			return true;
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		return false;		
	}
	public boolean sale(ArrayList<DTO> wishlist) {
		
		for(DTO dto : wishlist) {
			int stock = 0;
			String sql1 = "select storage from Icecream where pno = ?";
			String sql2 = "update Icecream set storage = ? where pno = ?";
			try {			
				ps = conn.prepareStatement(sql1);
				ps.setInt(1, dto.getPno());
				rs = ps.executeQuery();				
				while(rs.next()) {stock = rs.getInt(1);}						
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, (stock-1));
				ps.setInt(2, dto.getPno());
				ps.execute();				
			}
			catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		}
		return true;
	}
	
	
	
}
