package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
	public static void main(String[] args) throws SQLException {
//		String url = "jdbc:mysql://localhost:3306?user=root&password=root";

		String query = "update department set dname=? where deptno=14";
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/storage","root","root");
		
		CallableStatement callableStatement = connection.prepareCall(query);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dept name:");
		String udept = sc.next();
		callableStatement.setString(1,udept);
		
		callableStatement.executeUpdate();
		
		connection.close();
		System.out.println("Updated Suuccessfully...");
	}
}
