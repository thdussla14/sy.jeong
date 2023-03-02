package jspweb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {

	private static Dao dao = new Dao();
	private Dao() {
		try {
			// * [웹서버] : 해당 MYSQL 드라이버[라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");	// console 프로젝트는 사용x -> web 프로젝트는 필요!!!
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("DB연동성공");
		}catch (Exception e) {System.out.println("DB연동오류"+e);}
	}
	public static Dao getInstance() {return dao;}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean setData(String data) {		
		String sql = "insert into ex1(e_data) values (?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	public ArrayList<String>getData() {		
		ArrayList<String> list = new ArrayList<>();		
		String sql = "select * from ex1";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	public boolean set(String data) {
		String sql = "insert into 과제1(indata) values (?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	public ArrayList<String> get() {
		ArrayList<String> list = new ArrayList<>();
		String sql = "select * from 과제1";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	
}
