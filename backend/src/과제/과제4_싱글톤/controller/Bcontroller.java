package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4_싱글톤.model.Board;

public class Bcontroller {
	// ** 싱글톤
	private static Bcontroller  bc = new Bcontroller();
	private Bcontroller () { }
	public static Bcontroller getInsetance() {
		return bc;
	}
	// DB 대신 리스트 사용
	private ArrayList<Board> boardDB = new ArrayList<>();
	
	
	// 5. 글쓰기---------------------------------------------------------------------------
		// 인수 : title, content	// 반환 : true [성공] false [실패]
	public boolean write(String title, String content) {
		// 1. 유효성검사 [ 로그인 여부 판단 => 로그인 안된 경우 false  ]
		if(Mcontroller.getInstance().getLogSession()== null) 
			{return false;}
		// 2. DB 저장
			// 2-1. 객체화 [ 글 작성 : 입력받은 데이터 2개, 초기값 0, 로그인한 회원객체 =  글쓴이 ] 
			Board board = new Board(title,content,0,Mcontroller.getInstance().getLogSession());
			// 2-2. DB 저장
			boardDB.add(board);
			// 2-3. 멤버 객체에 내가 쓴 글 등록
			Mcontroller.getInstance().getLogSession().getBoardList().add(board);

		return true;
	}
	// 6. 글출력---------------------------------------------------------------------------
		// 인수 : X [추후 페이징처리, 검색처리시 인수 O]	// 반환 : 모든 글이 담긴 ArrayList<board>	
	public ArrayList<Board> getList() {
		// 추후 페이징 처리, 검색 처리 등 로직
		return boardDB;
	}
	
	// 7. 글상세---------------------------------------------------------------------------
		// 인수 : 글번호		// 반환 : 글 하나 board	
	public Board getBoard(int bno) {
		boardDB.get(bno).setView(boardDB.get(bno).getView()+1);
		return boardDB.get(bno);	// 인수로 전달받은 인덱스[게시물번호]의 게시물 반환
	}
	// 8. 글삭제---------------------------------------------------------------------------
		// 인수 : 글번호		// 반환 : true [성공] false [실패]	// * 조회수 증가
	public boolean delete(int bno) {
		boardDB.remove(bno);		// 인수로 전달받은 인덱스[게시물번호]의 게시물 삭제
		Mcontroller.getInstance().getLogSession().getBoardList().remove(bno);
		return true;
	}
	// 9. 글수정---------------------------------------------------------------------------
		// 인수 : 글번호, newtitle, newcontent	// 반환 : true [성공] false [실패]
	public boolean update(int bno, String title, String content) {
		boardDB.get(bno).setTitle(title);		// 인수로 전달받은 인덱스[게시물번호]의 게시물 제목 수정
		boardDB.get(bno).setContent(content);	// 인수로 전달받은 인덱스[게시물번호]의 게시물 내용 수정
		return true;
	}
}
