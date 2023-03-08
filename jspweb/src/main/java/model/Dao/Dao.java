package model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;

	public Dao() {
		try {
			// * [웹서버] : 해당 MYSQL 드라이버[라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");	// console 프로젝트는 사용x -> web 프로젝트는 필요!!!
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("DB연동성공");
		}catch (Exception e) {System.out.println("DB연동오류"+e);}
	}

}
