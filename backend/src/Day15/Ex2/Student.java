package Day15.Ex2;

public class Student {

	private int no;
	private String name;
	
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		int hashcode = no+name.hashCode();
		return hashcode;
	}
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Student) {
			Student target = (Student)obj;
			if( no==target.getNo() && name.equals(target.getName())) {
				return true;
			}
		}
		return false;
	}
	
	
}
