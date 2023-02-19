package miniproject.controller;

import java.util.ArrayList;

import miniproject.model.Memo;

public class CMemo {

	// 필드 영역
	private ArrayList<Memo> memoDB = new ArrayList<>();
	
	// 생성자 영역
	// 싱글톤 적용
	private static CMemo memo = new CMemo();
	private CMemo() {}
	public static CMemo getInstance() { return memo; }
	
	// 메소드 영역
	// 1. 메시지 메소드 (기능: 로그인 유무 체크, DB저장)
	public boolean writeMemo( int fromNo, int pno, String title, String content, int send ) {
		
		int meNo = createMeNo();
		
		if( sendMemo(send) ) {
			// 기능1. DB 저장(저장값: fromNo, pNo, meNo, title, content)
			Memo memo = new Memo(fromNo, pno, meNo, title, content);
			
			memoDB.add(memo);
			
			return true;
		}
		return false;
	}
	
	// 1-1. 메시지 넘버 생성 함수
	public int createMeNo() {
			
		int result = 0;
		
		if( memoDB.size() != 0 ) {
			result = memoDB.get(memoDB.size()-1).getMeNo()+1;
		}
		return result;
	}
	
	// 2. 메시지 발송 처리 메소드 (기능: DB 저장)
	public boolean sendMemo( int send ) {
		
		if( send == 1 ) { return true; }
		else { return false; }
	}
	
	// 3. 메시지 출력 메소드 (기능: MMemo tostring 출력)
	public ArrayList<Memo> printMemo( ){
		
		return memoDB;
	}
	
	// 4. 메시지 상세보기 메소드 (기능: 선택된 메시지 내용 상세 보기)
	public Memo detailMemo( int mNo) {
		return memoDB.get(mNo);
	}
	public ArrayList<Memo> getMemoDB() {
		return memoDB;
	}

}