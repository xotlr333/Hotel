package tis.hotel.QnA;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.tis.hotel.HotelReviewDTO;





public class QnASQL {
	 Connection CN; //db서버연결정보, 명령어생성할때 참조
	 Statement ST; //명령어생성 ST = CN.createStatement()
	 PreparedStatement PST; //속도가빠름 PST = CN.prepareStatement("insert~/update~")
	 CallableStatement CST ; //데이터베이스의 함수프로시저 사용 
	 ResultSet RS; //select조회한결과 RS=ST.executeQuery("select~~")
	 
	 String msg;//쿼리문장쓸때 사용
	 
	 String title,name,content;//dbinsert
	 int password,hit;//dbinsert
	 java.util.Date  wdate;//dbinsert
	 
	 String solution;//문의내역
	 
	 int Gtotal;//QnA총 개수
	 
	 public QnASQL() {
		  	try{
		  	   //순서1 db데이터베이스 드라이브연결
		  	   Class.forName("oracle.jdbc.driver.OracleDriver");
		  	   //System.out.println("Web0215플젝 오라클드라이브성공 2-18-목요일 10:15분 ");
		  	   
		  	   //순서2 db데이터베이스 서버정보주소및포트 계정id/pwd
		  	   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		  	   CN=DriverManager.getConnection(url ,"system","1234");
		  	   //System.out.println("Web0215플젝 오라클서버정보및 id,pwd 2-18-목요일 10:15분 ");
		  	 }catch(Exception ex){ System.out.println("db 에러 " + ex.toString());}
		  }//생성자 end=============================================================================================
	 
	 public void dbInsert(String title, String name, int password, String content) { //매개인자5개 기술하세요
		   try {
		  	 msg="insert into Hotel_QnA(title,name,password,content,wdate,hit) values(?, ?, ?, ?, sysdate,QnA_seq.nextval)";
		  	 PST=CN.prepareStatement(msg);
		  	 		  PST.setString(1, title);
		  	 		  PST.setString(2, name);
		  	 		  PST.setInt(3, password);
		  	 		  PST.setString(4, content); 
		  	 		  
		  	 PST.executeUpdate();
		  	 System.out.println(name+"이름  GuestSQL.java문서 dbInsert함수처리 저장성공했습니다");
		   }catch(Exception ex){System.out.println("저장에러 " + ex);}
		  }//end
	 
	 public ArrayList<QnADTO> dbSelectAll(int start, int end, String skey, String sval) { //페이징적용 1start, 10end, 검색필드, 검색키워드
		  	ArrayList<QnADTO> alist = new ArrayList<QnADTO>();
		    try {
		    	String a="select * from ( ";
		    	String b=" select rownum as rn, H.*  from ";
		    	String y="(select * from  Hotel_QnA where  "+skey+" like '%"+sval+"%')  H";
		    	String c=" ) where rn between "+ start + " and  " + end ;  
		   	 
		   	 msg = a+b+y+c; 
		   	 ST=CN.createStatement();
		   	 RS=ST.executeQuery(msg); 
			   	 while(RS.next()==true) {
			   		 QnADTO dto = new QnADTO(); 
			   		 dto.setRn(RS.getInt("rn"));
			   		 dto.setTitle(RS.getString("title"));
			   		 dto.setName(RS.getString("name"));
			   		 dto.setPassword(RS.getInt("Password"));
			   		 dto.setContent(RS.getString("content"));
			   		 dto.setWdate(RS.getDate("wdate"));
			   		 dto.setHit(RS.getInt("hit"));
			   		 alist.add(dto); 
			   	 }//while end
		   	  //System.out.println("GuestSQL.java문서 dbSelectAll함수처리 전체출력성공했습니다");
		    }catch(Exception ex){System.out.println("전체출력에러 " + ex);}
		  	return alist;
		  }//end========================================================================================
		  
	 public int getTotal(){ //전체레코드갯수
		  	try { 
		      msg="select count(*) as cnt from Hotel_QnA ";
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
		      msg="select count(*) as cnt from Hotel_QnA where "+skey+" like '%"+sval+"%' ";
		      ST=CN.createStatement();
		      RS=ST.executeQuery(msg);
		      if(RS.next()==true) {
		        Gtotal=RS.getInt("cnt");
		      }
		  	}catch(Exception ex){System.out.println("전체출력에러 " + ex);}
		  	return Gtotal;
		 }//end
	 
	 public QnADTO  dbDetail( int data ) { //한건상세출력  
		  	QnADTO dto = new QnADTO(); 
		  	try {
		   	 msg="select * from Hotel_QnA where hit = " + data ;
		   	 ST=CN.createStatement();
		   	 RS=ST.executeQuery(msg); 
			   	 if(RS.next()==true) {
			   		 dto.setTitle(RS.getString("title"));
			   		 dto.setName(RS.getString("name"));
			   		 dto.setPassword(RS.getInt("password"));
			   		 dto.setContent(RS.getString("content"));
			   		 dto.setWdate(RS.getDate("wdate"));
			   		 dto.setHit(RS.getInt("hit"));
			   		 dto.setSolution(RS.getString("solution"));
			   	 }//if end
		   	  System.out.println("QnASQL.java문서  dbDetail함수처리 전체출력성공했습니다"); 
		    }catch(Exception ex){System.out.println("한건상세에러 " + ex);}
		  	return dto; //ArrayList대신 한건이라서 GuestDTO=bean=dto=VO
		  }//end
	 
	 public void dbEdit(QnADTO dto) {
		  	try {
		  		msg="update Hotel_QnA set title=?,content=?,wdate=sysdate where hit=?";
		  		PST=CN.prepareStatement(msg);
		  				PST.setString(1, dto.getTitle()); //dto.setXXX(변경값) Edit컨트롤대입 
		  				PST.setString(2, dto.getContent());
		  				PST.setInt(3, dto.getHit());
		  				
		  		PST.executeUpdate(); 
		  	}catch(Exception ex){System.out.println("수정에러 " + ex);}
		  }//end
	 
	 public void dbSolutionInsert(String solution, int hit) { //매개인자5개 기술하세요
		   try {
		  	 msg="update Hotel_QnA set solution=? where hit=?";
		  	 PST=CN.prepareStatement(msg);
		  	 		  PST.setString(1, solution);
		  	 		  PST.setInt(2, hit);
		  	 PST.executeUpdate();
		  	 System.out.println("SQL.java문서 dbsInsert 저장성공했습니다");
		   }catch(Exception ex){System.out.println("저장에러 " + ex);}
		  }//end
	 
		public QnADTO dbConfirm(int data) {
			QnADTO dto = new QnADTO();
			try {
				msg="select * from Hotel_QnA where hit= " + data;
				ST= CN.createStatement();
				RS= ST.executeQuery(msg);
				if(RS.next()==true) {
					dto.setName(RS.getString("name"));
					dto.setPassword(RS.getInt("password"));
					}
				//System.out.println("dbConfirm 메소드 성공");
			}catch(Exception e){
				System.out.println("dbConfirm 메소드 에러" +e);}
			return dto;
		}
		
	 
	  public void dbDelete(int data) {
		  	try {
		  		msg="delete from Hotel_QnA where hit = " + data ;
		  		ST=CN.createStatement();
		  		ST.executeUpdate(msg);  //진짜삭제처리
		  	}catch(Exception ex){System.out.println("삭제에러 " + ex);}
		  }//end
}
