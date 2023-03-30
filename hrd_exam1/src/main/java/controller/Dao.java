package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao{
	
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public static Connection getConnection() throws Exception{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection
					 ("jdbc:mysql://localhost:3306/X2","root","1234");
		return con;
		
	}
	
	public Dao()  {
		try {
			con = getConnection();
		}catch (Exception e) {System.out.println(e);}
	}

	
	// 마지막 회원번호 +1 가져오기
	public int getMno() {
		String sql = "select max(custno) from member_tbl_02";
		
		try {
			ps= con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}		
		}catch (Exception e) {System.out.println(e);}
		
		return 0;
	}
	
	// 회원 등록 
	public boolean signup(memberDto dto) {		
		String sql = "insert into member_tbl_02 (custname,phone,address,joindate,grade,city) values (?,?,?,?,?,?)";
	
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, dto.getCustname());
			ps.setString(2, dto.getPhone());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getJoindate());
			ps.setString(5, dto.getGrade());
			ps.setString(6, dto.getCity());
			ps.executeUpdate();
			return true;		
		}catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	// 모든 회원 목록 출력
	public ArrayList<memberDto> getMemberlist() {
			ArrayList<memberDto> list = new ArrayList<>();
			String sql = "select custno , custname ,  phone , address ,  joindate , "
					+ " if( grade = 'A' , 'VIP' , if( grade = 'B' , '일반' , '직원' ) ) as g , "
					+ " city from member_tbl_02;";
			try {
				ps = con.prepareStatement(sql); rs = ps.executeQuery();
				while(rs.next() ) {
					list.add( new memberDto( rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
				}
				return list;
			}catch (Exception e) {System.out.println(e);} ;
			return null;
		}

	// 특정 회원 출력
	public memberDto getMember(int custno) {
	
		String sql = "select * from member_tbl_02 where custno = "+custno;		
		try {
			ps= con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				memberDto dto = new memberDto(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7));
				return dto;
			}		
		}catch (Exception e) {System.out.println(e);}
		
		return null;
	}	

	// 회원정보 수정
	public boolean setMember(memberDto dto) {	
		String sql = "update member_tbl_02 set custno = ? , custname = ?, phone = ? , address = ? , joindate = ?, grade = ?, citywhere = ? ";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1, dto.getCustno());
			ps.setString(2, dto.getCustname());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getJoindate());
			ps.setString(6, dto.getGrade());
			ps.setString(7, dto.getCity());			
			ps.executeUpdate();
			return true;		
		}catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 매출현황 출력
	public ArrayList<memberDto> getSalelist() {
		
		ArrayList<memberDto> list = new ArrayList<>();	
		String sql = "select custno,custname,if( grade = 'A' , 'VIP' , if( grade = 'B' , '일반' , '직원' ) ) as g , sum(price) p from money_tbl_02 natural join member_tbl_02 group by custno order by p desc ";		
		try {
			ps= con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				memberDto dto = new memberDto(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4));
				list.add(dto);		
			}
			return list;
		}catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	
	
}