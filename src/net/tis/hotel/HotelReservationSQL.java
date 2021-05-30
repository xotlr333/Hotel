package net.tis.hotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelReservationSQL {
	Connection CN;
	PreparedStatement PST;
	Statement ST;
	ResultSet RS;
	
	String msg="";
	int Gtotal, Stotal;
	
	
		
	public HotelReservationSQL() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		CN =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
		} catch (Exception e) {
			System.out.println("서버 연결 에러 :" + e);
		}
		
	}// 생성자 end
	
	
	
	public void dbReservationInsert(int a, int b, String c, String d, String e, String f, String g) {
		try {
		  msg="insert into h_reser values(hres_seq.nextval,?,?,?,?,?,?,?,sysdate)";
	      PST=CN.prepareStatement(msg);
	          PST.setInt(1, a);
	          PST.setInt(2, b);
	          PST.setString(3, c );
	          PST.setString(4, d);
	          PST.setString(5, e);
	          PST.setString(6, f);
	          PST.setString(7, g);
	        
	      PST.executeUpdate();     
			//System.out.println("reservationInsert 메소드 성공");
		}catch(Exception ex){
			System.out.println("reservationInsert 메소드 에러 :" +ex);}
		
	}
	
		
	public HotelReservationDTO ReservationConfirm(String wdate, String wname, String wtel) {
		HotelReservationDTO rdto = new HotelReservationDTO();
		try {
			msg="select * from reserve where checkOut= '"+wdate + "' and name= '" + wname+ "' and tel='"+wtel+"'";
			ST= CN.createStatement();
			RS= ST.executeQuery(msg);
			if(RS.next()==true) {
				rdto.setName(RS.getString("name"));
				rdto.setTel(RS.getString("tel"));
				
				}
			//System.out.println("reservationConfirm 메소드 성공");
		}catch(Exception e){
			System.out.println("reservationConfirm 메소드 에러" +e);}
		return rdto;
	}
	

}//class end
