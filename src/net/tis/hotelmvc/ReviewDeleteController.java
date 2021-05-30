package net.tis.hotelmvc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tis.hotel.HotelReviewDTO;
import net.tis.hotel.HotelReviewSQL;



@WebServlet("/reviewDelete.do")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReviewDeleteController() {
        super();
      
    }
    protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		int data = Integer.parseInt(request.getParameter("code"));
		String id = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		HotelReviewSQL sql = new HotelReviewSQL();
		HotelReviewDTO dtoc = sql.dbConfirm(data);
		String idc = dtoc.getName();
		String pwdc = dtoc.getPwd();
		 

		
		
	   if(id.equals(idc)&&pwd.equals(pwdc)) 
	     	{ sql.dbDelete(data);
		    response.sendRedirect("reviewList.do");
       }else{
			String msg="회원 정보가 일치하지 않아 삭제할 수 없습니다." ;
			out.print("<script>");
			out.print("alert('" +msg + "');");
			out.print("history.go(-2)");
			out.print("</script>");}
	   
			
	    
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
}
