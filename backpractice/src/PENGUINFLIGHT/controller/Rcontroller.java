package PENGUINFLIGHT.controller;

import java.util.ArrayList;
import java.util.Calendar;

import PENGUINFLIGHT.model.Airport;
import PENGUINFLIGHT.model.Rdao;
import PENGUINFLIGHT.model.Reservation;
import PENGUINFLIGHT.model.Schedule;

public class Rcontroller {
	private static Rcontroller acontroller = new Rcontroller();
	private Rcontroller() {};
	public static Rcontroller getInstance() {return acontroller;}
	
	// 국가선택
	public String pnation() {
		return Rdao.getInstance().pnation();
	}
	
	//출발지 출력
	public ArrayList<Airport> Departure(String pnation) {
		//유효성검사
		if(Rdao.getInstance().pnationCheck(pnation)) {
			return Rdao.getInstance().Departure(pnation);
		}else {
			return null;
		}
	}
	
	//공항 이름 출력
	public String airportName(int pno) {
		return Rdao.getInstance().airportName(pno);
	}
	
	//도착지 출력
	public ArrayList<Airport> Arrival(String pnation, int pno) {
		//유효성검사
		if(Rdao.getInstance().pnationCheck(pnation)) {
			return Rdao.getInstance().Arrival(pnation, pno);
		}else {
			return null;
		}
	}
	
	//공항 선택 유효성 검사
	public boolean airportCheck(int pno,String pnation) {
		return Rdao.getInstance().airportCheck(pno, pnation);
	}
	
	
	//출발 날짜 선택 유효성검사
	public boolean dateSelect(String dtime) {
		
		String date[] = dtime.split("-");
		int iyear =  Integer.parseInt(date[0]);
		int imonth =  Integer.parseInt(date[1]);
		int iday =  Integer.parseInt(date[2]);
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		cal.set(year, month-1, 1);
		int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		if(iyear>=1900 && iyear<=9999 && imonth>=1 && imonth<=12 && iday>=1 && iday<=eday) {
			if(year>iyear) {
				return false;
			}else if(year==iyear) {
				if(month>imonth) {
					return false;
				}else if(month==imonth) {
					if(day>iday) {
						return false;
					}else if(day<=iday) {
						return true;
					}
				}else if(month<imonth) {
					return true;
				}
			}else if(year<iyear) {
				return true;
			}
		}else {return false;}
		return false;
	}
	
	//비행편 선택
	public  ArrayList<Schedule> flightSelect(int dpno,int apno,String dtime,int men) {
		return Rdao.getInstance().flightSelect(dpno, apno, dtime, men);
	}
	
	//선택한 스케줄 번호의 스케줄[1개]
	public Reservation ticketReservation1(int sno) {
		return Rdao.getInstance().ticketReservation1(sno,Mcontroller.getLoginsession());
	}
	
	// 예약 완료[insert]
	public boolean ticketReservation2(int men , Reservation ticket) {
		return Rdao.getInstance().ticketReservation2(men, Mcontroller.getInstance().getLoginsession(), ticket);
	}
	
	//결제
	public void payment() {
		
	}
	
}