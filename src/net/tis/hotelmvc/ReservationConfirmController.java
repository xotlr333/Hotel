package net.tis.hotelmvc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.tis.hotel.HotelReservationDTO;
import net.tis.hotel.HotelReservationSQL;



@WebServlet("/reservationConfirm.do")
public class ReservationConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReservationConfirmController() {
        super();
      
    }
    protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String wdate = request.getParameter("wcheckout");
		String wname = request.getParameter("wname");
		String wphone = request.getParameter("wphone");
		
		HotelReservationSQL rsql = new HotelReservationSQL();
		HotelReservationDTO rdto =rsql.ReservationConfirm(wdate, wname, wphone);
		String wnamec = rdto.getName();
		String wphonec = rdto.getTel();
		
		if(wname.equals(wnamec)&& wphone.equals(wphonec)){
			response.sendRedirect("hotel_ReviewWrite.jsp");
	    }else{
				String msg="회원 정보가 없습니다. 예약 후 후기를 작성해주세요." ;
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
