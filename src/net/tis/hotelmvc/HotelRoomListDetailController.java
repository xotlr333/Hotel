package net.tis.hotelmvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tis.hotel.HotelSQL;
import net.tis.hotel.HotelDTO;


@WebServlet("/HotelRoomListDetail.do")
public class HotelRoomListDetailController extends HttpServlet {

	protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8"); 
    request.setCharacterEncoding("UTF-8");  //108페이지 인코딩 다른방식으로 기술
    PrintWriter  out  = response.getWriter(); 
    
    int number = Integer.parseInt(request.getParameter("idx"));
    
    HotelSQL sql = new HotelSQL();
    
    request.setAttribute("roomDetail", sql.RoomListDetail(number));
    
    RequestDispatcher dis = request.getRequestDispatcher("Hotel_roomListDetail.jsp");
    dis.forward(request, response);
		
	}//end
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

}
