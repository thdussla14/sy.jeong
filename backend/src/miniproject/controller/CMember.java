package miniproject.controller;

import java.util.ArrayList;

import miniproject.model.Member;

public class CMember {
	
	// Mcontroller 싱글톤
	private static CMember mc = new CMember();
	private CMember() {}
	public static CMember getInstance() { return mc; } 
	
	
	// DB 대신 ArrayList 생성
	private ArrayList<Member> memberDb = new ArrayList<>();
	
	// 보통 logSession 안쓴다 = mno 를 회원가입 고유번호 붙여야함 방법은?
	
	// 1. 회원가입 로직
	public int signup( String id, String pwd, String confirmpwd, String name , String phone  ){
		// 1. 유효성검사( + 등록된 id 값과 비교도 하기 )
			// 1. pwd, confirmpwd 값 비교
		if (!pwd.equals(confirmpwd) ) { return -1; } // 비밀번호확인 오류  = return -1
		else if ( id.length() < 5 && id.length() > 10   ) { return -2; } // id 길이 5~10 아닐 경우 = return -2
		else if ( id.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) { return -3;} // id에 한글 받으면 = return -3
		else if ( !phone.matches("[0-9]+")) { return -4; } // phone에 숫자 입력받으면 = return -4
		else if ( id.equals(pwd) ) { return -5; } // id와 pwd 같으면 = return -5 
			// 객체화
		int mno = 0;
		if( memberDb.size() != 0 ) {
			mno = memberDb.get( memberDb.size()-1  ).getMno() +1;
		}
		Member m = new Member( id , pwd , name , phone , mno );
			// 2. 리스트에 저장
			memberDb.add(m);
		return -6; // 회원가입 성공
	}
	
	//mno 값을 난수로 생성 -> 로그인성공시 로그인한 회원에게 mno 값 전달
	
	// 2. 로그인 로직
	public int login ( String id , String pw) {
		for ( int i = 0 ; i<memberDb.size(); i++ ) {
			if(memberDb.get(i).getId().equals(id) && memberDb.get(i).getPwd().equals(pw)) { return memberDb.get(i).getMno();  } // 로그인 성공 mno 값을 반환해야한다.
			
		}
		return -1;	// 회원정보 X
	}
	
	// 3. 아이디 찾기 로직
	public String findId ( String name , String phone ) {
		for ( Member m : memberDb ) {
			if(m.getName().equals(name) && m.getPhone().equals(phone) ) {
				return m.getId();
			}
		}
		return null;
	}
	// 4. 비밀번호 찾기 로직
	public String findPw ( String id , String phone ) {
		for ( Member m : memberDb ) {
			if(m.getId().equals(id) && m.getPhone().equals(phone) ) {
				return m.getPwd();
			}
		}
		return null;
	}

	
}
