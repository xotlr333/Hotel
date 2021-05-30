package net.tis.hotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelNoticeSQL {
	Connection CN;
	PreparedStatement PST;
	Statement ST;
	ResultSet RS;
	
	String msg="";
	
	
		
	public HotelNoticeSQL() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		CN =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
		} catch (Exception e) {
			System.out.println("서버 연결 에러 :" + e);
		}
		
	}// 생성자 end
	
	

	public ArrayList<HotelNoticeDTO> dbSelect() {
		ArrayList<HotelNoticeDTO> ndto = new ArrayList<HotelNoticeDTO>();
		try {
			msg="select * from h_notice"; 
			ST= CN.createStatement();
			RS= ST.executeQuery(msg);
			while(RS.next()==true) {
				HotelNoticeDTO dto = new HotelNoticeDTO();
				dto.setNtitle(RS.getString("ntitle"));
				dto.setNimg(RS.getString("nimg"));
				dto.setNdate(RS.getDate("ndate"));
				ndto.add(dto);
			}
			//System.out.println("dbnotice 메소드 성공");
		}catch(Exception e){
			System.out.println("dbnotice 메소드 에러" +e);}
		return ndto;
	}
	
	


}//class end
