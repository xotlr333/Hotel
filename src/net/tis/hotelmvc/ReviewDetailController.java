package net.tis.hotelmvc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tis.hotel.HotelReviewDTO;
import net.tis.hotel.HotelReviewSQL;



@WebServlet("/reviewDetail.do")
public class ReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReviewDetailController() {
        super();
      
    }
    protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		ServletContext ct = this.getServletContext();
		String path = ct.getRealPath("storage");
		
		int data = Integer.parseInt(request.getParameter("idx"));
		
		HotelReviewSQL sql = new HotelReviewSQL();
        HotelReviewDTO dto =sql.dbDetail(data);
        sql.dbhits(data);
		request.setAttribute("dto", dto);
		request.setAttribute("path", path);		
		RequestDispatcher dis = request.getRequestDispatcher("hotel_ReviewDetail.jsp");
		dis.forward(request, response);
    
	    
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
}
