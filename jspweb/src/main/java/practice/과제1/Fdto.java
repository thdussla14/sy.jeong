package practice.과제1;

public class Fdto {
	private int fnum;
	private String fname;
	private String sno;
	
	public Fdto() {
		// TODO Auto-generated constructor stub
	}

	public Fdto(int fnum, String fname, String sno) {
		super();
		this.fnum = fnum;
		this.fname = fname;
		this.sno = sno;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	@Override
	public String toString() {
		return "fdto [fnum=" + fnum + ", fname=" + fname + ", sno=" + sno + "]";
	}	
}