package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Dao.BoardDao;
import model.Dao.MemberDao;
import model.Dto.BoardDto;

@WebServlet("/boardinfo")
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Boardinfo() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// * 현재 서버의 경로 찾기 
 		String uploadpath = request.getSession().getServletContext().getRealPath("/board/bfile");
 		System.out.println("path : "+uploadpath);
 		// * 파일 복사 [ 입력받은 [file] 대용량 바이트 복사하기 ]
 		MultipartRequest multi = new MultipartRequest(
 				request,						// 요청방식
 				uploadpath,						// 첨부파일 가져와서 저장할 서버내 폴더
 				(1024*1024*10),	//10MB			// 첨부파일 허용 범위 용량 [ 바이트단위 ]
 				"UTF-8",						// 첨부파일 한글 인코딩
 				new DefaultFileRenamePolicy()	// 동일한 첨부파일명이 존재하면 뒤에 숫자 붙여서 식별
 		);
 		System.out.println("multi : "+multi);
 		// 
 		int     cno 		= Integer.parseInt(multi.getParameter("cno"));			
 		String 	btitle		= multi.getParameter("btitle");							
		String 	bcontent 	= multi.getParameter("bcontent");						
		String 	bfile 		= multi.getFilesystemName("bfile");						
		// 공백입력시 
		if(btitle.length()==0||bcontent.length()==0) {response.getWriter().print("false");}
		// 로그인한 회원 mno 필요
		String  mid = (String)request.getSession().getAttribute("login"); 
		int 	mno = MemberDao.getInstance().getMno(mid);		
		if (mno < 1) {response.getWriter().print("false");}
		// 정보 객체에 담기 
		BoardDto bdto = new BoardDto(btitle, bcontent, bfile, mno, cno);
		// Dao에 응답 요청 
		boolean result = BoardDao.getInstance().bwrite(bdto);
		// 응답
		response.getWriter().print(result);
	}
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int type = Integer.parseInt(request.getParameter("type"));
				
		if(type==1) { 			// 1. 전체 게시물 조회
			ArrayList<BoardDto> list = BoardDao.getInstance().getBlist();
			ObjectMapper mapper = new ObjectMapper();
			String jsonarray = mapper.writeValueAsString(list);			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("appication/json");
			response.getWriter().print(jsonarray);	
		}else if(type==2) {		// 2. 선택 게시물 조회
			int bno = Integer.parseInt(request.getParameter("bno"));			
			BoardDto result = BoardDao.getInstance().selectBoard(bno);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);	
			response.setCharacterEncoding("UTF-8");
			response.setContentType("appication/json");
			response.getWriter().print(json);
		}else if(type==3) {		// 3. 검색 게시물 조회			
			request.setCharacterEncoding("UTF-8");
			int    search      = Integer.parseInt(request.getParameter("search"));
			String searchinput = request.getParameter("searchinput");
			System.out.println(search);
			System.out.println(searchinput);
			ArrayList<BoardDto> list = BoardDao.getInstance().getBlist();
			if 		(search==1) {list = BoardDao.getInstance().searchBoard_T(searchinput);}
			else if (search==2) {list = BoardDao.getInstance().searchBoard_M(searchinput);}
			else if (search==3) {list = BoardDao.getInstance().searchBoard_D(searchinput);}
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(list);	
			response.setCharacterEncoding("UTF-8");
			response.setContentType("appication/json");
			response.getWriter().print(json);
		}
		

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
