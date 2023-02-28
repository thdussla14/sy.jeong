package PENGUINFLIGHT.model;

import java.util.ArrayList;

public class Adao extends Dao{

	private static Adao adao = new Adao();
	private Adao () { }
	public static Adao getInstance() {return adao;}
	
	
	public ArrayList<LP> LP() {
		ArrayList<LP> ListLP = new ArrayList<>();
		String sql  = "select * from LP";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				LP lpDto = new LP(rs.getInt(1), rs.getString(4), rs.getInt(2),rs.getInt(3));
				ListLP.add(lpDto);
				return ListLP;
			}// while e			

		}catch(Exception e) { }
		
		return null;
	}
	public ArrayList<Airport> Airport() {
		
		ArrayList<Airport> ListAP = new ArrayList<>();
		String sql2 = "select * from airport";
		try {
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Airport apDto  = new Airport(rs.getInt(1), rs.getString(2), rs.getString(3));
				ListAP.add(apDto);
			}// while e
			
		}catch(Exception e) { }
		
		return ListAP;
	}	
	public ArrayList<Schedule> Schedule() {
		
		ArrayList<Schedule> ListSC = new ArrayList<>();
		String sql3 = "select * from schedule";
		try {
			ps = conn.prepareStatement(sql3);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Schedule schDto = new Schedule(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), 
						rs.getTimestamp(5), rs.getTimestamp(6), rs.getInt(7), rs.getInt(8));
				ListSC.add(schDto);
			}// while e
			
		}catch(Exception e) { }
		
		return ListSC;
	}
	
	
	public void schedulePrint() {

		String sql = "select s.sno, dtime, atime, price, rseats, l.lpname, a.pname, a2.pname from schedule s,LP l, airport a, airport a2"
				+ "where s.lpno=l.lpno and s.dpno=a.pno and s.apno=a2.pno;";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+rs.getString(6)+rs.getString(7)+rs.getString(8)
							+rs.getDate(2)+rs.getDate(3)+rs.getInt(4)+rs.getInt(5));
			}// while e
			
		}catch(Exception e) { }


	}// schedulePrint e
	
	public void scheduleRegister() {
		
	}// scheduleRegister e
	
	public void scheduleUpdate() {
		
	}// scheduleUpdate e
	
	public void scheduleDelete() {
		
	}// scheduleDelete e
	
	
}
