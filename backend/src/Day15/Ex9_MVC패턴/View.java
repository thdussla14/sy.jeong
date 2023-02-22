package Day15.Ex9_MVC패턴;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

	// 싱글톤
	private static View view = new View() ;
	private View () { }
	public static View getInstnce() {
		return view;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	// 1. 메인페이지
	public void index() {
		while(true) {
			System.out.println("1. 등록[C] 2. 출력[R] 3. 수정[U] 4. 삭제[D]");
			int ch = scanner.nextInt();
			if 		(ch == 1) {Signup_page();}
			else if (ch == 2) {list_page();}
			else if (ch == 3) {update_page();}
			else if (ch == 4) {delete_page();}
		}
	}
	// 2. 회원가입 화면
	public void Signup_page() {
		System.out.println("-------등록[C]-------");
		// 1. 입력받기
		System.out.println("회원아이디 : ");	String mid = scanner.next();
		System.out.println("비밀번호 : ");	String mpw = scanner.next();
		// 2. 입력받은 데이터 컨트롤에 전달 후 결과 얻기
		boolean result  = Controller.getInstance().signup(mid, mpw);
		// 3. 결과에 따른 출력
		if(result) { System.out.println("[회원 가입 성공]");}
		else { System.out.println("[회원 가입 실패]");}
	}
	// 3. 출력 화면
	public void list_page() {
		System.out.println("-------출력[R]-------");
		
		ArrayList<MemberDTO> result = Controller.getInstance().list();
		
		System.out.println("회원번호\t아이디\t비밀번호");
		
		for(MemberDTO dto : result) {
			System.out.println(dto.getMno()+"\t"+dto.getMid()+"\t"+dto.getMpw());
		}
	}
	// 4. 수정 화면
	public void update_page() {
		System.out.println("-------수정[U]-------");
		// 1. 입력받기
		System.out.println("수정할 회원번호 : ");	int    mno = scanner.nextInt();
		System.out.println("회원아이디 : ");		String mid = scanner.next();
		System.out.println("비밀번호 : ");		String mpw = scanner.next();
		// 2. 입력받은 데이터 컨트롤에 전달 후 결과 얻기
		boolean result  = Controller.getInstance().update(mno, mid, mpw);
		// 3. 결과에 따른 출력
		if(result) { System.out.println("[정보 수정 성공]");}
		else { System.out.println("[정보 수정 실패]");}
	}
	// 5. 삭제 화면
	public void delete_page() {
		System.out.println("-------삭제[D]-------");
		// 1. 입력받기
		System.out.println("삭제할 회원번호 : ");	int mno = scanner.nextInt();
		// 2. 입력받은 데이터 컨트롤에 전달 후 결과 얻기
		boolean result  = Controller.getInstance().delete(mno);
		// 3. 결과에 따른 출력
		if(result) { System.out.println("[회원 탈퇴 성공]");}
		else { System.out.println("[회원 탈퇴 실패]");}
	}
	
	
	
}
