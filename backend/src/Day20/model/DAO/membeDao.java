package Day20.model.DAO;

import Day20.model.DTO.MemberDto;

public class membeDao extends Dao {
	
	// 1. 싱글톤
	private static membeDao mdao = new membeDao();
	private membeDao() { }
	public static membeDao getInstance() {
		return mdao;
	}
	
	// 기능메소드
	// 1. 아이디 중복체크 [ 아이디 검색 ] 
	public boolean IDcheck(String mid) {
		
		String sql = "select * from member where mid = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			// 검색된 레코드가 있으면 [중복아이디]
			if(rs.next()) { return true;}	// rs.next() : 검색된 결과의 다음 레코드 호출 있으면 true/없으면 flase
			else {return false;}
		}catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	// 2. 회원가입
	public int signup(MemberDto mdto) {
		String sql = "insert into member (mid, mpw, mname, mphone) values (?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getMid());
			ps.setString(2, mdto.getMpw());
			ps.setString(3, mdto.getMname());
			ps.setString(4, mdto.getMphone());
			ps.executeUpdate();
			return 1;
		}catch (Exception e) {System.out.println(e);}
		return 3;
	}
	// 3. 로그인
		// 로그인 세션 : 회원번호, Logindto [ 회원번호, 포인트, 등급 ]
	public int login(String mid,String mpw) {
		String sql = "select * from member where mid = ? and mpw = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1); }
			else {return 0; }
		}catch (Exception e) {System.out.println(e);}
		return 0;
	}
	
	
	
	
	
	
}
