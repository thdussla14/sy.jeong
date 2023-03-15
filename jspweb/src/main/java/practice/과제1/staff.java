package practice.과제1;

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


@WebServlet("/staff")
public class staff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staff() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String result = null;
		if( type.equals("1") ) { 	 // 수정 선택 사원
			int sno = Integer.parseInt(request.getParameter("sno"));
			Sdto staff = Dao.getInstance().selectStaff(sno);
			
			ObjectMapper objectMapper = new ObjectMapper();
			result = objectMapper.writeValueAsString(staff);
		}else if( type.equals("2") ) { // 전체 사원
			// 요청 없음
			// Dao로 부터 데이터 받아 저장
			ArrayList<Sdto> list = Dao.getInstance().getStaff();
			// 응답 가능 언어로 인코딩
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(list);		
		}else if(type.equals("3") ) {
	         ArrayList<Fdto> list = Dao.getInstance().getfield();
	         System.out.println(list);
	         ObjectMapper mapper = new ObjectMapper();
	         result = mapper.writeValueAsString(list);
	         
		}else if( type.equals("4") ) { // 사원 검색 
			// 요청
			request.setCharacterEncoding("UTF-8");
			String search = request.getParameter("search");
			System.out.println(search);
			ArrayList<Sdto> list = Dao.getInstance().seachStaff(search);
			
			// 응답 가능 언어로 인코딩
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(list);		
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( result );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("practice/과제1/simg");
		
		MultipartRequest multi = new MultipartRequest(
			request,  						// 1. 요청방식 
			path , 							// 2. 첨부파일 가져와서 저장할 서버내 폴더 
			1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
			"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
			new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
		);
		
		String sname = multi.getParameter("sname");
		String sclass = multi.getParameter("sclass");
		String stype = multi.getParameter("stype");
		String field = multi.getParameter("field");
		String edate = multi.getParameter("edate");
		String simg = multi.getFilesystemName("simg");
		
		Sdto sdto = new Sdto(0, sname, sclass, stype, field, edate, simg, null, null);
		System.out.println(sdto);
		
		boolean result = Dao.getInstance().insert(sdto);
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("practice/과제1/simg");
		
		MultipartRequest multi = new MultipartRequest(
			request,  						// 1. 요청방식 
			path , 							// 2. 첨부파일 가져와서 저장할 서버내 폴더 
			1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
			"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
			new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
		);
		
		int sno = Integer.parseInt(multi.getParameter("update_sno"));
		String sname    = multi.getParameter("update_sname");
		String sclass   = multi.getParameter("update_sclass");
		String stype    = multi.getParameter("update_stype");
		String field    = multi.getParameter("update_field");
		String simg     = multi.getFilesystemName("update_simg");
		String ddate    = multi.getParameter("update_ddate");
		String dcontent = multi.getParameter("update_dcontent");
		if(simg  == null)  {simg  = Dao.getInstance().selectStaff(sno).getSimg();}
		
		if(!ddate.contains("-"))    	{ddate=null;}
		if(dcontent.length()==0)    	{dcontent=null;}
		Sdto sdto = new Sdto(sno, sname, sclass, stype, field, null, simg, ddate, dcontent);
		System.out.println(sdto);
		
		boolean result = Dao.getInstance().updateStaff(sdto);
		response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 요청 받음
				int sno = Integer.parseInt(request.getParameter("sno")); 
				// Dao로 부터 데이터 받아 저장
				boolean result = Dao.getInstance().deleteStaff(sno);
				// 응답
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(result);
	}

}
