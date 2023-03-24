package controller.product;

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

		String path = request.getSession().getServletContext().getRealPath("product/pimg");
		
		MultipartRequest multi = new MultipartRequest(request, path,1024*1024*10,"UTF-8",new DefaultFileRenamePolicy());
		
		String pname 	= multi.getParameter("pname");						System.out.println(pname);
		String pcontent = multi.getParameter("pcontent");					System.out.println(pcontent);
		int	   pprice 	= Integer.parseInt(multi.getParameter("pprice")); 	System.out.println(pprice);
		String plat 	= multi.getParameter("plat");						System.out.println(plat);
		String plang 	= multi.getParameter("plang");						System.out.println(plang);
		
		ProductDto dto = new ProductDto(pprice, pname, pcontent, pprice, pprice, plat, plang, pprice, null);
		boolean result = ProductDao.getInstantce().register(dto);
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
