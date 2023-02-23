package Day17;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Ex2_p532 {
	public static void main(String[] args) {
	
	// 1. Date, SimpleDateFormat
		// Date 객체명 = new Date();
		Date now = new Date();	// 현재 시스템[컴퓨터] 날짜
		// LocalDateTime now = LocalDateTime.now();
		System.out.println(now);// 객체명 [ .toString ]
	
		// SimpleDateFormat 객체명 = new SimpleDateFormat(패턴);
		// 객체명.format(날짜객체) : 날짜객체가 패턴 형식으로 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
		System.out.println(sdf.format(now));

	// 2. Calendar
		// 싱글톤 
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		System.out.println("현재년도  : "+ cal.get(Calendar.YEAR));
		System.out.println("현재 월  : "+(cal.get(Calendar.MONTH)+1));
		System.out.println("현재일/년 : "+ cal.get(Calendar.DAY_OF_YEAR));
		System.out.println("현재일/월 : "+ cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("현재일/주 : "+ cal.get(Calendar.DAY_OF_WEEK));
		// 주 : 1:일요일 ~ 7:토요일
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if(week==Calendar.MONDAY) 	{System.out.println("월");}
		if(week==Calendar.TUESDAY) 	{System.out.println("화");}
		if(week==Calendar.WEDNESDAY){System.out.println("수");}
		if(week==Calendar.THURSDAY) {System.out.println("목");}
		if(week==Calendar.FRIDAY) 	{System.out.println("금");}
		if(week==Calendar.SATURDAY) {System.out.println("토");}
		if(week==Calendar.SUNDAY) 	{System.out.println("일");}

		if(week==2) {System.out.println("월");}
		if(week==3) {System.out.println("화");}
		if(week==4) {System.out.println("수");}
		if(week==5) {System.out.println("목");}
		if(week==6) {System.out.println("금");}
		if(week==7) {System.out.println("토");}
		if(week==1) {System.out.println("일");}
		
		// 0:오전  1:오후
		System.out.println("현재 오전/오후 : "+cal.get(Calendar.AM_PM));
		int ampm = cal.get(Calendar.AM_PM);
		if(ampm == 0) { System.out.print("오전 "); }
		else { System.out.print("오후 "); }
		System.out.print(cal.get(Calendar.HOUR)		+"시 ");
		System.out.print(cal.get(Calendar.MINUTE)	+"분 ");
		System.out.print(cal.get(Calendar.SECOND)	+"초 ");
		System.out.println();
		
	// 3. 각국의 표준시 코드ID 얻기
		for(String timeID : TimeZone.getAvailableIDs()) {
			//System.out.println(timeID);
		}
		
	// 4. LocalDateTime 	
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("yyyy MM dd a HH:mm:ss");
		System.out.println(dtf.format(dateTime));
		
		System.out.println("1년  후 : "+dateTime.plusYears(1));
		System.out.println("2개월 전 : "+dateTime.minusMonths(2));
		System.out.println("일주일 후 : "+dateTime.plusDays(7));
		
		LocalDateTime 시작일 = LocalDateTime.of(2021,1,1,0,0,0);
		LocalDateTime 종료일 = LocalDateTime.of(2021,12,31,0,0,0);
		
		System.out.println("종료일이 시작일 이후인지? " + 시작일.isBefore(종료일));
		System.out.println("종요일이 시작일 이전인지? " + 시작일.isAfter(종료일));
		System.out.println("종료일이 시작일 동일한지? " + 시작일.isEqual(종료일));
		
		System.out.println("연 차 : "+ (시작일.until(종료일, ChronoUnit.YEARS)));
		System.out.println("월 차 : "+ (시작일.until(종료일, ChronoUnit.MONTHS)));
		System.out.println("일 차 : "+ (시작일.until(종료일, ChronoUnit.DAYS)));
		System.out.println("시 차 : "+ (시작일.until(종료일, ChronoUnit.HOURS)));
		System.out.println("분 차 : "+ (시작일.until(종료일, ChronoUnit.MINUTES)));
		System.out.println("초 차 : "+ (시작일.until(종료일, ChronoUnit.SECONDS)));
		
	// 5. DecimalFormat
		double num = 1234567.89;
		
		DecimalFormat df;
		
		// * 천단위 쉼표 만들기
		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		System.out.println(df.format(0));
		
		// * 무조건 소수 첫째 자리 표기 [ 없으면 0 ]
			// 0 : 만일 숫자가 없는 자리면 0 채움
			// # : 만일 숫자가 없는 자리명 공백
		df = new DecimalFormat("#,###.0");
		System.out.println(df.format(num));
		System.out.println(df.format(123456.7));
		System.out.println(df.format(123456));
		
		// * 금액의 천단위 쉼표 : #,##0
		df = new DecimalFormat("#,##0원");
		System.out.println(df.format(123456));
		System.out.println(df.format(1));
		System.out.println(df.format(0));
		
	// 6.SimpleDateFormat 
		Date date = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("오늘은 E 요일");
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("[연] 오늘은 D 번째 날");
		System.out.println(dateFormat.format(date));
		
		dateFormat = new SimpleDateFormat("[월] 오늘은 d 번째 날");
		System.out.println(dateFormat.format(date));
		

		
	}// main e
}// class e
