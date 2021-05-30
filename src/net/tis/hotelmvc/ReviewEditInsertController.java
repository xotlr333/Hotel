package net.tis.hotelmvc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import net.tis.hotel.HotelReviewSQL;



@WebServlet("/reviewEditInsert.do")
public class ReviewEditInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReviewEditInsertController() {
        super();
      
    }
    protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		
	
		ServletContext ct = this.getServletContext();
		String path = ct.getRealPath("storage");
		
		//System.out.println("파일저장경로" +path);
		
		
	
		int size = 1024*1024*7;
		MultipartRequest mr = new MultipartRequest(request, path, size, "UTF-8");
		
		int data = Integer.parseInt(mr.getParameter("code"));
		String title =mr.getParameter("title");
		String name = mr.getParameter("name");
		String pwd = mr.getParameter("pwd");
		String content = mr.getParameter("content");
		String wimg = mr.getFilesystemName("file1");
		if(wimg==null || wimg==""){wimg="noimg.jpg";}
		int rating = Integer.parseInt(mr.getParameter("rating"));
		
		HotelReviewSQL sql= new HotelReviewSQL();
		sql.dbDelete(data);
				
		sql.dbEditInsert(data, title, name, pwd, content,wimg, rating);
		
					
	    response.sendRedirect("reviewList.do");
	    
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
}
