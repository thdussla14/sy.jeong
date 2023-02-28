package PENGUINFLIGHT.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import PENGUINFLIGHT.model.Adao;
import PENGUINFLIGHT.model.Airport;
import PENGUINFLIGHT.model.LP;
import PENGUINFLIGHT.model.Schedule;

public class Acontroller {
	private static Acontroller controller = new Acontroller();
	private Acontroller() {};
	public static Acontroller getInstance() {return controller;}
	
	public void schedulePrint() {
		
		ArrayList<LP>       ListLP = Adao.getInstance().LP();
		ArrayList<Airport>  ListAP = Adao.getInstance().Airport();
		ArrayList<Schedule> ListSC = Adao.getInstance().Schedule();
		
		String lpname = null;
		String dpname = null;
		String apname = null;
		
		for (Schedule sc : ListSC) {
			for(LP lp : ListLP)      {if(sc.getLpno()==lp.getLpno()) {lpname = lp.getLpname();}}
			for(Airport ap : ListAP) {if(sc.getSpno()==ap.getPno())  {dpname = ap.getPname();}}
			for(Airport ap : ListAP) {if(sc.getDpno()==ap.getPno())  {apname = ap.getPname();}}
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
			System.out.printf("%2d %-6s %-8s %-20s %-8s %-20s %-10d %5d \n",
					sc.getSno(),lpname,dpname,sdf.format(sc.getDtime()),
					apname,sdf.format(sc.getDtime()),sc.getPrice(),sc.getRseats());
			
		}// for e
		
	}
	
	public void scheduleRegister() {
		
	}
	
	public void scheduleUpdate() {
		
	}
	
	public void scheduleDelete() {
		
	}
	
}
