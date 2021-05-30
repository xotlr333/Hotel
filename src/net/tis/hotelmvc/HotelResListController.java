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


@WebServlet("/HotelResList.do")
public class HotelResListController extends HttpServlet {

	protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8"); 
    request.setCharacterEncoding("UTF-8");  //108페이지 인코딩 다른방식으로 기술
    PrintWriter  out  = response.getWriter(); 
    HotelSQL sql = new HotelSQL();
		int Gtotal = sql.getTotal() ;
    
		String pnum="", skey="", sval="", returnpage="", sqry="" ;
		int pageNUM;
		int start, end, startpage, endpage, pagecount, tmp;
		String display="";
		
		skey=request.getParameter("keyfield");     
		sval=request.getParameter("keyword"); 
		if(skey==null || skey=="" || sval=="" || sval==null || skey.equals("") || sval.equals("")) {
			  skey="name";  display=" ";
			  sval=""; 
		}
		
		int GGtotal=sql.getSearchTotal(skey, sval); 
		returnpage="&keyfield="+skey+"&keyword="+sval;
		
		pnum=request.getParameter("pageNum");
		if(pnum=="" || pnum==null){pnum="1"; }
		pageNUM=Integer.parseInt(pnum); 
		start=(pageNUM-1)*10+1; 
		end=(pageNUM*10);
		
		if(GGtotal%10==0){ pagecount=GGtotal/10; }
		else{pagecount=(GGtotal/10)+1; }
		
		tmp=(pageNUM-1)%10;
		startpage=pageNUM-tmp; 
		endpage=startpage+9;
		if(endpage>pagecount) {endpage=pagecount;}
    
    ArrayList<HotelDTO> reslist = sql.dbResSelect(start, end, skey, sval);
    
    request.setAttribute("reslist", reslist);
    request.setAttribute("Gtotal", Gtotal); 
		request.setAttribute("GGtotal", GGtotal);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("pagecount", pagecount);
		
		request.setAttribute("pageNUM", pageNUM);
		request.setAttribute("skey", skey);
		request.setAttribute("sval", sval);
		request.setAttribute("returnpage", returnpage);
		request.setAttribute("display", display);
    
    RequestDispatcher dis = request.getRequestDispatcher("HotelReservationList.jsp");
    dis.forward(request, response);
		
	}//end
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

}
