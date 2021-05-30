package tis.hotel.QnA;

import java.sql.*;  //임포트 

public class DB {

  public static Connection getConnection( ){ //static메소드, DB작업과 상관있음 리턴값확인
  	  Connection CN = null;
	    try {
		      //순서1 db데이터베이스 드라이브연결
			    Class.forName("oracle.jdbc.driver.OracleDriver");
			    //System.out.println("DB.java  오라클드라이브 연결성공 111 1:52분 ");
			    
			    //순서2 db데이터베이스 서버정보주소및포트 계정id/pwd
			    String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
			    CN=DriverManager.getConnection(url ,"system","1234");
			    //System.out.println("DB.java  오라클서버정보및 id,pwd 연결성공 222 1:52분 ");
	    }catch (Exception e){	System.out.println("DB.java 에러 " + e.toString());		}
	    return CN;
  }//end
	
}//class END
