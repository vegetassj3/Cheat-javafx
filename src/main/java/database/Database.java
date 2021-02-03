package database;

import java.sql.*;

public class Database {
	
	public Connection con=null;
	
	public Database() {
		//connect();
	}
	
	

	
	public void connect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/nvl?autoReconnect=true&useSSL=false","root","root");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select count(*) from book");  
			while(rs.next())  
			{
				System.out.println(rs.getInt(1));
				
			}
				
			con.close();  
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}
	
}
