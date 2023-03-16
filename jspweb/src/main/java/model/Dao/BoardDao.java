package model.Dao;

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
			ps = con.prepareStatement(sql);
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
	// 2-0. 전체 레코드 개수 
	public int totalsize(int cno,String key,String keyword) {
		String sql = "";
		if(key.equals("") && keyword.equals("")) {
			sql =  "select count(*) from board b, member m, category c where b.mno = m.mno and b.cno = c.cno and b.cno = "+cno+" order by b.bdate desc ;";
		}else {
			sql = "select count(*) from board b, member m, category c where b.mno = m.mno and b.cno = c.cno and b.cno = "+cno+" and "+key+" like '%"+keyword+"%' order by b.bdate desc ;";
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}			
		}catch(Exception e) { System.out.println(e);}
		return 0;
	}

	// 2-1. 전체 게시물 출력
	public ArrayList<BoardDto> getBlist(int cno,String key,String keyword,int startrow,int listsize) {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "";
		if(key.equals("") && keyword.equals("")) {
			sql = "select b.*, m.mid,c.cname from board b, member m, category c where b.mno = m.mno and b.cno = c.cno and b.cno = "+cno+" order by b.bdate desc limit "+startrow+","+listsize;
		}else {
			sql = "select b.*, m.mid,c.cname from board b, member m, category c where b.mno = m.mno and b.cno = c.cno and b.cno = "+cno+" and "+key+" like '%"+keyword+"%' order by b.bdate desc limit "+startrow+","+listsize;
		}
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
	// 3. 게시물 1개 출력
	public BoardDto selectBoard(int bno) {		
		String sql = "select b.*, m.mid,c.cname, m.mimg from board b, member m, category c where b.mno = m.mno and b.cno = c.cno and bno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				BoardDto bdto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13));
				return bdto;
			}			
		}catch(Exception e) { System.out.println(e);}
		return null;
	}
	// 3-1. 게시물 조회수/좋아요수/싫어요수 업데이트
	public boolean bIncrease(int type, int bno) {
		String sql = "";
			
		if (type == 1) {sql = "update board set bview = bview+1 where bno = "+bno;}
		if (type == 2) {sql = "update board set blike = blike+1 where bno = "+bno;}
		if (type == 3) {sql = "update board set bhate = bhate+1 where bno = "+bno;}
		
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) { System.out.println(e);}
		return false;
	}

	
	
	
}
