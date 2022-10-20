package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;



public class procedure {

	public static void main(String[] args) {
		
		
				
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/storage", "root", "root");
						CallableStatement cs=con.prepareCall("{call proced1(?,?)}");
						cs.registerOutParameter(2,Types.INTEGER);
						cs.setInt(1, 5);
						cs.execute();
						int result=cs.getInt(2);
						System.out.println("Square root : "+result);
						cs.close();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
		
		

	}

}
