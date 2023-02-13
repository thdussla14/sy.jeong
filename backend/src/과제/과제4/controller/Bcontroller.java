package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class Bcontroller {
	// * DB 대용
	ArrayList<Board>boardDB = new ArrayList<>();

	// 1. 글 출력

	
	// 2. 글 선택
	public Board content(int ch) {
		
		Board result = boardDB.get(ch);		
		return result;
		
	}

	// 3. 글 쓰기
	public int write(String id, String title,String content,int count) {
		// 유효성 검사 공백 확인
		if(title==null) {return 1;}
		if(content==null) {return 2;}
		// 글 추가
		Board board = new Board(id, title,  content, 0);		
		boardDB.add(board);		
		return 0;		
	
	} // write e
	// 4. 글 삭제
	public int delete(int dch,String id) {
		// 유효성검사 작성자 id와 로그인 id 일치 확인
		if( boardDB.get(dch).id != id)
		{return 1;}
		// 글 삭제
		boardDB.remove(dch);		
		return 0;
	}

	// 5. 글 수정
	
	
	
	
}
