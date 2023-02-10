package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Member;

//* 처리, 제어 담당
public class Mcontroller {
	// * DB 대용 Array
	ArrayList<Member>memberDB=new ArrayList<>();

	// 1. 회원가입 로직
	public int signup(String id,String pwd,String confirmpwd,String name,String phone) {
			
		// 1. 유효성 검사
		if(!pwd.equals(confirmpwd)) {return 1;} // 회원가입 실패 1		
		// 2. 객체 생성
		Member member = new Member(id,confirmpwd,name,phone);
		// 3. DB 처리
		memberDB.add(member);
		
		return 0; // 회원가입 성공 0
		
	} // signup e
	
	// 2. 로그인 로직
	public int login(String id,String pwd) {

		// 1. 유효성 검사
		// * 모든 멤버들 중 동일한 아이디/비밀번호 찾기
		for(int i=0; i<memberDB.size() ; i++)
			{// 1-1. 만약 i번째 회원의 아이디와 입력받은 아이디 일치 확인
			if(memberDB.get(i).id.equals(id))
				 {// 1-2. i번째 회원의 비밀번호와 일치 확인
				 if(memberDB.get(i).pwd.equals(pwd)) {return i;} // id,pwd 모두 일치시 회원번호 반환
				 else {return -1;}  // id 일치, pwd 불일치
				 }
			}// for e
		return -2;//id,pwd 모두 불일치
		
	} // login e
	
	// 3. 아이디 찾기 로직
	public String findid(String name,String phone) {
		
		// 1. 유효성 검사
		// * 모든 멤버들 중 동일한 아이디/비밀번호 찾기
		for(Member m:memberDB)
			{// 1-1. 만약 i번째 회원의 아이디와 입력받은 아이디 일치 확인
			if(m.name.equals(name))
				 {// 1-2. i번째 회원의 비밀번호와 일치 확인
				 if(m.phone.equals(phone)) {return m.id;} 
				 }
			}// for e
		return null;

	}//findid e
	
	
	// 4. 비밀번호 찾기 로직
	public String findpw(String id,String phone) {
		
		// 1. 유효성 검사
		// * 모든 멤버들 중 동일한 아이디/비밀번호 찾기
		for(Member m:memberDB)
			{// 1-1. 만약 i번째 회원의 아이디와 입력받은 아이디 일치 확인
			if(m.id.equals(id))
				 {// 1-2. i번째 회원의 비밀번호와 일치 확인
				 if(m.phone.equals(phone)) {return m.pwd;} 
				 }
			}// for e
		return null;
		
	}//findpw e
	
}
