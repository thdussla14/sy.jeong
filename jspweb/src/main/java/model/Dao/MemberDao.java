package model.Dao;

import java.sql.Statement;
import java.util.ArrayList;

import model.Dto.MemberDto;

public class MemberDao extends Dao {

	private static MemberDao dao = new MemberDao();
	private MemberDao () {	}
	public static MemberDao getInstance() { return dao;	}
	
	// 1. 회원가입
	public boolean signup(MemberDto mdto) {
		String sql = "insert into member (mid,mpwd,memail,mimg) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, mdto.getMid());
			ps.setString(2, mdto.getMpwd());
			ps.setString(3, mdto.getMemail());
			ps.setString(4, mdto.getMimg());
			ps.executeUpdate();
			// 포인트 지급 [ 내용 , 수량, 방금 회원가입한 회원번호[pk] ]
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int pk = rs.getInt(1);
				setPoint("회원가입축하", 300, pk);}			
			return true;
		}catch(Exception e) { System.out.println(e);}
		return false;
	}// sign up e
	/*
		insert 이후 자동으로 생성된 auto key => pk 찾기
			con.prepareStatement(sql)
			con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			rs = ps.getGeneratedKeys();
			if(rs.next()) {int pk = rs.getInt(1);}

	 */
	// 2. 회원리스트 호출
	public ArrayList<MemberDto> getMemberList () {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select * from member";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(mdto);
			}
			return list;
		}catch(Exception e) { System.out.println(e);}		
		return null;		
	}// getMemberList e
	
	// 3. 아이디 중복 검사
	public boolean idCheck(String mid) {
		String sql = "select * from member where mid = '"+mid+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}		
		}catch(Exception e) { System.out.println(e);}
		return false;
	}// idCheck e
	
	// 4. 로그인 [아이디,비밀번호 일치 검사]
	public boolean login(String mid,String mpw) {
		String sql = "select * from member where mid = ? and mpwd = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}		
		}catch(Exception e) { System.out.println(e);}
		return false;
	}// login e
	
	// 5. 로그인한 회원 정보 호출
	public MemberDto getMember(String mid) {
		String sql = "select m.mno, m.mid, m.mimg, m.memail,sum(p.mpamount) as mpoint from member m,mpoint p "
				+ "where m.mno = p.mpmno and mid = ? group by mno;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				// m.mno[1], m.mid[2], m.mimg[3], m.memail[4], mpoint[5]
				// rs.next() 
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2),null, rs.getString(3), rs.getString(4),rs.getInt(5));
				return dto;
			}					
		}catch(Exception e) { System.out.println(e);}
		return null;
	}
	
	// 6. 아이디 찾기
	public String findid(String memail) {
		String sql = "select mid from member where memail = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getString(1);}					
		}catch(Exception e) { System.out.println(e);}
		return "false";
	}
	
	// 7.비밀번호 찾기
	public String findpw(String mid,String memail,String updatepw) {
		String sql = "select mno from member where mid = ? and memail = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if(rs.next()) {
				sql = "update member set mpwd = ? where mno = ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, updatepw);
				ps.setInt(2, rs.getInt(1));
				int result = ps.executeUpdate();					// 업데이트한 레코드 개수 반환
				if( result == 1) {
					// new MemberDto().sendEmail(memail, updatepw); // 임시 비밀번호 이메일로 보내기
					System.out.println(updatepw);
					return updatepw;}
			}					
		}catch(Exception e) { System.out.println(e);}
		return "false";	
	}
	
	// 8. 포인트함수 [ 지급사유 , 지급포인트, 지급대상 ] 
	public boolean setPoint(String content, int point, int mno) {
		String sql = "insert into mpoint(mpcomment,mpamount,mpmno) values (?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, point);
			ps.setInt(3, mno);
			ps.executeUpdate();	
			return true;
		}catch(Exception e) { System.out.println(e);}
		return false;	
	}
	
	// 9. 회원탈퇴 [mid]
	public boolean delete(String mid, String mpwd) {
		String sql = "delete from member where mid = ? and mpwd = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			int count = ps.executeUpdate();	// 삭제된 레코드 수 반환
			if( count ==1 ) {return true;}
		}catch(Exception e) { System.out.println(e);}
		return false;
	}
	
	// 10. 회원정보수정 [mid, mpwd, memail]
	public boolean update(String mid,String mpw,String newmpwd, String newmemail, String mimg) {
		String sql = "update member set mpwd = ? , memail = ? , mimg = ? where mid = ? and mpwd = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newmpwd);
			ps.setString(2, newmemail);
			ps.setString(3, mimg);
			ps.setString(4, mid);
			ps.setString(5, mpw);
			int count = ps.executeUpdate();	
			if( count ==1 ) {return true;}
		}catch(Exception e) { System.out.println(e);}
		return false;
	}

}// dao e
