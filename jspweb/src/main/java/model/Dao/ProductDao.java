package model.Dao;

import java.util.ArrayList;

import model.Dto.ProductDto;

public class ProductDao extends Dao{

	private static ProductDao dao = new ProductDao();
	private ProductDao() {};
	public static ProductDao getInstantce() {
		return dao;
	}
	
	// 1. 제품 등록
	public boolean register(ProductDto dto) {		
		String sql = "insert into product (pname,pcontent,pprice,plat,plng) values (?,?,?,?,?)";		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcontent());
			ps.setInt(3, dto.getPprice());
			ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;	
	}
	
	// 2. 제품 출력 
	public ArrayList<ProductDto> getPlist(String 동,String 서,String 남,String 북 ) {		
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select * from product where plng between ? and ? and plat between ? and ? ; ";	
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, 서);
			ps.setString(2, 동);
			ps.setString(3, 남);
			ps.setString(4, 북);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto pdto = new ProductDto(rs.getInt(1), rs.getString(2),  rs.getString(3), rs.getInt(4),
						rs.getInt(5),  rs.getString(6),  rs.getString(7), rs.getInt(8),  rs.getString(9));
				list.add(pdto);
			}
			return list;
		}catch (Exception e) {System.out.println(e);}
		return null;	
	}
	
	// 3. 찜하기 등록 / 취소
	public boolean setplike(int pno, int mno) {
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
	public boolean getplike(int pno, int mno) {
		String sql = "select * from plike where pno = "+pno+" and mno = "+mno;			
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){return true;}					
		}catch (Exception e) {System.out.println(e);}
			return false;
	}

}	
