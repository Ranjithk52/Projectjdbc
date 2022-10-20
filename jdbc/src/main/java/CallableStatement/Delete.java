package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		String query = "Delete from storage.department where deptno=?";
		Connection con = DriverManager.getConnection(url);
		CallableStatement call = con.prepareCall(query);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter deptno : ");
		String udepno=sc.next();
		call.setString(1, udepno);
		call.executeUpdate();
		System.out.println("Deleted Successfully....");
		con.close();
	}
}
