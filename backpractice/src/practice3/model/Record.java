package practice3.model;

import java.util.Date;

public class Record {

	Date date;
	int mno;
	int height;
	int weight;
	int Totalkcal;
	int rank;
	
	public Record() { }

	public Record(Date date, int mno, int height, int weight, int Totalkcal, int rank) {
		this.date = date;
		this.mno = mno;
		this.height = height;
		this.weight = weight;
		this.Totalkcal = Totalkcal;
		this.rank = rank;
	}

}
