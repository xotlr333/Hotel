package net.tis.hotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelReviewSQL {
	Connection CN;
	PreparedStatement PST;
	Statement ST;
	ResultSet RS;
	
	String msg="";
	int Gtotal, Stotal;
	
	
		
	public HotelReviewSQL() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		CN =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
		} catch (Exception e) {
			System.out.println("서버 연결 에러 :" + e);
		}
		
	}// �깮�꽦�옄 end
	
	
	
	public void dbReviewInsert(String title, String name, String pwd , String content, String wimg, int rating) {
		try {
		  msg="insert into h_review values(hr_seq.nextval,?,?,?,?,sysdate,?,0,0,?)";
	      PST=CN.prepareStatement(msg);
	          PST.setString(1, title);
	          PST.setString(2, name);
	          PST.setString(3, pwd );
	          PST.setString(4, content);
	          PST.setString(5, wimg);
	          PST.setInt(6, rating);
	      PST.executeUpdate();     
			//System.out.println("dbInsert 메소드 성공");
		}catch(Exception e){
			System.out.println("dbInsert 메소드 에러 :" +e);}
		
	}
	
	
	
	public void dbEditInsert(int code, String title, String name, String pwd , String content, String wimg, int rating) {
		try {
		  msg="insert into h_review values(?,?,?,?,?,sysdate,?,0,0,?)";
	      PST=CN.prepareStatement(msg);
	          PST.setInt(1, code);
	          PST.setString(2, title);
	          PST.setString(3, name);
	          PST.setString(4, pwd );
	          PST.setString(5, content);
	          PST.setString(6, wimg);
	          PST.setInt(7, rating);
	      PST.executeUpdate();     
			//System.out.println("dbEditInsert 메소드 성공");
		}catch(Exception e){
			System.out.println("dbEditInsert 메소드 에러 :" +e);}
		
	}
	
	
		
	public ArrayList<HotelReviewDTO> dbSearchSelect(String keyfield, String keyword, int start, int end) {
		ArrayList <HotelReviewDTO> alist = new ArrayList <HotelReviewDTO>();
		try{
			
			String a="select * from (";
			String b="select rownum as rn, h.*, ";
			String x=" (select count(*) from h_reviewr r where r.rcode=h.code)as rcnt from" ;
            String y=" (select * from h_review where " +keyfield+ " like '%" +keyword+"%' order by code desc)h";
          	String c=" ) where rn between "+start+ " and " +end;
			
			
			msg= a+b+x+y+c;
			ST=CN.createStatement();
			RS=ST.executeQuery(msg);
			while(RS.next()==true) {
				HotelReviewDTO dto = new HotelReviewDTO();
				dto.setTitle(RS.getString("title"));
				dto.setCode(RS.getInt("code"));
				dto.setName(RS.getString("name"));
				dto.setPwd(RS.getString("pwd"));
				dto.setContent(RS.getString("content"));
				dto.setWdate(RS.getDate("wdate"));
				dto.setWimg(RS.getString("wimg"));
				dto.setHits(RS.getInt("hits"));
				dto.setLikes(RS.getInt("likes"));
				dto.setRating(RS.getInt("rating"));
				dto.setRcnt(RS.getInt("rcnt"));
				alist.add(dto);
			}
			//System.out.println("dbsearchSelectAll 메소드 성공");
		}catch(Exception e){
			System.out.println("寃��깋 �썑dbsearchselect  메소드 에러" + e);}
		return alist;
	}
	
	
	public int dbgetTotal() {
		try{
		   msg="select count(*) as cnt from h_review";
		   ST=CN.createStatement();
		   RS=ST.executeQuery(msg);
		   if(RS.next()==true) {
			   Gtotal=RS.getInt("cnt");}
		   }catch(Exception e){
			System.out.println("dbgetTotal 메소드 에러 "+e);}
		return Gtotal;
	}
	
	
	public int dbSearchTotal(String keyfield, String keyword) {
		try{
		   msg="select count(*) as cnt from h_review where " +keyfield+ " like '%" +keyword+"%'";
		   ST=CN.createStatement();
		   RS=ST.executeQuery(msg);
		   if(RS.next()==true) {
			   Stotal=RS.getInt("cnt");}
		   }catch(Exception e){
			System.out.println("dbgetTotal 메소드 에러 "+e);}
		return Stotal;
	}
	
	
	public void dbhits(int data) {
		try{
		   msg="update h_review set hits= hits+1 where code= " +data;
		   ST=CN.createStatement();
		   ST.executeUpdate(msg);
		   }catch(Exception e){
			System.out.println("dbhits 메소드 에러 "+e);}
		}
	
	
	public HotelReviewDTO dbDetail(int data) {
		HotelReviewDTO dto = new HotelReviewDTO();
		try {
			msg="select * from h_review where code= " + data;
			ST= CN.createStatement();
			RS= ST.executeQuery(msg);
			if(RS.next()==true) {
				dto.setTitle(RS.getString("title"));
				dto.setCode(RS.getInt("code"));
				dto.setName(RS.getString("name"));
				dto.setPwd(RS.getString("pwd"));
				dto.setContent(RS.getString("content"));
				dto.setWdate(RS.getDate("wdate"));
				dto.setWimg(RS.getString("wimg"));
				dto.setHits(RS.getInt("hits"));
				dto.setLikes(RS.getInt("likes"));
			}
			//System.out.println("dbDetail 메소드 성공");
		}catch(Exception e){
			System.out.println("dbDetail 메소드 에러" +e);}
		return dto;
	}
	
	
	
	public HotelReviewDTO dbConfirm(int data) {
		HotelReviewDTO dto = new HotelReviewDTO();
		try {
			msg="select * from h_review where code= " + data;
			ST= CN.createStatement();
			RS= ST.executeQuery(msg);
			if(RS.next()==true) {
				dto.setName(RS.getString("name"));
				dto.setPwd(RS.getString("pwd"));
				}
			//System.out.println("dbConfirm 메소드 성공");
		}catch(Exception e){
			System.out.println("dbConfirm 메소드 에러" +e);}
		return dto;
	}
	
	
	public void dbDelete(int data) {
		try {
			msg="delete from h_review where code=" +data ;
			ST= CN.createStatement();
			RS= ST.executeQuery(msg);
			
			//System.out.println("dbDelete 메소드 성공");
		}catch(Exception e){
			System.out.println("dbDelete 메소드 에러" +e);}
		
	}

	
	

}//class end
