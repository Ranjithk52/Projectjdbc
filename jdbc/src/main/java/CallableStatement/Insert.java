package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Insert {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		String query = "Insert into storage.department value (?,'Ranjith',?)";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			
			CallableStatement call = connection.prepareCall(query);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter deptno:");
			String udno = sc.next();
			call.setString(1,udno);
			
			System.out.println("enter lcode:");
			String ulco = sc.next();
			call.setString(2,ulco);
			
			call.executeUpdate();
			
			connection.close();
			System.out.println("success:");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
