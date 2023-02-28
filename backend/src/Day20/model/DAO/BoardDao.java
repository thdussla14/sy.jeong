package Day20.model.DAO;

public class BoardDao extends Dao {
	
	// 1. 싱글톤
	private static BoardDao bdao = new BoardDao();
	private BoardDao() { }
	public static BoardDao getInstance() {
		return bdao;
	}
}
