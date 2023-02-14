package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;
import 과제.과제4_싱글톤.model.Member;

public class Mcontroller {

	// **  싱글톤 : 다른 곳에서 해당 객체를 공유 메모리 [ 멤버 = 필드, 메소드 ]
		// 1. 본인 클래스로 객체 만들기
		private static Mcontroller mc = new Mcontroller();
		// 2. 외부에서 생성자를 생성할 수 없도록 차단
		private Mcontroller() { }
		// 3. 함수를 통해 객체를 내보낸다. ( 함수가 static 이어서 인스턴스 객체는 가져올 수 없기에 객체 생성에도 static 추가 )
		public static Mcontroller getInstance() {
			return mc;
		}
	
	// DB 대신 ArratList
	private ArrayList<Member> memberDB = new ArrayList<>();
		
	// 로그인한 회원의 객체 주소 저장 [ * 동시접속 문제점 발생 ]
		// 사용목적 : 페이지가 바뀌더라도 정보저장 [ * 메소드가 종료되더라도 정보 저장 ]
	private Member logSession = null;	

	public Member getLogSession() {
		return logSession;
	}
	public void setLogSession(Member logSession) {
		this.logSession = logSession;
	}
	
	// 1. 회원가입----------------------------------------------------------------------------------
		// 인수 : id, pw, confirmpw , name, phone	// 반환 : 0 [성공] 1 [패스워드 실패]
	public int signup(String id, String pw, String confirmpw, String name, String phone) {
		// 1. 유효성검사 [ 스크립트에서할지 자바에서 할지 선택 사항? ]
		if (!pw.equals(confirmpw)) {return 1;}
		// 2. DB에 저장
			// 2-1. 객체화
			Member m = new Member(id,pw,name,phone,new ArrayList<>());
				// id,pw,name,phone : 스택영역에 저장된 힙주소 전달
				// new ArrayList<>(): 힙영역에 생성된 힙주소 전달
			// 2-2. 리스트에 저장
			memberDB.add(m);
		return 0;
	}// signup e
	
	// 2. 로그인-----------------------------------------------------------------------------------
		// 인수 : id, pw	// 반환 : i [회원번호] -1 [비밀번호 불일치] -2 [아이디 불일치] 
	public int login(String id, String pw) {
		
		for (int i=0; i<memberDB.size() ; i++)
			{if (memberDB.get(i).getId().equals(id))// i번째 인덱스의 아이디와 일치
				{if(memberDB.get(i).getPw().equals(pw))// i번째 인덱스의 비밀번호와 일치
					{logSession = memberDB.get(i);// 로그인 성공한 회원객체를 필드에 저장
					return i;}
				else {return -1;}
				}
			}// for e 
		return -2;
	}// login e
	
	// 3. 아이디찾기----------------------------------------------------------------------------------
		// 인수 : name, phone	// 반환 : id or  null
	public String findid(String name, String phone) {
		for(Member m : memberDB) { // memberDB에는 여러개의 member 객체가 들어있고 하나씩 member 객체를 꺼내서 대입;
			if(m.getName().equals(name)&&m.getPhone().equals(phone))
				{return m.getId();} // 위 조건이 충족되는 경우 아이디 반환
		}
		return null;
	}// findid e
	
	// 4. 비밀번호찾기---------------------------------------------------------------------------------
		// 인수 : id, phone	// 반환 : pw or null	
	public String findpw(String id,String phone) {
		for(Member m : memberDB) {
			if(m.getId().equals(id)&&m.getPhone().equals(phone))
				{return m.getPw();} // 위 조건이 충족되는 경우 비밀번호 반환
		}
		return null;
	} // findpw w
	
	// 5. 로그아웃-----------------------------------------------------------------------------------
		// 인수 : X [추후 페이징처리, 검색처리시 인수 O]	// 반환 : true [성공] false [실패]
	public boolean logOut() {
		logSession = null; // 필드에 저장된 로그인 성공한 회원 객체 지우기 [ null 대입시 GC가 메모리 자동제거 ]
		return true;
	} // logout e	
}
