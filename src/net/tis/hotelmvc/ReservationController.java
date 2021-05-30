package net.tis.hotelmvc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.tis.hotel.HotelReservationSQL;



@WebServlet("/reservation.do")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReservationController() {
        super();
      
    }
    protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		String from = request.getParameter("from");
		String to  = request.getParameter("to");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
				  
		
		int adult = Integer.parseInt(request.getParameter("adult"));
		int children =Integer.parseInt(request.getParameter("children"));
		
	    
	    HotelReservationSQL sql =new HotelReservationSQL();
	    sql.dbReservationInsert(adult, children, from, to, name, email, phone);
		
	  
	      request.setAttribute("from", from);
	      request.setAttribute("to", to);
	      request.setAttribute("name", name);
	      request.setAttribute("email", email);
	      request.setAttribute("phone", phone);
	      request.setAttribute("adult", adult);
	      request.setAttribute("children", children);
		
	   RequestDispatcher dis = request.getRequestDispatcher("hotel_ReservationConfirm.jsp");
	   dis.forward(request, response);
	    
	    
	   
	    
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
}
