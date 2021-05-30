package net.tis.hotel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.tis.hotel.HotelDTO;
import tis.hotel.QnA.QnADTO;

public class HotelSQL {

	
	 Connection CN; //db서버연결정보, 명령어생성할때 참조
	 Statement ST; //명령어생성 ST = CN.createStatement()
	 PreparedStatement PST; //속도가빠름 PST = CN.prepareStatement("insert~/update~")
	 CallableStatement CST ; //데이터베이스의 함수프로시저 사용 
	 ResultSet RS; //select조회한결과 RS=ST.executeQuery("select~~")
	 
	 int Ghit, Gsabun, Gpay ;
	 String  Gtitle, Gcontent, Gwriter, Gname, Gemail ;
	 java.util.Date  Gwdate;
	 
	 int GGtotal, Gtotal;
	 String msg, a, b, c, d;  //msg="dml쿼리문기술 insert~/select~/update~/delete~"
	 String data, pageN ;  //data=request.getParameter("idx");
	 
	 public HotelSQL(){
		 try{
		   //순서1 db데이터베이스 드라이브연결
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   
		   //순서2 db데이터베이스 서버정보주소및포트 계정id/pwd
		   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		   CN=DriverManager.getConnection(url ,"system","1234");
		   
		   ST=CN.createStatement(); //권장
		 }catch(Exception ex){ System.out.println("db 에러 " + ex.toString());}
	 }//end
	 
	 public ArrayList<HotelDTO>  RoomList() {
		 ArrayList<HotelDTO> alist = new ArrayList<HotelDTO>();
		 try {
			 
		 msg="select rownum rn,r.* from roomList r";
		 RS=ST.executeQuery(msg);
		 while(RS.next()) {
			 HotelDTO dto = new HotelDTO();
			 dto.setRn(RS.getInt("rn"));
			 dto.setNumber(RS.getInt("room_number"));
			 dto.setName(RS.getString("room_name"));
			 dto.setImg(RS.getString("room_img"));
			 
			 alist.add(dto);
			 
		 }//while end
		 
		 }catch(Exception ex){ System.out.println("roomList 에러 " + ex.toString());}
		 return alist;
	 }//end
	 
	 public ArrayList<HotelDTO> dbResSelect(int start, int end, String skey, String sval) { //페이징적용 1start, 10end, 검색필드, 검색키워드
	  	ArrayList<HotelDTO> alist = new ArrayList<HotelDTO>();
	    try {
	    	String a="select * from ( ";
	    	String b=" select rownum as rn, H.*  from ";
	    	String y="(select * from  reserve where  "+skey+" like '%"+sval+"%')  H";
	    	String c=" ) where rn between "+ start + " and  " + end ;  
	   	 
	   	 msg = a+b+y+c; 
	   	 ST=CN.createStatement();
	   	 RS=ST.executeQuery(msg); 
		   	 while(RS.next()==true) {
		   		 HotelDTO dto = new HotelDTO(); 
		   		 dto.setRn(RS.getInt("rn"));
		   		 dto.setName(RS.getString("name"));
		   		 dto.setRoom(RS.getString("roomSel"));
		   		 dto.setCheckIn(RS.getString("checkIn"));
		   		 dto.setCheckOut(RS.getString("checkOut"));
		   		 dto.setCode(RS.getInt("code"));
		   		 alist.add(dto); 
		   	 }//while end
	   	  //System.out.println("GuestSQL.java문서 dbSelectAll함수처리 전체출력성공했습니다");
	    }catch(Exception ex){System.out.println("전체출력에러 " + ex);}
	  	return alist;
	  }//end
	 
	 
	 public int getTotal(){ //전체레코드갯수
	  	try { 
	      msg="select count(*) as cnt from reserve ";
	      ST=CN.createStatement();
	      RS=ST.executeQuery(msg);
	      if(RS.next()==true) {
	        Gtotal=RS.getInt("cnt");
	      }
	  	}catch(Exception ex){System.out.println("전체출력에러 " + ex);}
	  	return Gtotal;
	 }//end

	 public int getSearchTotal(String skey, String sval){ //검색레코드갯수
	  	try { 
	      msg="select count(*) as cnt from reserve where "+skey+" like '%"+sval+"%' ";
	      ST=CN.createStatement();
	      RS=ST.executeQuery(msg);
	      if(RS.next()==true) {
	        Gtotal=RS.getInt("cnt");
	      }
	  	}catch(Exception ex){System.out.println("전체출력에러 " + ex);}
	  	return Gtotal;
	 }//end
	 
	 public HotelDTO RoomListDetail(int num) {
		 HotelDTO ddto = new HotelDTO();
		 try {
			 msg="select * from roomList where room_number = " + num;
			 RS=ST.executeQuery(msg);
			 RS.next();
				 
				 ddto.setNumber(RS.getInt("room_number"));
				 ddto.setName(RS.getString("room_name"));
				 ddto.setContent(RS.getString("room_content"));
				 ddto.setImg(RS.getString("room_img"));
				 ddto.setView(RS.getString("room_view"));
				 ddto.setArea(RS.getString("room_area"));
			 
			 }catch(Exception ex){ System.out.println("roomListDetail 에러 " + ex.toString());}
		 	return ddto;
	 }//end
	 
	 public void reservInsert(String n, int p, String t, String rs, String ci, String co) {
		 try {
			 msg="insert into reserve values(?, ?, ?, ?, ?, ?, res_seq.nextval )";
			 PST=CN.prepareStatement(msg);
			 		PST.setString(1, n);
			 		PST.setInt(2, p);
			 		PST.setString(3, t);
			 		PST.setString(4, rs);
			 		PST.setString(5, ci);
			 		PST.setString(6, co);
			 		PST.executeUpdate();
					System.out.println("저장 성공");
			 }catch(Exception ex){ System.out.println("예약 에러 " + ex.toString());}
	 }//end
	 
		public HotelDTO dbConfirm(int data) {
			HotelDTO dto = new HotelDTO();
			try {
				msg="select * from reserve where code= " + data;
				ST= CN.createStatement();
				RS= ST.executeQuery(msg);
				if(RS.next()==true) {
					dto.setName(RS.getString("name"));
					dto.setPwd(RS.getInt("pwd"));
					}
			}catch(Exception e){
				System.out.println("dbConfirm 메소드 에러" +e);}
			return dto;
		}//end
		
	  public void dbDelete(int data) {
	  	try {
	  		msg="delete from reserve where code = " + data ;
	  		ST=CN.createStatement();
	  		ST.executeUpdate(msg);  //진짜삭제처리
	  	}catch(Exception ex){System.out.println("삭제에러 " + ex);}
	  }//end
	
}
