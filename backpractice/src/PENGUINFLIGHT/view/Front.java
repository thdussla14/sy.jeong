package PENGUINFLIGHT.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import PENGUINFLIGHT.controller.Acontroller;
import PENGUINFLIGHT.model.Airport;
import PENGUINFLIGHT.model.LP;

public class Front {
	
	private static Front front = new Front(); 
	private Front() {};
	public static Front getInstance() {return front;}
	
	Scanner scanner = new Scanner(System.in);  

	public void index() {
		System.out.println("메뉴> 1. 로그인 2. 회원가입 3. 아이디찾기 4. 비번 찾기");
		int ch = scanner.nextInt();
		if(ch==1) {login();}
		else if(ch==2) {signup();}
		else if(ch==3) {findid();}
		else if(ch==4) {findpw();}
		else if(ch==5) {admin_main();}
	}
	
	public void login() {
		user_main();
		/* -> 로그인 성공 시 사용자 메인이동 // 관리자 아이디 로그인시 관리자 페이지 이동*/
	}
	
	public void signup() {
		
	}
	
	public void findid() {
		
	}
	
	public void findpw() {
		
	}
	
	public void user_main() {
		System.out.println(" 1. 비행편 출력   2. 예약 확인 3. 로그아웃");
		int ch = scanner.nextInt();
		if(ch==1) {reservation();}
		else if(ch==2) {Myreser();}
		else if(ch==3) {return;}
	}
	
	public void reservation() {

	}
	
	
	public void Departure() {

	}
	
	public void Arrival() {

	}
	public void dateSelect() {
		
	}
	
	public void pSelect() {
		
	}
	
	public void flightSelect(int dpno,int apno,Date dtime,int men) {
		
	}
	
	public void selectCompelete() {

	}
	
	public void payment() {
		
	}
	
	public void Myreser() {

	}
	
