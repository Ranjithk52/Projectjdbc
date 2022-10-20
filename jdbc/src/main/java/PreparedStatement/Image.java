package PreparedStatement;



	
	import java.sql.*;
	import java.io.*;

	public class Image {
	public static void main(String[] args) {
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				
	PreparedStatement ps=con.prepareStatement(" insert into storage.image values(?,?)");
	ps.setString(1,"3");		
	FileInputStream fin=new FileInputStream("D:\\databaseimage\\tiger.jpg");
			
	
	ps.setBinaryStream(2,fin,fin.available());
      int i=ps.executeUpdate();
	System.out.println(i+" records affected");
			
	con.close();
				
	}catch (Exception e) {e.printStackTrace();}
	}
	}


