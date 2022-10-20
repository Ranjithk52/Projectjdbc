package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		String query="Update storage.department set dname=? where deptno=?";
		
		Connection con=DriverManager.getConnection(url);
		PreparedStatement pst=con.prepareStatement(query);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the dname: ");
		String udname=sc.next();
		pst.setString(1, udname);
		System.out.println("Enter the deptno: ");
		String udepno=sc.next();
		pst.setString(2, udepno);
		pst.executeUpdate();
		System.out.println("Updated Successfully.....");
		con.close();

	}

}
