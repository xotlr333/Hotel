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
	 Connection CN; //db������������, ��ɾ�����Ҷ� ����
	 Statement ST; //��ɾ���� ST = CN.createStatement()
	 PreparedStatement PST; //�ӵ������� PST = CN.prepareStatement("insert~/update~")
	 CallableStatement CST ; //�����ͺ��̽��� �Լ����ν��� ��� 
	 ResultSet RS; //select��ȸ�Ѱ�� RS=ST.executeQuery("select~~")
	 
	 String msg;//�������徵�� ���
	 
	 String title,name,content;//dbinsert
	 int password,hit;//dbinsert
	 java.util.Date  wdate;//dbinsert
	 
	 String solution;//���ǳ���
	 
	 int Gtotal;//QnA�� ����
	 
	 public QnASQL() {
		  	try{
		  	   //����1 db�����ͺ��̽� ����̺꿬��
		  	   Class.forName("oracle.jdbc.driver.OracleDriver");
		  	   //System.out.println("Web0215���� ����Ŭ����̺꼺�� 2-18-����� 10:15�� ");
		  	   
		  	   //����2 db�����ͺ��̽� ���������ּҹ���Ʈ ����id/pwd
		  	   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		  	   CN=DriverManager.getConnection(url ,"system","1234");
		  	   //System.out.println("Web0215���� ����Ŭ���������� id,pwd 2-18-����� 10:15�� ");
		  	 }catch(Exception ex){ System.out.println("db ���� " + ex.toString());}
		  }//������ end=============================================================================================
	 
	 public void dbInsert(String title, String name, int password, String content) { //�Ű�����5�� ����ϼ���
		   try {
		  	 msg="insert into Hotel_QnA(title,name,password,content,wdate,hit) values(?, ?, ?, ?, sysdate,QnA_seq.nextval)";
		  	 PST=CN.prepareStatement(msg);
		  	 		  PST.setString(1, title);
		  	 		  PST.setString(2, name);
		  	 		  PST.setInt(3, password);
		  	 		  PST.setString(4, content); 
		  	 		  
		  	 PST.executeUpdate();
		  	 System.out.println(name+"�̸�  GuestSQL.java���� dbInsert�Լ�ó�� ���强���߽��ϴ�");
		   }catch(Exception ex){System.out.println("���忡�� " + ex);}
		  }//end
	 
	 public ArrayList<QnADTO> dbSelectAll(int start, int end, String skey, String sval) { //����¡���� 1start, 10end, �˻��ʵ�, �˻�Ű����
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
		   	  //System.out.println("GuestSQL.java���� dbSelectAll�Լ�ó�� ��ü��¼����߽��ϴ�");
		    }catch(Exception ex){System.out.println("��ü��¿��� " + ex);}
		  	return alist;
		  }//end========================================================================================
		  
	 public int getTotal(){ //��ü���ڵ尹��
		  	try { 
		      msg="select count(*) as cnt from Hotel_QnA ";
		      ST=CN.createStatement();
		      RS=ST.executeQuery(msg);
		      if(RS.next()==true) {
		        Gtotal=RS.getInt("cnt");
		      }
		  	}catch(Exception ex){System.out.println("��ü��¿��� " + ex);}
		  	return Gtotal;
		 }//end
	 
	 public int getSearchTotal(String skey, String sval){ //�˻����ڵ尹��
		  	try { 
		      msg="select count(*) as cnt from Hotel_QnA where "+skey+" like '%"+sval+"%' ";
		      ST=CN.createStatement();
		      RS=ST.executeQuery(msg);
		      if(RS.next()==true) {
		        Gtotal=RS.getInt("cnt");
		      }
		  	}catch(Exception ex){System.out.println("��ü��¿��� " + ex);}
		  	return Gtotal;
		 }//end
	 
	 public QnADTO  dbDetail( int data ) { //�Ѱǻ����  
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
		   	  System.out.println("QnASQL.java����  dbDetail�Լ�ó�� ��ü��¼����߽��ϴ�"); 
		    }catch(Exception ex){System.out.println("�Ѱǻ󼼿��� " + ex);}
		  	return dto; //ArrayList��� �Ѱ��̶� GuestDTO=bean=dto=VO
		  }//end
	 
	 public void dbEdit(QnADTO dto) {
		  	try {
		  		msg="update Hotel_QnA set title=?,content=?,wdate=sysdate where hit=?";
		  		PST=CN.prepareStatement(msg);
		  				PST.setString(1, dto.getTitle()); //dto.setXXX(���氪) Edit��Ʈ�Ѵ��� 
		  				PST.setString(2, dto.getContent());
		  				PST.setInt(3, dto.getHit());
		  				
		  		PST.executeUpdate(); 
		  	}catch(Exception ex){System.out.println("�������� " + ex);}
		  }//end
	 
	 public void dbSolutionInsert(String solution, int hit) { //�Ű�����5�� ����ϼ���
		   try {
		  	 msg="update Hotel_QnA set solution=? where hit=?";
		  	 PST=CN.prepareStatement(msg);
		  	 		  PST.setString(1, solution);
		  	 		  PST.setInt(2, hit);
		  	 PST.executeUpdate();
		  	 System.out.println("SQL.java���� dbsInsert ���强���߽��ϴ�");
		   }catch(Exception ex){System.out.println("���忡�� " + ex);}
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
				//System.out.println("dbConfirm �޼ҵ� ����");
			}catch(Exception e){
				System.out.println("dbConfirm �޼ҵ� ����" +e);}
			return dto;
		}
		
	 
	  public void dbDelete(int data) {
		  	try {
		  		msg="delete from Hotel_QnA where hit = " + data ;
		  		ST=CN.createStatement();
		  		ST.executeUpdate(msg);  //��¥����ó��
		  	}catch(Exception ex){System.out.println("�������� " + ex);}
		  }//end
}
