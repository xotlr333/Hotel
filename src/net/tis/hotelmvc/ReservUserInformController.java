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
import net.tis.hotel.HotelSQL;



@WebServlet("/ReservUserInform.do")
public class ReservUserInformController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReservUserInformController() {
        super();
      
    }
    protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String roomSel = request.getParameter("roomSel");
		String tel = request.getParameter("tel");
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		
		HotelSQL sql = new HotelSQL();
		sql.reservInsert(name, pwd, tel, roomSel, checkin, checkout);
		
		request.setAttribute("name", name);
		request.setAttribute("checkin", checkin);
		request.setAttribute("checkout", checkout);
		request.setAttribute("tel", tel);
		request.setAttribute("pwd", pwd);
		request.setAttribute("roomsel", roomSel);
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher("hotel_reservSuccess.jsp");
		dis.forward(request, response);
    
	    
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
}
