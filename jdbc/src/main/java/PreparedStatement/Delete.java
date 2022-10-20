package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		String query="delete from storage.department where deptno=?";
		
		Connection con=DriverManager.getConnection(url);
		PreparedStatement pst=con.prepareStatement(query);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the dnum: ");
		String udnum=sc.next();
		pst.setString(1, udnum);
		
		pst.executeUpdate();
		System.out.println("Deleteted Successfully.....");
		con.close();

	}

}
