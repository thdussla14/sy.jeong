package Day09.Ex10_게시판.controller;

import java.util.ArrayList;
import java.util.Date;
import Day09.Ex10_게시판.model.Board;

public class Bcontroller {

	// 1. 싱글톤
		// 1-1.
		private static Bcontroller bc = new Bcontroller();
		// 1-2. 생성자 private
		private Bcontroller() { }
		public static Bcontroller getInstance() {
			return bc;
		}
	
	// 필드	
	private ArrayList<Board> boardDB = new ArrayList<>();
		
	// 2. 글쓰기 함수
	public boolean write(String title, String content, String writer, String password, Date date, int view) {
		
		// 2-1. 유효성 검사 [생략] 
		
		// 2-2. 저장 [ DB 대신 리스트 ]
			// 1. 객체화 [ ]
			Board board = new Board(title, content, writer, password, date, view);
			// 2. 객체를 리스트에 담기
			boardDB.add(board);
		// 2-3. 결과 반환
		return true;
	}
		
	// 3. 모든 게시물 [여러개 -> list]출력 함수
	public ArrayList<Board> print() {
		return boardDB;
	
	}// print e
		
	// 4. 특정 게시물 [1개 -> object] 출력 함수
	public Board view(int bno) {		
		// * 조회수 올리기 // 객체명.set필드명 (객체명.get 필드명()+1;)
		boardDB.get(bno).setView(boardDB.get(bno).getView()+1);
		
		Board board = boardDB.get(bno);		
		return board;
	}
	
	// 5. 특정 게시물 삭제 함수
	public boolean delete(int bno) {
		boardDB.remove(bno);
		return true;
	}
	
}
