package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Ex3Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Board() {
        super();
    }
    // 1. 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청시 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		// 2. 매개변수 요청 [ AJAX data 속성 
		String content 	= request.getParameter("content");
			System.out.println(content);
		String writer	= request.getParameter("writer");
			System.out.println(writer);
		// 3. Dto 객체	[ 기본값 : int 0 / 객체 null ] 
		BoardDto boardDto = new BoardDto(0, content, writer, null);
		// 4. Dao 호출 후 결과 저장
		boolean result = BoardDao.getInstance().onwrite(boardDto);
		// 5. Dao 결과 true/false 데이터 response
		response.getWriter().print(result);
		
	}

	// 2. 불러오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 응답 매개 변수 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		// 2. Dao에서 데이터 받아오기
		ArrayList<BoardDto> list = BoardDao.getInstance().onlist();
		// 3. 
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonarray = objectMapper.writeValueAsString(list);
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
	}

	// 3. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 삭제할 게시물 번호 요청 
		int bno = Integer.parseInt(request.getParameter("bno")); System.out.println(bno);
		// 2. Dao 호출 후 결과 저장
		boolean result = BoardDao.getInstance().onDelete(bno);
		// 3. 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);	
	}
	
	// 4. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 수정할 게시물 번호 요청
		int bno = Integer.parseInt(request.getParameter("bno")); System.out.println(bno);
		// 수정할 새로운 내용 요청
		String newContent = request.getParameter("newContent");
		// 2. Dao 호출 후 결과 저장
		boolean result = BoardDao.getInstance().onUpdate(bno,newContent);
		// 3. 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
