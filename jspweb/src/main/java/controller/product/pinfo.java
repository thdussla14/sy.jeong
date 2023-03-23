package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/productinfo")
public class pinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public pinfo() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getSession().getServletContext().getRealPath("product/pimg");
		
		MultipartRequest multi = new MultipartRequest(request, path,1024*1024*10,"UTF-8",new DefaultFileRenamePolicy());
		
		String pname 	= multi.getParameter("pname");						System.out.println(pname);
		String pcontent = multi.getParameter("pcontent");					System.out.println(pcontent);
		int	   pprice 	= Integer.parseInt(multi.getParameter("pprice")); 	System.out.println(pprice);
		String plat 	= multi.getParameter("plat");						System.out.println(plat);
		String plang 	= multi.getParameter("plang");						System.out.println(plang);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
