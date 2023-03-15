package model.Dao;

import java.sql.Statement;
import java.util.ArrayList;

import model.Dto.BoardDto;


public class BoardDao extends Dao{

	private static BoardDao dao = new BoardDao();
	private BoardDao () {	}
	public static BoardDao getInstance() { return dao;	}
	
	// 1. 게시물 등록
	public boolean bwrite(BoardDto bdto) {
		String sql = "insert into board (btitle,bcontent,bfile,mno,cno) values (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, bdto.getBtitle());
			ps.setString(2, bdto.getBcontent());
			ps.setString(3, bdto.getBfile());
			ps.setInt(4, bdto.getMno());
			ps.setInt(5, bdto.getCno());
			ps.executeUpdate();
			return true;
		}catch(Exception e) { System.out.println(e);}
		return false;
	}
	
	// 2. 게시물 출력
	public ArrayList<BoardDto> getBlist() {		
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select b.bno,b.btitle,b.bcontent,b.bfile,b.bdate,b.bview,b.blike,b.bhate,b.bno, b.cno, m.mid,c.cname from board b, member m, category c where b.mno = m.mno and b.cno = c.cno;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto bdto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12));
				list.add(bdto);				
			}
			return list;
		}catch(Exception e) { System.out.println(e);}
		return null;
	}
	
}