	public void MYcancle() {
		
	}
// 관리자 로그인시 메인페이지
	public void admin_main() {
		while(true) {
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("1.스케줄 확인  2. 스케줄 등록 3. 스케줄 수정 4. 스케줄 삭제  5. 결산내역  6.뒤로가기");
			System.out.println("------------------------------------------------------------------------------------------------");
			int ch = scanner.nextInt();
			if(ch==1) {schedulePrint();}
			else if(ch==2) {scheduleRegister();}
			else if(ch==3) {scheduleUpdate();}
			else if(ch==4) {scheduleDelete();}
			else if(ch==5) {RANK();}
			else if(ch==5) {break;}
		}// while e
	}
// 스케줄 목록	10개 출력	
	public void schedulePrint() {	
		// 10개만 출력
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.printf("%-2s %-8s %-8s %-19s %-8s %-19s %-8s %-3s \n",
				"번호","비행편명","출발지","출발일정","도착지","도착일정","가격","잔여좌석");
		System.out.println("------------------------------------------------------------------------------------------------");
		Acontroller.getInstance().schedulePrint();
		System.out.println("------------------------------------------------------------------------------------------------");
		while(true) {
			System.out.println("1.출발지 기준 검색 2. 출발일정 기준 검색  3.뒤로가기");
			int ch = scanner.nextInt();
			if(ch==1) {schedulePrint_DP();}
			else if(ch==2) {schedulePrint_DD();}
			else if(ch==3) {break;}
		}// while e
	}// schedulePrint e
// 출발지 기준 스케줄 목록 검색 / 출력 
	public void schedulePrint_DP() {
		System.out.print("출발지 검색 : [예시:김포공항]  "); String pname = scanner.next();
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.printf("%-2s %-8s %-8s %-16s %-8s %-16s %-8s %-3s \n",
				"번호","비행편명","출발지","출발일정","도착지","도착일정","가격","잔여좌석");
		System.out.println("------------------------------------------------------------------------------------------------");
		Acontroller.getInstance().schedulePrint_DP(pname);
		System.out.println("------------------------------------------------------------------------------------------------");
	}// schedulePrint_DP e
// 출발일 기준 스케줄 목록 검색 / 출력 	
	public void schedulePrint_DD() {
		System.out.print("출발일 검색 : [예시:2023-03-07] "); String ddate = scanner.next();
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.printf("%-2s %-8s %-8s %-16s %-8s %-16s %-8s %-3s \n",
				"번호","비행편명","출발지","출발일정","도착지","도착일정","가격","잔여좌석");		
		System.out.println("------------------------------------------------------------------------------------------------");
		Acontroller.getInstance().schedulePrint_DD(ddate);
		System.out.println("------------------------------------------------------------------------------------------------");
	}// schedulePrint_DD e
// 스케줄 등록
	public void scheduleRegister () {
		while(true) {
			ArrayList<Airport> aplist = Acontroller.getInstance().Airport();
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.printf("%-2s %-8s %-12s\n",
					"번호","공항명","소속 국가");
			System.out.println("------------------------------------------------------------------------------------------------");
			for(Airport ap: aplist) {
				System.out.printf("%-2s %-8s %-12s\n",
						ap.getPno(),ap.getPname(),ap.getPnation());		
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("[경로 설정]");
			System.out.print("출발지 입력 : [예시:김포공항] "); String dpname = scanner.next();
			System.out.print("도착지 입력 : [예시:인천공항] "); String apname = scanner.next();
			if(Acontroller.getInstance().APcheck(dpname, apname)) {}
			else {System.out.println("[알림] 동일공항 선택이 불가능합니다.");break; }
			
			System.out.println("[일정 설정]");
			System.out.print("출발일 입력 : [예시:2023-03-07 06:15:00] "); String ddate = scanner.next(); String dtime = scanner.next();
			System.out.print("도착일 입력 : [예시:2023-03-07 09:15:00] "); String adate = scanner.next(); String atime = scanner.next();
			
			System.out.println("[비행편 설정]");
			ArrayList<LP> lplist = Acontroller.getInstance().LP();
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.printf("%-2s %-8s %-12s %-8s %-8s\n",
								"번호","비행편명","소속 항공사","비행기종","최대수용인원");		
			System.out.println("------------------------------------------------------------------------------------------------");
			for(LP lp: lplist) {
				System.out.printf("%-2d %-10s %-13s %-10s %-5d\n",
						lp.getLpno(),lp.getLpname(),lp.getLname(),lp.getAname(),lp.getAmax());
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("비행편 입력 : [예시:MA123456] ");  String lpname = scanner.next();
			
			System.out.println("[가격 설정]");
			System.out.println("가격 입력  : [예시:110000] "); 		int   price  = scanner.nextInt();
			
			boolean result = Acontroller.getInstance().scheduleRegister(dpname,apname,ddate,dtime,adate,atime,lpname,price);			
			if(result) {System.out.println("[알림] 일정 등록 완료 "); break;}
			else {System.out.println("[알림] 일정 등록 실패 "); break;}
		}// while e
	}
// 수정할 스케줄 번호 선택 / 출력	
	public void scheduleUpdate() {

			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.print("수정할 스케줄 번호 선택 : ");      int sno = scanner.nextInt();
			System.out.println("------------------------------------------------------------------------------------------------");
		while(true) {
			Acontroller.getInstance().scheduleUpdate(sno);
			System.out.print("1.경로 수정 2. 일정 수정  3. 비행편 수정  4. 가격 수정  5.뒤로가기");
			int ch = scanner.nextInt();
			if(ch==1) {scheduleUpdate_AP(sno);}
			else if(ch==2) {scheduleUpdate_DD(sno);}
			else if(ch==3) {scheduleUpdate_LP(sno);}
			else if(ch==4) {scheduleUpdate_PR(sno);}
			else if(ch==5) {break;}
		}// while e
	}// scheduleUpdate e
// 경로 재설정
	public void scheduleUpdate_AP(int sno) {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("[경로 재설정]");
		System.out.print("출발지 입력 : [예시:김포공항] "); String dpname = scanner.next();
		System.out.print("도착지 입력 : [예시:인천공항] "); String apname = scanner.next();
		System.out.println("------------------------------------------------------------------------------------------------");
		if(Acontroller.getInstance().APcheck(dpname, apname)) {
			Acontroller.getInstance().scheduleUpdate_AP(sno, dpname, apname);
			System.out.println("[알림] 경로 재설정이 완료되었습니다.");
		}
		else {System.out.println("[알림] 동일공항 선택이 불가능합니다.");}
	}
// 일정 재설정
	public void scheduleUpdate_DD(int sno) {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("[일정 재설정]");
		System.out.print("출발일 입력 : [예시:2023-03-07 06:15:00] "); String ddate = scanner.next(); String dtime = scanner.next();
		System.out.print("도착일 입력 : [예시:2023-03-07 09:15:00] "); String adate = scanner.next(); String atime = scanner.next();
		System.out.println("------------------------------------------------------------------------------------------------");
		boolean result = Acontroller.getInstance().scheduleUpdate_DD(sno, ddate,dtime, adate,atime);			
		if(result) {System.out.println("[알림] 일정 재설정 완료 "); }
		else {System.out.println("[알림] 일정 재설정 실패 ");}
	}
// 비행편 재설정
	public void scheduleUpdate_LP(int sno) {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("[비행편 재설정]");
		ArrayList<LP> lplist = Acontroller.getInstance().LP();
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.printf("%-2s %-8s %-12s %-8s %-8s\n",
							"번호","비행편명","소속 항공사","비행기종","최대수용인원");		
		System.out.println("------------------------------------------------------------------------------------------------");
		for(LP lp: lplist) {
			System.out.printf("%-2d %-10s %-13s %-10s %-5d\n",
					lp.getLpno(),lp.getLpname(),lp.getLname(),lp.getAname(),lp.getAmax());
		}
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.print("비행편 입력 : [예시:MA123456] ");  String lpname = scanner.next();
		System.out.println("------------------------------------------------------------------------------------------------");
		boolean result = Acontroller.getInstance().scheduleUpdate_LP(sno, lpname);		
		if(result) {System.out.println("[알림] 비행편 재설정 완료 "); }
		else {System.out.println("[알림] 비행편 재설정 실패 ");}
	}
// 가격 재설정
	public void scheduleUpdate_PR(int sno) {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("[가격 재설정]");
		System.out.print("가격 입력  : [예시:110000] "); 		int   price  = scanner.nextInt();	
		System.out.println("------------------------------------------------------------------------------------------------");
		boolean result = Acontroller.getInstance().scheduleUpdate_PR(sno, price);			
		if(result) {System.out.println("[알림] 가격 재설정 완료 "); }
		else {System.out.println("[알림] 가격 재설정 실패 ");}
	}
// 삭제할 스케줄 번호 선택 / 출력	
	public void scheduleDelete() {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.print("삭제할 스케쥴번호 입력 : ");  int sno = scanner.nextInt();
		System.out.println("------------------------------------------------------------------------------------------------");
		Acontroller.getInstance().scheduleUpdate(sno);
		System.out.print("해당 스케줄을 삭제하시겠습니까? 1. 삭제  2. 취소"); int ch = scanner.nextInt();
		System.out.println("------------------------------------------------------------------------------------------------");
		if(ch==1) {
			boolean result = Acontroller.getInstance().scheduleDelete(sno);;			
			if(result) {System.out.println("[알림] 일정 삭제 완료 "); }
			else {System.out.println("[알림] 일정 삭제 실패 ");}
		}else if (ch==2) {System.out.println("[알림] 삭제 취소되었습니다. "); }
	}
// 결산 내역 메인페이지
	private void RANK() {
		while(true) {
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("1.항공사별 매출 결산  2. 공항별 이용객수 결산   3. 뒤로가기");
			System.out.println("------------------------------------------------------------------------------------------------");
			int ch = scanner.nextInt();
			if(ch==1) {ALRANK();}
			else if(ch==2) {APRANK();}
			else if(ch==3) {break;}
		}// while e
	}
// 항공사별 매출 결산
	private void ALRANK() {
		
	}
// 공항별 이용객수 결산
	private void APRANK() {
		
	}
	
}