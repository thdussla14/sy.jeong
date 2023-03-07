package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static ProductDao dao = new ProductDao();
	private ProductDao() {
		try {
			// * [웹서버] : 해당 MYSQL 드라이버[라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");	// console 프로젝트는 사용x -> web 프로젝트는 필요!!!
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb","root","1234");
			System.out.println("DB연동성공");
		}catch (Exception e) {System.out.println("DB연동오류"+e);}
	}
	public static ProductDao getInstance() {return dao;}
	
	public boolean register(ProductDto dto) {
		String sql  = "insert into  product (pname, price) values (?,?) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,dto.getPname() );
			ps.setInt(2, dto.getPrice());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	public ArrayList<ProductDto> print() {
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql  = "select * from product";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(dto);
			}
			return list;
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	public boolean ondelete(int pno) {
		String sql  = "delete from product where pno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	public boolean onupdate(ProductDto dto) {
		String sql  = "update product set pname= ? , price = ?  where pno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,dto.getPname() );
			ps.setInt(2, dto.getPrice());
			ps.setInt(3, dto.getPno());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
}
