package Statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		String query="Select * from storage.department";
		
		
		Connection con=DriverManager.getConnection(url);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		
		while(rs.next()){
			String deptnum=rs.getString("deptno");
			String deptname=rs.getString("dname");
			String loccode=rs.getString("lcode");
			System.out.println(deptnum+" "+deptname+" "+loccode);
			
		}
		

	}

}
