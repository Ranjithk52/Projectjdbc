package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Callableprocedure {

	public static void main(String[] args) throws SQLException {
		//String url=("jdbc:mysql://localhost:3306/storage","root","root");
		String query="Insert into department values(35,'Devops',862)";
		
		String query2="Update department set dname='Ramesh' where deptno=14";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/storage","root","root");
		//Statement st=con.createStatement();
		CallableStatement cst=con.prepareCall("{call Procedure2()}");
		cst.executeUpdate(query);
		System.out.println("Sucessfully Inserted.........  ");
		ResultSet rs=cst.executeQuery();
	
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		}
		cst.executeUpdate(query2);
		System.out.println("Sucessfully Updated.........  ");
//		ResultSet rs1=st.executeQuery(query3);
//		while(rs1.next()){
//			String deptnum=rs1.getString("deptno");
//			String deptname=rs1.getString("dname");
//			String loccode=rs1.getString("lcode");
//			System.out.println(deptnum+" "+deptname+" "+loccode);
//		}
		
		
		ResultSet rs2=cst.executeQuery();
		while(rs2.next()){
			System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getInt(3));
			
			
		}
		

	

}
}
