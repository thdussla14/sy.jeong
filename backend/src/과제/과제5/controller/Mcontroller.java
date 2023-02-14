package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Member;
import 과제.과제5.model.Product;
import 과제.과제5.model.Memo;

public class Mcontroller {
	
	// ** 싱글톤
	private static Mcontroller mc = new Mcontroller();
	private Mcontroller () { }
	public static Mcontroller getInsetance(){
		return mc;
	}
	
	ArrayList<Member> memberDB = new ArrayList<>();
	ArrayList<Memo> memoDB = new ArrayList<>();
	
	// ** logsession 
	private int logSession = 0;	

	public int getLogSession() {
		return logSession;
	}
	public void setLogSession(int logSession) {
		this.logSession = logSession;
	}

	// 1. 회원가입
	public boolean signup(String id, String pw,String phone) {
		// 1-1. 식별자 PK 생성
		int mno = 0;
		if(memberDB.size()>0)
			{mno = memberDB.get(memberDB.size()-1).getMno()+1;}
		// 1-2. 멤버 객체 생성
		Member member = new Member(mno,id,pw,phone);
		// 1-3. 멤버 객체 저장
		memberDB.add(member);
		// 1-4. 성공 반환
		return true;
	}
	// 2. 로그인
	public boolean login(String id, String pw) {		
		for(Member m : memberDB) {
			// 2-1. id 일치 확인
			if(m.getId().equals(id))
				{// 2-2. pw 일치 확인
				if(m.getPw().equals(pw))
					{// 2-3. 로그인 흔적 남기기 
					logSession = m.getMno();
					return true; }}
		}// for e		
		return false;
	}

	// 3. 쪽지 보내기
	public boolean send (int spno, String mContent ) {
		
		int sendmno = Mcontroller.getInsetance().getLogSession();
		int meno =0;
		if(memoDB.size()>0)
			{meno = memoDB.get(memoDB.size()-1).getMeno()+1;}
		Memo memo = new Memo(sendmno,spno,meno,mContent);
		memoDB.add(memo);
		
		return true;
	}
	
	
	// 4. 받은쪽지함
	public ArrayList<Memo> receiM() {
		// 3-1. 받은 쪽지함 생성
		ArrayList<Memo> myrMe = new ArrayList<>();
		// 3-2. productDB에서 내가 올린 product 추출
		for(Product p:Pcontroller.getInstance().myproduct()) {
			if(p.getMno()==logSession) 
			{// 3-3. memoDB에서 해당 product로 보낸 쪽지 추출
				for(Memo me : memoDB) {
					if(me.getPno()==p.getPno())
						{// 3-3. 받은쪽지함에 저장
						myrMe.add(me);}}
			}// m for e
		}// p for e
		// 3-4. 받은쪽지함 반환
		return myrMe;
	}
	
	// 5. 보낸쪽지함
	public ArrayList<Memo> sendM() {
		// 4-1. 보낸 쪽지함 생성
		ArrayList<Memo> mysMe = new ArrayList<>();
		// 4-2. memoDB에서 발신자 id와 logsession id 대조
		for(Memo me : memoDB) {
			if(me.getSendmno()==logSession)
				{// 4-3. 일치하는 쪽지 보낸쪽지함에 저장
				mysMe.add(me);}
		}// for e
		// 4-4. 보낸쪽지함 반환
		return mysMe;
	}
	
	
}// class e
