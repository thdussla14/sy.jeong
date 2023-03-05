package PENGUINFLIGHT.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import PENGUINFLIGHT.controller.Acontroller;
import PENGUINFLIGHT.controller.Mcontroller;
import PENGUINFLIGHT.model.Airport;
import PENGUINFLIGHT.model.LP;
import PENGUINFLIGHT.model.Member;
import PENGUINFLIGHT.model.Reservation;
import PENGUINFLIGHT.model.rankDto;

public class Front {
	private static Front front = new Front(); 
	private Front() {};
	public static Front getInstance() {return front;}
	
	Scanner scanner = new Scanner(System.in);  

	public void index() {
		while(true) {
			System.out.println("\t\t\t\t\t==============================================메인화면==============================================");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t 메뉴>> 1. 로그인 2. 회원가입 3. 아이디찾기 4. 비번 찾기 5. 회원탈퇴"); 
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			try {
				System.out.print("\t\t\t\t\t ");
				int ch = scanner.nextInt();
				if(ch==1) {login();}
				else if(ch==2) {signup();}
				else if(ch==3) {findid();}
				else if(ch==4) {findpw();}
				else if(ch==5) {deleteId();}
			} catch (Exception e) {
				System.out.println(e);
				scanner = new Scanner(System.in);
			}
		
		}

	}
	
