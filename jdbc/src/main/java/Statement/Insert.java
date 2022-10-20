package Statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) throws SQLException {
		//String url=("jdbc:mysql://localhost:3306/storage","root","root");
		String query="Insert into department values(32,'Devops',862)";
		String query1="Select * from department";
		String query2="Update department set dname='Ramesh' where deptno=14";
		String query3="Select * from department";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/storage","root","root");
		Statement st=con.createStatement();
		st.executeUpdate(query);
		System.out.println("Sucessfully Inserted.........  ");
		ResultSet rs=st.executeQuery(query1);
	
		while(rs.next()){
			String deptnum=rs.getString("deptno");
			String deptname=rs.getString("dname");
			String loccode=rs.getString("lcode");
			System.out.println(deptnum+" "+deptname+" "+loccode);
			
		}
		st.executeUpdate(query2);
		System.out.println("Sucessfully Updated.........  ");
		ResultSet rs1=st.executeQuery(query3);
		while(rs1.next()){
			String deptnum=rs1.getString("deptno");
			String deptname=rs1.getString("dname");
			String loccode=rs1.getString("lcode");
			System.out.println(deptnum+" "+deptname+" "+loccode);
		}
		
		
		

	

}
}
