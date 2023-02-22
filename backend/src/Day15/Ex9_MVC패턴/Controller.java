package Day15.Ex9_MVC패턴;

import java.util.ArrayList;

public class Controller {

	// 싱글톤
	private static Controller cont = new Controller();
	private Controller () { }
	public static Controller getInstance() {
		return cont;
	}
	
	public boolean signup(String mid, String mpw) {
		// 1. 유효성검사 [ 생략 ]
		// 2. 객체화	 [ 이유 :여러개의 변수가 이동하면 로직이 길어짐 -> 하나의 객체에 담아 이동 ]
		MemberDTO dto = new MemberDTO(mid, mpw);
		// 3. 해당 객체를 DB에 저장 [DAO 호출] 하고 실행 결과 저장
		boolean result  = MemberDAO.getInstance().signup(dto);
		// 4. 실행 결과 반환
		return result;
	}
	public ArrayList<MemberDTO> list() {
		
		ArrayList<MemberDTO> result = MemberDAO.getInstance().list();

		return result;
	}
	public boolean update(int mno, String mid, String mpw) {
		// 1. 유효성검사 [ 생략 ]
		// 2. 객체화	 [ 이유 :여러개의 변수가 이동하면 로직이 길어짐 -> 하나의 객체에 담아 이동 ]
		MemberDTO dto = new MemberDTO(mno, mid, mpw);
		// 3. 해당 객체를 DB에 저장 [DAO 호출] 하고 실행 결과 저장
		boolean result  = MemberDAO.getInstance().update(dto);
		// 4. 실행 결과 반환
		return result;
	}
	public boolean delete(int mno) {
		// 1. 유효성검사 [ 생략 ]
		// 2. 객체화	 [ 이유 :여러개의 변수가 이동하면 로직이 길어짐 -> 하나의 객체에 담아 이동 ]
		MemberDTO dto = new MemberDTO(mno);
		// 3. 해당 객체를 DB에 저장 [DAO 호출] 하고 실행 결과 저장
		boolean result  = MemberDAO.getInstance().delete(dto);
		// 4. 실행 결과 반환
		return result;
	}
	
}
