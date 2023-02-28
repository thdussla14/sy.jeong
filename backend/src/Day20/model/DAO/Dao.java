package Day20.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import 과제.과제11.Controller;

public class Dao {
	
	// 1. JDBC 인터페이스 3개
	Connection conn;		// DB 연동
	PreparedStatement ps;	// SQL 조작
	ResultSet rs;			// SQL 결과 조작
	
	public Dao () {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BoardDB","root","1234");
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	
	
	
}
