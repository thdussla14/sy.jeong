package practice3.model;

public class Core extends Exercise {

	int Set;
	int Count;
	
	public Core() {	}

	public Core(String ename, int kcal, int set, int count) {
		
		super(ename, kcal);
		Set = set;
		Count = count;
	}

	public void Total(int kcal, int set, int count) {
		
		int t_kcal = set * count * count ;
		
	}
	
	// 1. flutter kicks
	public void flutter_kicks() {
		
	}
	// 2. leg raises
	public void leg_raises() {
		
	}	
	// 3. sitting twist
	public void sitting_twist() {
		
	}	
	// 4. 플랭크
	public void 플랭크() {
		
	}	
	
}
