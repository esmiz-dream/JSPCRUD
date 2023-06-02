package common;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Db_connection {
  private final String db_name="jsp_crud";
  private final String user="root";
  private final String password="";
  
  public static void main(String args[])
  {
	  Db_connection dbcon=new Db_connection();
	  System.out.println(dbcon.getConnection());
  }
	public Connection getConnection()
	{
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}


