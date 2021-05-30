package net.tis.hotelmvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tis.hotel.HotelNoticeDTO;
import net.tis.hotel.HotelNoticeSQL;
import net.tis.hotel.HotelReviewDTO;
import net.tis.hotel.HotelReviewSQL;


@WebServlet("/reviewList.do")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public ReviewListController() {
        super();
      
    }
    protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		ServletContext ct = this.getServletContext();
		String path = ct.getRealPath("storage");
		
		String pageNum;
		int pageNUM, start, end, startpage, endpage, tmp, Gtotal, countpage,Stotal;
		
		
		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");
		
		request.setAttribute("keyfield", keyfield);
		
		request.setAttribute("keyword", keyword);
		
		if(keyfield== null || keyfield=="" || keyword ==null ||keyword ==""){
			keyfield="title";
			keyword ="";
		}
			
		pageNum= request.getParameter("pageNum");
		if(pageNum=="" || pageNum == null){pageNum="1";}
		
		pageNUM = Integer.parseInt(pageNum);
		
		start = (pageNUM*3)-2;
		end = start+2;
		
				
		tmp = (pageNUM-1)%10;
		startpage = pageNUM-tmp;
		endpage = startpage+9;
			
        HotelReviewSQL sql = new HotelReviewSQL();
        ArrayList<HotelReviewDTO> list=sql.dbSearchSelect(keyfield, keyword,start,end);
		request.setAttribute("list", list);
		
		Gtotal= sql.dbgetTotal();
		Stotal =sql.dbSearchTotal(keyfield,keyword);
		
		if(Stotal%3==0) {countpage=Stotal/3;
		}else {countpage=(Stotal/3)+1;}
		
		if(endpage>countpage){endpage=countpage;}
				
		request.setAttribute("path", path);
				
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("Gtotal", Gtotal);
		request.setAttribute("countpage", countpage);
		request.setAttribute("Stotal", Stotal);
		request.setAttribute("pageNUM", pageNUM);
		
		 
		HotelNoticeSQL nsql = new HotelNoticeSQL();	
		ArrayList<HotelNoticeDTO> ndto =nsql.dbSelect();
		
		request.setAttribute("ndto", ndto);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("hotel_ReviewNoticeList.jsp");
		dis.forward(request, response);
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
}
