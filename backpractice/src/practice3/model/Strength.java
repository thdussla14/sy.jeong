package practice3.model;

public class Strength extends Exercise {

	int Set;
	int Count;
	
	public Strength() {	}
	

	public Strength(String ename, int kcal, int set, int count) {
		super(ename, kcal);
		Set = set;
		Count = count;
	}

	public void Total(int kcal, int set, int count) {
		
		int t_kcal = set * count * count ;
		
	}
	
	// 1. Squats
	
	// 2. push_up
	
	// 3. punches
	
	// 4. 런지
	
	// 5. 테니스
	
	
}