	// 로그인
	public void login() throws Exception{
		/* -> 로그인 성공 시 사용자 메인이동 // 관리자 아이디 로그인시 관리자 페이지 이동*/
		System.out.println("\t\t\t\t\t===============================================로그인===============================================");
		System.out.print("\t\t\t\t\t 아이디	: ");
		String mid = scanner.next();
		System.out.print("\t\t\t\t\t 비밀번호	: ");
		String mpw = scanner.next();
		
		int result = Mcontroller.getInstance().login(mid, mpw);
		if(result == 1) { // 관리자 로그인 id :adimn / pw : 1234 
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] 관리자 로그인성공"); // 확인용
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			Afront.getInstance().admin_main();
		}
		else if(result == 2) { // 일반로그인
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] 로그인성공");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			user_main(); // 사용자 메인페이지로 이동
		}
		else if(result == 0){ // 없는 아이디
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] 존재하지 않는 아이디 입니다.");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] DB오류");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
		} // 확인용
	}
	
	// 회원가입  0:회원가입 1:아이디중복 2:핸드폰입력이 잘못됨 3:DB오류 4:아아디 입력 오류

		public void signup() throws Exception{
			System.out.println("\t\t\t\t\t==============================================회원가입==============================================");
			System.out.println("\t\t\t\t\t 회원가입할 아이디(영문대소문자만) : ");
			String mid = scanner.next();
			System.out.println("\t\t\t\t\t 비밀번호 : ");
			String mpw = scanner.next();
			System.out.println("\t\t\t\t\t 이름 : ");
			String mname = scanner.next();
			System.out.println("\t\t\t\t\t 휴대폰 번호(xxx-xxxx-xxxx) : ");
			String mphone = scanner.next();
			System.out.println("\t\t\t\t\t 주민등록번호(xxxxxx-xxxxxxx) : ");
			String rrn = scanner.next();
			
			
			int result = Mcontroller.getInstance().signup(mid , mpw ,  mname , mphone , rrn);
			
			if(result == 0) {
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
				System.out.println("\t\t\t\t\t [알림]가입되었습니다. 로그인해 주십시오");
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");

			}


			else if(result == 1){
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
				System.out.println("\t\t\t\t\t [알림] 등록된 아이디입니다.");
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			}
			else if(result == 2) {
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
				System.out.println("\t\t\t\t\t [알림] 핸드폰 입력이 잘못되었습니다.");
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");}
			else if(result == 4) {
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
				System.out.println("\t\t\t\t\t [알림] 아이디는 영문대소문자만 입력하세요.");
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");}
			else {
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
				System.out.println("\t\t\t\t\t [알림] DB오류");
				System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");}
		}


	// 아이디찾기
	public void findid() throws Exception{
		// 샘플 'qweqwe','1234','유재석','010-1111-1111'
		System.out.println("\t\t\t\t\t=============================================아이디 찾기=============================================");
		System.out.print("\t\t\t\t\t 이름 : ");
		String mname = scanner.next();
		System.out.print("\t\t\t\t\t 휴대폰 번호 : ");
		String mphone = scanner.next();
		
		String mid = Mcontroller.getInstance().findid(mname , mphone);
		if(mid != null) {
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.print("\t\t\t\t\t [알림] 찾으시는 아이디는 : ");
			System.err.print(mid);
			System.out.print(" 입니다.\n");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] 가입된 회원이 아닙니다.");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");}
	}
	
	// 비밀번호 찾기
	public void findpw() throws Exception{
	// 샘플 'qweqwe','1234','유재석','010-1111-1111'
		System.out.println("\t\t\t\t\t=============================================비밀번호 찾기============================================");
		System.out.print("\t\t\t\t\t 아이디 : ");
		String mid = scanner.next();
		System.out.print("\t\t\t\t\t 이름 : ");
		String mname = scanner.next();
		System.out.print("\t\t\t\t\t 휴대폰 번호 : ");
		String mphone = scanner.next();
				
		String mpw = Mcontroller.getInstance().findpw(mid ,mname, mphone);
		if(mpw != null) {
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.print("\t\t\t\t\t [알림] 찾으시는 비밀번호는 : ");
			System.err.print(mpw);
			System.out.print(" 입니다.\n");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] 가입된 회원이 아닙니다.");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");}
	}
	
	// 회원탈퇴
	public void deleteId() throws Exception{
		// 샘플 'qweqwe','1234','유재석','010-1111-1111'
		System.out.println("\t\t\t\t\t==============================================회원탈퇴==============================================");
		System.out.print("\t\t\t\t\t 회원탈퇴할 아이디 : ");
		String mid = scanner.next();
		System.out.print("\t\t\t\t\t 비밀번호 : ");
		String mpw = scanner.next();
		System.out.print("\t\t\t\t\t 이름 : ");
		String mname = scanner.next();
		System.out.print("\t\t\t\t\t 휴대폰 번호 : ");
		String mphone = scanner.next();
		
		boolean result = Mcontroller.getInstance().deleteId(mid , mpw ,  mname , mphone);
		
		if(result) {
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] 탈퇴되었습니다.");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] 잘못입력하셨습니다.");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");}
	}
	
	public void user_main() {
		while (true) {
			System.out.println("\t\t\t\t\t==============================================유저메인==============================================");
			Member m = Mcontroller.getInstance().memberTier();
			
			System.out.println("\t\t\t\t\t 안녕하세요 "+m.getMname()+"님 회원님의 등급은 "+m.getTier()+"["+m.getMileage()+"점]"+"입니다. ");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			ArrayList<Airport> list = Mcontroller.getInstance().recommended();
			System.out.println("\t\t\t\t\t ****************************     이번달 가장 많이 떠난 여행지 TOP3     ********************************");
			System.out.println();
			for(int i = 0 ; i<list.size();i++) {
				System.out.println("\t\t\t\t\t\t\t\t\t "+(i+1)+". "+list.get(i).getPnation()+"["+list.get(i).getPname()+"] : "+list.get(i).getPno()+"명 이용");
			}
			System.out.println();
			System.out.println("\t\t\t\t\t ************************************************************************************************");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t 메뉴>> 1. 비행편 출력 2. 예약 확인 3. 로그아웃");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			try {
				System.out.print("\t\t\t\t\t ");
				int ch = scanner.nextInt();
				if(ch==1) {Rfront.getInstance().reservation();}
				else if(ch==2) {Myreser();}
				else if(ch==3) {return;}
			} catch (Exception e) {
				System.out.println(e);
				scanner = new Scanner(System.in);
			}
		}
	}
	
	
	
	public void Myreser() throws Exception{ // 이경석
		ArrayList<Reservation> rlist = Mcontroller.getInstance().Myreser();
		
		System.out.println("\t\t\t\t\t=============================================예약내역 출력============================================");
		for(Reservation re : rlist) { // 비행표는 예약번호
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.printf("\t\t\t\t\t 예약번호: %d \n\t\t\t\t\t 항공사 : %s \n\t\t\t\t\t 항공편 : %s -> %s \n"
							+ "\t\t\t\t\t 비행일 : %s \n\t\t\t\t\t 인원 : %d 명 \n"
							+ "\t\t\t\t\t 결제 가격 : %d -> 등급 할인 가격 %d\n"
							+ "\t\t\t\t\t 예상적립 마일리지 : %d\n",
							re.getRno(), re.getLname() , re.getDeparture(), re.getArrival()
							,re.getDate() ,re.getMen(), re.getTprice(), 
							//할인 가격 = 표 가격 - (표가격 * 할인가)
							re.getTprice() -  (int)(Math.floor(re.getDiscount()*re.getTprice()))   , 
							//마일리지 적립 = 표가격 * 마일리지비율
							(int)(Math.floor(re.getTprice() * re.getArate()))
							);
			
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			//비행표가 2표면 보기쉽게 분리
		}
		System.out.println("\t\t\t\t\t 메뉴>> 1. 예약취소 2. 뒤로가기");
		System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
		System.out.print("\t\t\t\t\t");	int ch = scanner.nextInt();
		if(ch==1) {MYcancle();} 
		else if(ch==2) {return;}
	}
	
	public void MYcancle() throws Exception{ // 이경석
		System.out.println("\t\t\t\t\t==============================================예약취소==============================================");
		System.out.print("\t\t\t\t\t 취소할 예약의 번호 : ");
		int ch2 = scanner.nextInt();
		
		boolean result = Mcontroller.getInstance().MYcancle(ch2);
		if(result) {
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] 예약을 취소했습니다.");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");}
		else {
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t [알림] 예약을 취소하지 못했습니다!.");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------------------------------");}
		
	}
	

	
}