package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class Bcontroller {
	// * DB 대용
	ArrayList<Board>boardDB = new ArrayList<>();

	// 1. 글 출력
	
	// 2. 글 선택
	
	// 3. 글 쓰기
	public int write(String id, String title,String content,int count) {
		
		if(title==null) {return 1;}
		if(content==null) {return 2;}
	
		Board board = new Board(id, title,  content, 0);
		
		boardDB.add(board);
		
		return 0;
		
	
	} // write e
	// 4. 글 삭제
	
	// 5. 글 수정
	
	
	
	
}
