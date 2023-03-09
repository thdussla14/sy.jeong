package controller.member;

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

import model.Dao.MemberDao;
import model.Dto.MemberDto;

@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Info() {
        super();
    }
    
    /* 1. 회원가입 [ 첨부파일 없을때 ]
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력된 데이터 받기 
		request.setCharacterEncoding("UTF-8");
		String mid 		= request.getParameter("mid");
		String mpw 		= request.getParameter("mpw");
		String memail 	= request.getParameter("memail");
		String mimg 	= request.getParameter("mimg");
		// 2. 전달 객체에 데이터 담기
		MemberDto mdto = new MemberDto(0, mid, mpw, mimg, memail);
		// 3. Dao에게 객체 전달
		boolean result = MemberDao.getInstance().signup(mdto);
		System.out.println(mdto);
		// 4. 결과 응답
		response.getWriter().print(result);		
	}
	*/
    
    /*
   		MultipartRequest 클래스
    		1. 요청방식 : HTTP request
 			2. 저장폴더 :  1. 프로젝트 (git)    2. 서버 (워크스페이스)
 			
 				 * 현재 프로젝트의 경로 찾기
 						String path = "C:\\Users\\504\\git\\sy.jeong\\jspweb\\src\\main\\webapp\\member\\pimg";
 				* 현재 서버의 경로 찾기 
 						String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
 						
 			3. 첨부파일 허용 범위 용량 [ 바이트단위 ]
 			4. 첨부파일 한글 인코딩
 			5. 동일한 첨부파일명이 존재하면 뒤에 숫자 붙여서 식별
   
     */
    
    
    // 1. 회원가입 [ 첨부파일 있을때 ] --> request 는 첨부파일(대용량) 에 대한 요청이 불가능 -> 외부 라이브러리 사용 cos.jar ( build path 추가 , WEB-INF -> lib 추가 )
   
    
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// * 현재 프로젝트의 경로 찾기
 		// String path = "C:\\Users\\504\\git\\sy.jeong\\jspweb\\src\\main\\webapp\\member\\pimg";
 		// * 현재 서버의 경로 찾기 
 		String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
 		// * 업로드
 		MultipartRequest multi = new MultipartRequest(
 				request,						// 요청방식
 				uploadpath,						// 첨부파일 가져와서 저장할 서버내 폴더
 				(1024*1024*10),	//10MB			// 첨부파일 허용 범위 용량 [ 바이트단위 ]
 				"UTF-8",						// 첨부파일 한글 인코딩
 				new DefaultFileRenamePolicy()	// 동일한 첨부파일명이 존재하면 뒤에 숫자 붙여서 식별
 				);
 		String mid 		= multi.getParameter("mid");		// form 전송시 input 식별 name 식별자 사용
		String mpw 		= multi.getParameter("mpw");
		String memail 	= multi.getParameter("memail");
		String mimg 	= multi.getFilesystemName("mimg");	// 첨부된 파일명 호출[]
		
		MemberDto mdto = new MemberDto(0, mid, mpw, mimg, memail);
		// 3. Dao에게 객체 전달
		boolean result = MemberDao.getInstance().signup(mdto);
		System.out.println(mdto);
		// 4. 결과 응답
		response.getWriter().print(result);	
		
		
	}
    // 2. 회원1명 / 회원 여러명 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Dao에게 회원리스트 요청 받아 저장
		ArrayList<MemberDto> list = MemberDao.getInstance().getMemberList();
		// 2. JAVA 객체 -> JS 객체 형변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonarray = objectMapper.writeValueAsString(list);
		// 3. 응답
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
		
	}
	// 3. 회원정보 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	// 4. 회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
