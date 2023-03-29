package model.Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Dto.NoteDto;
import model.Dto.ProductDto;

public class ProductDao extends Dao{

	private static ProductDao dao = new ProductDao();
	private ProductDao() {};
	public static ProductDao getInstantce() {
		return dao;
	}
	// synchronized 스레드1 해당메소드 리턴 전까지 다른 요청 대기  
	// 1. 제품 등록
	public synchronized boolean register(ProductDto dto) {		
		String sql = "insert into product (pname,pcontent,pprice,plat,plng,mno) values (?,?,?,?,?,?)";		
		try {
			// insert 후 생성된 제품의 pk 번호 가져오기 
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcontent());
			ps.setInt(3, dto.getPprice());
			ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());
			ps.setInt(6, dto.getMno());
			ps.executeUpdate();
			// insert 후 생성된 제품의 pk 번호 가져오기 => 제품 사진 테이블에 등록 
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				for(String pimg_name : dto.getPimglist()) {
					sql = "insert into pimg (pimg_name , pno) values (?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1,pimg_name); ps.setInt(2, rs.getInt(1));
					ps.executeUpdate();					
				}
				return true;
			}			
		}catch (Exception e) {System.out.println(e);}
		return false;	
	}
	
	// 2. 제품 출력 
	public synchronized ArrayList<ProductDto> getPlist(String 동,String 서,String 남,String 북 ) {		
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select p.*, m.mid, m.mimg from product p natural join member m where plng between ? and ? and plat between ? and ? ; ";	
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, 서);
			ps.setString(2, 동);
			ps.setString(3, 남);
			ps.setString(4, 북);
			rs = ps.executeQuery();
			while(rs.next()) {				
				ArrayList<String> pimgList = new ArrayList<>();
				sql = "select * from pimg where pno = "+rs.getInt(1);
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				while(rs2.next()) {
					pimgList.add(rs2.getString(2));
				}				
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), 
						rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), pimgList);

				list.add(dto);				
			}
			return list;
		}catch (Exception e) {System.out.println(e);}
		return null;	
	}
	
	// 3. 찜하기 등록 / 취소
	public synchronized boolean setplike(int pno, int mno) {
		// 찜하기 여부 확인 
		String sql = "select * from plike where pno = "+pno+" and mno = "+mno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// 찜하기 있으면 => 취소 
			if(rs.next()){
				sql = "delete from plike where pno = "+pno+" and mno = "+mno;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return false;
			}else { // 찜하기 없으면 등록 => 등록
				sql = "insert into plike (pno,mno) values ("+pno+","+mno+")";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			}	
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 4. 로그인한 회원의 해당 찜하기 상태 확인	
	public synchronized boolean getplike(int pno, int mno) {
		String sql = "select * from plike where pno = "+pno+" and mno = "+mno;			
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){return true;}					
		}catch (Exception e) {System.out.println(e);}
			return false;
	}
	
	// 5. 쪽지 저장
	public synchronized boolean setnote(NoteDto dto) {
		String sql = "insert into note (ncontent,pno,frommno,tomno) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getNcontent());
			ps.setInt(2, dto.getPno());
			ps.setInt(3, dto.getFrommno());
			ps.setInt(4, dto.getTomno());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 6. 쪽지 출력
	public synchronized ArrayList<NoteDto> getnotelist(int pno, int mno, int chatmno) {
		ArrayList<NoteDto> list = new ArrayList<>();
		String sql = null;
			if(chatmno == 0) { // 전체 채팅목록 출력
				sql = "select n.*,  m.mimg, m.mid from note n , member m  where n.frommno = m.mno and pno = "+pno+" and (frommno = "+mno+" or tomno = "+mno+") ";
			}else { // 현재 같이 채팅하고 있는 대상자들의 내용물만 출력
				sql = "select n.*,  m.mimg, m.mid from note n , member m  where n.frommno = m.mno and pno = "+pno
						+ " and ( ( frommno = "+mno+" and tomno = "+chatmno+" )  or  ( frommno =  "+chatmno+"  and tomno = "+mno+" ) ) ;";
			}
		try {
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while(rs.next()) {
				NoteDto dto = new NoteDto(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5), rs.getInt(6),rs.getString(7),rs.getString(8));
				list.add(dto);
			}
			return list;
		}catch (Exception e) {System.out.println(e);}
		return null;
	}

}	
