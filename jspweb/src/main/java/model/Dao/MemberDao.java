package model.Dao;

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
			ps = con.prepareStatement(sql);
			ps.setString(1, mdto.getMid());
			ps.setString(2, mdto.getMpwd());
			ps.setString(3, mdto.getMemail());
			ps.setString(4, mdto.getMimg());
			ps.executeUpdate();
			return true;
		}catch(Exception e) { System.out.println(e);}
		return false;
	}// sign up e
	
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
	}
	// 5. 로그인한 회원 정보 호출
	public MemberDto getMember(String mid) {
		String sql = "select * from member where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2),null, rs.getString(4), rs.getString(5));
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
	// 7. 비밀번호 찾기
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
				if(result==1) {
					// new MemberDto().sendEmail(memail, updatepw); // 임시 비밀번호 이메일로 보내기
					return updatepw;}
			}					
		}catch(Exception e) { System.out.println(e);}
		return "false";	
	}

}// dao e
