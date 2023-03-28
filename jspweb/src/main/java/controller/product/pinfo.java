package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dao.MemberDao;
import model.Dao.ProductDao;
import model.Dto.ProductDto;


@WebServlet("/productinfo")
public class pinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public pinfo() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String 동 = request.getParameter("동");
		String 서 = request.getParameter("서");
		String 남 = request.getParameter("남");
		String 북 = request.getParameter("북");
		
		System.out.println(동+서+남+북); 
		
		ArrayList<ProductDto> plist = ProductDao.getInstantce().getPlist(동,서,남,북);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonarray = mapper.writeValueAsString(plist);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// ----------------- commons.jar 사용시 ---------------------------------------------------
		
		request.setCharacterEncoding("UTF-8");
		
		// 1. 다운로드할 서버 경로
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		// 2. 해당 경로의 파일/ 폴더 객체화 [ setRepository에 대입하기 위해서 ] 
		File 저장경로객체 = new File(path);
		// 3. 업로드할 저장소 객체 생성
		DiskFileItemFactory 파일저장소 = new DiskFileItemFactory();
		파일저장소.setRepository(저장경로객체);			// 파일저장소 위치 대입
		파일저장소.setSizeThreshold(1024*1024*10);		// 파일저장소 최대 저장 용량
		파일저장소.setDefaultCharset("UTF=8");			// 파일저장소 한글 인코딩 타입
		// 4. 파일 업로드 객체
		ServletFileUpload 파일업로드객체 = new ServletFileUpload(파일저장소);
		
		try {
			// 5. 매개변수 요청해서 리스트에 담기 [ 무조건 예외처리 ] 			
			List<FileItem> 파일아이템목록 = 파일업로드객체.parseRequest(request);
				// 5-1. 타입 분류
				List<String> 일반필드목록 = new ArrayList<>();
				List<String> 파일필드목록 = new ArrayList<>();
			// 6. 
			for(FileItem item : 파일아이템목록) {
				
				// 7. .isFormField : 첨부파일이 아니면 true / 첨부파일이면 false
				if(item.isFormField()) {
					System.out.println("첨부파일 아닌 필드명"+item.getFieldName());
					System.out.println(item.getString());
					일반필드목록.add(item.getString());
					
				}else {
					System.out.println("첨부파일 필드명"+item.getFieldName());
					
					// 9. 첨주파일 이름 식별이름 변경 
						// 9-1. 파일명에 공백이 존재하면 '-' 치환  [ .replaceAll ("기존문자","새로운문자") 문자열 치환 함수 ] 
						// 9-2. UUID : 중복되지 않는 ID를 만들기 위한 범용 고유 식별자 
					String filename = UUID.randomUUID()+" "+(item.getName().replaceAll(" ", "-"));
					System.out.println(filename);
					파일필드목록.add(filename);
					// 8. 저장할 경로 +"/" +파일명 파일 객체화
					File 업로드할파일 = new File(path+"/"+filename);
					// 해당 파일 객체 저장
					item.write(업로드할파일);					
				}
			}
			System.out.println(일반필드목록);
			int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login")); System.out.println("mno"+mno);
			
			ProductDto dto = new ProductDto(일반필드목록.get(0), 일반필드목록.get(1), Integer.parseInt(일반필드목록.get(2)), 일반필드목록.get(3),일반필드목록.get(4), mno, 파일필드목록);
			
			System.out.println(dto);	
			
			boolean result = ProductDao.getInstantce().register(dto);
			
			response.getWriter().print(result);
					
		}catch (Exception e) { System.out.println(e);}
		
		
		
		
		
		
		// ----------------- cos.jar 사용시 ---------------------------------------------------
		/* 
		 * String path =
		 * request.getSession().getServletContext().getRealPath("product/pimg");
		 * 
		 * MultipartRequest multi = new MultipartRequest(request,
		 * path,1024*1024*10,"UTF-8",new DefaultFileRenamePolicy());
		 * 
		 * String pname = multi.getParameter("pname"); System.out.println(pname); String
		 * pcontent = multi.getParameter("pcontent"); System.out.println(pcontent); int
		 * pprice = Integer.parseInt(multi.getParameter("pprice"));
		 * System.out.println(pprice); String plat = multi.getParameter("plat");
		 * System.out.println(plat); String plang = multi.getParameter("plang");
		 * System.out.println(plang);
		 * 
		 * // 첨부파일 1개 이름 가져오기 String pfile = multi.getFilesystemName("pfile");
		 * 
		 * // 첨부파일 여러개 이름 가져오기 multiple X String pfile1 =
		 * multi.getFilesystemName("pfile1"); String pfile2 =
		 * multi.getFilesystemName("pfile2"); String pfile3 =
		 * multi.getFilesystemName("pfile3");
		 * 
		 * // 첨부파일 여러개 이름 가져오기 multiple O // multiple input에 등록된 여러 사진들의 이름 가져오기 불가능
		 * [cos.jar 제공 X ] // 따라서 다른 라이브러리 사용 // input type=file 태그명 호출 Enumeration
		 * pfiles = multi.getFileNames();
		 * 
		 * while(pfiles.hasMoreElements()) { // pfiles 에 element 존재 [true] / 없음 [ false]
		 * String s = (String)pfiles.nextElement(); System.out.println(s); }
		 * 
		 * 
		 * ProductDto dto = new ProductDto(pprice, pname, pcontent, pprice, pprice,
		 * plat, plang, pprice, null); boolean result =
		 * ProductDao.getInstantce().register(dto); response.getWriter().print(result);
		 */
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
