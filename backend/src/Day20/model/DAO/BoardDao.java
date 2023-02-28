package Day20.model.DAO;

import java.util.ArrayList;

import Day20.model.DTO.BoardDto;
import Day20.model.DTO.CategoryDto;

public class BoardDao extends Dao {
	
	// 1. 싱글톤
	private static BoardDao bdao = new BoardDao();
	private BoardDao() { }
	public static BoardDao getInstance() {return bdao;}
	
	
	// 2. 카테고리 추가
	public boolean categoryAdd(String cname) {
		String sql = "insert into category (cname) values (?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println(e);}
		
		return false;
	}
	// 3. 모든 카테고리 호출
	public ArrayList<CategoryDto> categoryPrint() {
		
		ArrayList<CategoryDto> clist = new ArrayList<>();
		String sql = "select * from category ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CategoryDto cDto = new CategoryDto(rs.getInt(1), rs.getString(2));
				clist.add(cDto);
			}
			return clist;
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	// 4. 게시물 등록
	public boolean boardAdd(String btitle, String bcontent,int mno, int cno) {
		String sql = "insert into board (btitle,bcontent,mno_fk,cno_fk) values (?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,btitle );
			ps.setString(2,bcontent );
			ps.setInt(3,mno );
			ps.setInt(4,cno );
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
	// 5. 최신 게시물 3개 출력
	public ArrayList<BoardDto> boardprintRecent() {
		ArrayList<BoardDto> brlist = new ArrayList<>();
		String sql = "select b.bno, b.btitle, b.bcontent,b.bdate,b.bview,m.mname,c.cname from board b,member m, category c"
					+ "	where b.mno_fk = m.mno and b.cno_fk = c.cno"
					+ " order by b.bdate desc limit 3; ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto bDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getString(6), rs.getString(7));
				brlist.add(bDto);
			}
			return brlist;
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	// 6. 해당 카테고리 모든 게시물 출력
	public ArrayList<BoardDto> boardprint(int cno) {
		ArrayList<BoardDto> blist = new ArrayList<>();
		String sql = "select b.bno, b.btitle, b.bcontent,b.bdate,b.bview,m.mname,c.cname from board b,member m, category c"
				+ "	where b.mno_fk = m.mno and b.cno_fk = c.cno and b.cno_fk = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto bDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getString(6), rs.getString(7));
				blist.add(bDto);
			}
			return blist;
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}

	// 7. 해당 게시물 출력
	
	
	
	
	
}
