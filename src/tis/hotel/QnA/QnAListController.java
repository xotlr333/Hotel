package tis.hotel.QnA;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/QnAList.do")
public class QnAListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");  //108페이지 인코딩 다른방식으로 기술
		PrintWriter  out  = response.getWriter(); 
		QnASQL qs = new QnASQL();
		int Gtotal = qs.getTotal() ;
		
		String pnum="", skey="", sval="", returnpage="", sqry="" ;
		int pageNUM;
		int start, end, startpage, endpage, pagecount, tmp;
		String display="";
		
		skey=request.getParameter("keyfield"); //skey="검색필드"; ~where name like  혹은 ~where title like  혹은 ~where email like    
		sval=request.getParameter("keyword"); //sval="검색키워드"; ~where 검색필드 like '%검색키워드%'  
		if(skey==null || skey=="" || sval=="" || sval==null || skey.equals("") || sval.equals("")) {
			  skey="title";  display=" ";
			  sval=""; 
		}
		
		int GGtotal=qs.getSearchTotal(skey, sval); //2-24-수요일 추가GGtotal보다는 Searchtotal권장
		//returnpage="guestList.do?pageNum=3&keyfield=name&keyword=b"; //3페이지 title필드  p검색어  조회
		returnpage="&keyfield="+skey+"&keyword="+sval; //3페이지 title필드  p검색어  조회
		
		pnum=request.getParameter("pageNum");
		if(pnum=="" || pnum==null){pnum="1"; }
		pageNUM=Integer.parseInt(pnum); //[11]~[17클릭]~[20]클릭번호  숫자형17
		start=(pageNUM-1)*10+1; //161=pageNUM*10-9
		end=(pageNUM*10); //170=start+9
		
		if(GGtotal%10==0){ pagecount=GGtotal/10; }
		else{pagecount=(GGtotal/10)+1; }
		
		tmp=(pageNUM-1)%10;
		startpage=pageNUM-tmp; 
		endpage=startpage+9;
		//총레코드데이터갯수 316라서 최종페이지는 32인데  [31]~[40]표시를 [31][32] 
		if(endpage>pagecount) {endpage=pagecount;}
		
		ArrayList<QnADTO> QnA = qs.dbSelectAll(start, end, skey, sval);  //시작행,끝행,기준필드,검색키워드
		request.setAttribute("QnA", QnA);
		request.setAttribute("Gtotal", Gtotal);   //전체갯수
		request.setAttribute("GGtotal", GGtotal); //조회갯수
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("pagecount", pagecount);
		
		request.setAttribute("pageNUM", pageNUM); //[7]숫자7 
		request.setAttribute("skey", skey);
		request.setAttribute("sval", sval);
		request.setAttribute("returnpage", returnpage);
		request.setAttribute("display", display);
		
		RequestDispatcher dis = request.getRequestDispatcher("HotelQ&AList.jsp");
		dis.forward(request, response);
		
		
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

}
