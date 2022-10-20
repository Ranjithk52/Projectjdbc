package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		String query="Insert into storage.department values(?,?,?)";
		
		Connection con=DriverManager.getConnection(url);
		PreparedStatement pst=con.prepareStatement(query);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the deptno: ");
		String udeptno=sc.next();
		pst.setString(1, udeptno);
		System.out.println("Enter the dname: ");
		String udname=sc.next();
		pst.setString(2, udname);
		System.out.println("Enter the LCode: ");
		String loccode=sc.next();
		pst.setString(3, loccode);
		pst.executeUpdate();
		System.out.println("Inserted Successfully.....");
		con.close();
		

	}

}
