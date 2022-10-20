package PreparedStatement;

import java.sql.*;
import java.io.*;

public class imageretrive {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");

			PreparedStatement ps = con.prepareStatement("select * from storage.image");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {// now on 1st row

				Blob b = rs.getBlob(1);// 2 means 2nd column data
				byte barr[] = b.getBytes(1, (int) b.length());// 1 means first
																// image

				FileOutputStream fout = new FileOutputStream("D:\\databaseimage\\4.jpg");
				fout.write(barr);

				fout.close();
			} // end of if
			System.out.println("ok");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}