package tis.hotel.QnA;

import java.sql.*;  //����Ʈ 

public class DB {

  public static Connection getConnection( ){ //static�޼ҵ�, DB�۾��� ������� ���ϰ�Ȯ��
  	  Connection CN = null;
	    try {
		      //����1 db�����ͺ��̽� ����̺꿬��
			    Class.forName("oracle.jdbc.driver.OracleDriver");
			    //System.out.println("DB.java  ����Ŭ����̺� ���Ἲ�� 111 1:52�� ");
			    
			    //����2 db�����ͺ��̽� ���������ּҹ���Ʈ ����id/pwd
			    String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
			    CN=DriverManager.getConnection(url ,"system","1234");
			    //System.out.println("DB.java  ����Ŭ���������� id,pwd ���Ἲ�� 222 1:52�� ");
	    }catch (Exception e){	System.out.println("DB.java ���� " + e.toString());		}
	    return CN;
  }//end
	
}//class END
