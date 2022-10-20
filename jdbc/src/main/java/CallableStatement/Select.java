package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		String query="Select * from storage.department";
		
		try {
			Connection con=DriverManager.getConnection(url);
			
			CallableStatement call = con.prepareCall(query);
			
			ResultSet rs=call.executeQuery(query);
			
			while(rs.next()){
				String deptnum=rs.getString("deptno");
				String deptname=rs.getString("dname");
				String loccode=rs.getString("lcode");
				System.out.println(deptnum+" "+deptname+" "+loccode);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
