package doctorDao;
import java.sql.*;
import java.util.Scanner;

import hospitalmanagement.HospitalManagement;

public class Doctorimp implements DoctorDAO {
static Scanner sc = new Scanner(System.in);

	static String url="jdbc:mysql://localhost:3306?user=root&password=root";
	String queryins="Insert into project.doctor values(?,?,?,?)";
	String queryupd="update project.doctor set fee=? where Doctor_Id=?";
	String querydel="delete from project.doctor where Doctor_Id=?";
	String querysel="Select * from project.doctor";
	String querysel1="Select * from project.doctor where Doctor_Id=?";
	static String patins="Insert into project.patients values(?,?,?,?,?,?)";
	String patsel1="Select * from project.patients where Aadhar_num=?";
	String patsel="Select ds.fee,ps.* from project.doctor ds,project.patients ps where ds.Doctor_Id=ps.Doctor_Id;";
	static String patsel2=" Select *  from project.doctor ds,project.patients ps where ds.Doctor_Id=ps.Doctor_Id and ps.Aadhar_num=?";
			
	String patfee="Select Fee from project.doctor where Doctor_Id=Select Doctor_Id from project.patients where Aadhar_num=?";
	
	//String patsel1="Select * from project.patients where Aadhar_num=?";

	@Override
	public void addDoctor() throws SQLException {
		Connection con=DriverManager.getConnection(url);
		PreparedStatement ps=con.prepareStatement(queryins);
		System.out.println("Enter the Doctor ID: ");
		String docid=sc.next();
		ps.setString(1, docid);
		System.out.println("Enter the Doctor Name: ");
		String docname=sc.next();
		ps.setString(2, docname);
		System.out.println("Enter the Doctor Specialist: ");
		String docspec=sc.next();
		ps.setString(3, docspec);
		System.out.println("Enter the Doctor Fee: ");
		String docfee=sc.next();
		ps.setString(4, docfee);
		ps.executeUpdate();
		
	}

	@Override
	public void viewDoctor() {
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(querysel1);
			System.out.println("Enter the Doctor ID: ");
			String docid=sc.next();
			ps.setString(1, docid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String dcid=rs.getString("Doctor_ID");
				String dcname=rs.getString("Doctor_Name");
				String dspec=rs.getString("Specialist");
				String dfee=rs.getString("Fee");
				System.out.println(dcid+" "+dcname+" "+dspec+" "+dfee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewAlldoctors() {
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(querysel);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String dcid=rs.getString("Doctor_ID");
				String dcname=rs.getString("Doctor_Name");
				String dspec=rs.getString("Specialist");
				String dfee=rs.getString("Fee");
				System.out.println(dcid+" "+dcname+" "+dspec+" "+dfee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void replaceDoctor() {
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(queryupd);
			System.out.println("Enter the Doctor ID: ");
			String docid=sc.next();
			
			System.out.println("Enter the Doctor Fees: ");
			String docfee=sc.next();
			ps.setString(1, docfee);
			ps.setString(2, docid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeDoctor() {
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(querydel);
			System.out.println("Enter the Doctor ID: ");
			String docid=sc.next();
			
			
			ps.setString(1, docid);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static public void patientinfo(String doc_id) throws SQLException {
		Connection con=DriverManager.getConnection(url);
		PreparedStatement ps=con.prepareStatement(patins);
		PreparedStatement ps1=con.prepareStatement(patsel2);
		System.out.println("Enter the Patients Name: ");
		String patname=sc.next();
		ps.setString(1, patname);
		System.out.println("-----Please Enter Patient Mobile number---- ");
		String patmob=sc.next();
		ps.setString(2, patmob);
		System.out.println("-----Please Enter Patient Email---- ");
		String patemail=sc.next();
		ps.setString(3, patemail);
		System.out.println("----Please Enter Patient AAdhar number---- ");
		String patadr=sc.next();
		ps.setString(4, patadr);
		
		System.out.println("----Please Enter Patient Health Issue---- ");
		String pathlt=sc.next();
		ps.setString(5, pathlt);
		ps.setString(6,doc_id);
		ps.executeUpdate();
		ps1.setString(1, patadr);
		ResultSet rs=ps1.executeQuery();
		while(rs.next()){
			String pname=rs.getString("Patient_Name");
			String pmob=rs.getString("Mobile_Num");
			String pemail=rs.getString("Email");
			String paadh=rs.getString("Aadhar_num");
			String phlt=rs.getString("Health_issue");
			String pfee=rs.getString("Fee");
			System.out.println("....Patient Details with Bill....");
			System.out.println("-----------------------------------------------------------------------------");
			//System.out.println("|Patient Name|Patient_Mobile|--Email--|---Aadhar---|--Health_Issue--|--Fee--|");
			System.out.println(pname+" "+pmob+" "+pemail+" "+paadh+" "+phlt+" "+pfee);
		}
		
		
		
	}
	@Override
	public void viewPatient() {
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(patsel2);
			System.out.println("Enter the Patient Aadhar: ");
			String patadr=sc.next();
			ps.setString(1, patadr);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String pname=rs.getString("Patient_Name");
				String pmob=rs.getString("Mobile_Num");
				String pemail=rs.getString("Email");
				String paadh=rs.getString("Aadhar_num");
				String phlt=rs.getString("Health_issue");
				String pfee=rs.getString("Fee");
				System.out.println(pname+" "+pmob+" "+pemail+" "+paadh+" "+phlt+" "+pfee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	public void patientBill(){
//		try {
//			Connection con=DriverManager.getConnection(url);
//			PreparedStatement ps=con.prepareStatement(patsel2);
//			System.out.println("Enter the Patient Aadhar: ");
//			String patadr=sc.next();
//			ps.setString(1, patadr);
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()){
//				String pname=rs.getString("Patient_Name");
//				String pmob=rs.getString("Mobile_Num");
//				String pemail=rs.getString("Email");
//				String paadh=rs.getString("Aadhar_num");
//				String phlt=rs.getString("Health_issue");
//				String pfee=rs.getString("Fees");
//				System.out.println(pname+" "+pmob+" "+pemail+" "+paadh+" "+phlt+" "+pfee);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	 public void viewAllPatients(){
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(patsel);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String pname=rs.getString("Patient_Name");
				String pmob=rs.getString("Mobile_Num");
				String pemail=rs.getString("Email");
				String paadh=rs.getString("Aadhar_num");
				String phlt=rs.getString("Health_issue");
				String docid=rs.getString("Doctor_ID");
				String pfee=rs.getString("Fee");
				
				
				System.out.println(pname+" "+pmob+" "+pemail+" "+paadh+" "+phlt+" "+docid+" "+pfee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void appointment() {
		
		try {
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(querysel1);
			System.out.println("Which Doctor do you want ?");
			String docid=sc.next();
			ps.setString(1, docid);
			Doctorimp.patientinfo(docid);
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void back() {
		HospitalManagement.main(null);
		
	}

}
