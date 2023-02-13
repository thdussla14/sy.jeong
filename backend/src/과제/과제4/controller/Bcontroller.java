package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class Bcontroller {
	
	// * DB 대용
	ArrayList<Board>boardDB = new ArrayList<>();

	// 1. 글 출력
	public ArrayList<Board> print(){
		return boardDB;
	}
	
	// 2. 글 선택
	public Board content(int ch) {		
		boardDB.get(ch).view += 1;
		Board result = boardDB.get(ch);		
		return result;		
	}

	// 3. 글 쓰기
	public int write(String id, String title,String content,int count) {
		// 글 추가
		Board board = new Board(id, title,  content, 0);		
		boardDB.add(board);		
		return 0;		
	
	} // write e
	
	// 4. 유효성검사
	public boolean check (int ch,String id) {		
		if( boardDB.get(ch).writer == id)
		{return true;}
		else {return false;}		
	}

	// 5. 글 삭제
	public int delete(int ch) {		
		boardDB.remove(ch);		
		return 0;
		
	}// delete e

	// 6. 글 수정
	public int rewrite(int ch, String recontent) {
		boardDB.get(ch).content = recontent;
		return 0;
	}// rewrite e
	
	
	
}
