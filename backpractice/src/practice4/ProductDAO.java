package practice4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {

	// 싱글톤
	private static ProductDAO dao = new ProductDAO();
	private ProductDAO () {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/연습","root","1234");
		}
		catch (Exception e) {System.out.println(e.getMessage());}
	}
	public static ProductDAO getInstance() {return dao;}
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 등록
	public boolean register(ProductDTO dto) {
		// 1. SQL 작성
		String sql = "insert into snack (pname,pprice,pstock) values (?,?,?)";
		try {
			// 2. SQL 대입
			ps = conn.prepareStatement(sql);
			// 3. 매개변수 대입
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.setInt(3, dto.getPstock());	
			// 4. SQL 실행
			ps.execute();	
			// 5. 결과 반환
			return true;
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		return false;
	}
	// 출력
	public ArrayList<ProductDTO> list() {
		// DB 레코드를 담기위한 ArrayList
		ArrayList<ProductDTO> list = new ArrayList<>();
		// 1. SQL 작성
		String sql = "select * from snack";
		try {
			// 2. SQL 대입
			ps = conn.prepareStatement(sql);
			// 4. SQL 실행 [ 결과를 받아보기 원할 경우 Query() ]
			rs = ps.executeQuery();			
			// DB 레코드를 ArrayList에 담기
			while(rs.next()) {
				ProductDTO dto = new ProductDTO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),0);
				list.add(dto);
			}// while e
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		// 5. 결과 반환
		return list;
	}
	// 수정
	public boolean update(ProductDTO dto) {
		// 1. SQL 작성
		String sql = "update snack set pname = ? , pprice = ? where pno = ? ";
		try {
			// 2. SQL 대입
			ps = conn.prepareStatement(sql);
			// 3. 매개변수 대입
			ps.setString(1, dto.getPname());
			ps.setInt	(2, dto.getPprice());
			ps.setInt	(3, dto.getPno());
			// 4. SQL 실행
			ps.execute();
			// 5. 결과 반환
			return true;
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		return false;
	}
	// 재고 수정
	public boolean stockUpdate(int pno,int pstock) {
		// 1. SQL 작성
		String sql = "update snack set pstock = ? where pno = ? ";
		try {
			// 2. SQL 대입
			ps = conn.prepareStatement(sql);
			// 3. 매개변수 대입
			ps.setInt(1, pstock);
			ps.setInt(2, pno);
			// 4. SQL 실행
			ps.execute();
			// 5. 결과 반환
			return true;
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		return false;
	}
	// 삭제
	public boolean delete(int pno) {
		// 1. SQL 작성
		String sql = "delete from snack where pno = ? ";
		try {
			// 2. SQL 대입
			ps = conn.prepareStatement(sql);
			// 3. 매개변수 대입
			ps.setInt(1, pno);
			// 4. SQL 실행
			ps.execute();
			// 5. 결과 반환
			return true;
		}
		catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		return false;
	}
	// 결제
	public boolean buy(ArrayList<ProductDTO> shoppingList) {
		int stock = 0;
		for(ProductDTO dto : shoppingList ) {
			try {
				// 1. SQL 작성
				String sql1 = "select pstock from snack where pno = ?";
				// 2. SQL 대입
				ps = conn.prepareStatement(sql1);
				// 3. 매개변수 대입
				ps.setInt(1, dto.getPno());
				// 4. SQL 실행
				rs = ps.executeQuery();		
				
				while(rs.next()) {stock = rs.getInt(1);}
				// 1. SQL 작성
				String sql2 = "update snack set pstock = ? where pno = ?";
				// 2. SQL 대입
				ps = conn.prepareStatement(sql2);
				// 3. 매개변수 대입
				ps.setInt(1,(stock-dto.getCount()));
				ps.setInt(2, dto.getPno());
				// 4. SQL 실행
				ps.execute();
				// 5. 결과 반환
				return true;
			}
			catch (Exception e) {System.out.println("[알림]"+e.getMessage());}
		}
		return false;
	}
	
	
}
