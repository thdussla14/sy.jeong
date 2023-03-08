package model.Dto;

public class FriendDto {

	private int fno;	
	private int smno;
	private int rmno;
	
	public FriendDto() { }

	public FriendDto(int fno, int smno, int rmno) {
		super();
		this.fno = fno;
		this.smno = smno;
		this.rmno = rmno;
	}

	@Override
	public String toString() {
		return "FriendDto [fno=" + fno + ", smno=" + smno + ", rmno=" + rmno + "]";
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getSmno() {
		return smno;
	}

	public void setSmno(int smno) {
		this.smno = smno;
	}

	public int getRmno() {
		return rmno;
	}

	public void setRmno(int rmno) {
		this.rmno = rmno;
	}
	
	
}
