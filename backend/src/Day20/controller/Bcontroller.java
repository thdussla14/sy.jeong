package Day20.controller;

import java.util.ArrayList;

import Day20.model.DAO.BoardDao;
import Day20.model.DTO.BoardDto;
import Day20.model.DTO.CategoryDto;

public class Bcontroller {

	private static Bcontroller bcont = new Bcontroller();
	private Bcontroller () { }
	public static Bcontroller getInstance() {
		return bcont;
	}
	
	// 2. 카테고리 추가
	public boolean categoryAdd(String cname) {
		return BoardDao.getInstance().categoryAdd(cname);
	}
	// 3. 모든 카테고리 호출
	public ArrayList<CategoryDto> categoryPrint() {		
		return BoardDao.getInstance().categoryPrint();
	}
	// 4. 게시물 등록
	public boolean boardAdd(String btitle, String bcontent,int mno, int cno) {
		
		return BoardDao.getInstance().boardAdd(btitle, bcontent, mno, cno);
	}
	// 5. 최신 게시물 3개 출력
	public ArrayList<BoardDto> boardprintRecent() {
		return BoardDao.getInstance().boardprintRecent();	
	}
	// 6. 해당 카테고리 모든 게시물 출력
	public ArrayList<BoardDto> boardprint(int cno) {
		return BoardDao.getInstance().boardprint(cno);
	}
}
