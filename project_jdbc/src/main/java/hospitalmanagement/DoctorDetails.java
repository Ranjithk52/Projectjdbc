package hospitalmanagement;

import java.sql.SQLException;
//import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import Hospital.Doctor;
//import Hospital.Patient;
//import doctorDao.DoctorDAOimp;
import doctorDao.Doctorimp;



public class DoctorDetails {
	static Scanner sc=new Scanner(System.in);
	static Doctorimp dao=new Doctorimp();
	public static void adminMainMenu(){
		System.out.println("-----------------------------------");
		System.out.println("|        ADMIN MAIN MENU          |");
		System.out.println("-----------------------------------");
		System.out.println("          1. ADD DOCTOR            ");
		System.out.println("          2. VIEW DOCTOR           ");
		System.out.println("          3. VIEW ALLDOCTORS       ");
		System.out.println("          4. UPDATE DOCTOR FEES        ");
		System.out.println("          5. REMOVE DOCTOR         ");
		System.out.println("          6. Check Patients List   ");
		System.out.println("          7. View Particular Bills ");
		System.out.println("          8. BACK                  ");
		System.out.println("-----------------------------------");
		System.out.println("Enter Your Choice");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			try {
				dao.addDoctor();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adminMainMenu();
			break;
		case 2:
			dao.viewDoctor();
			adminMainMenu();
			break;
		case 3:
			dao.viewAlldoctors();
			adminMainMenu();
			break;
		case 4:
			dao.replaceDoctor();
			adminMainMenu();
			break;
		case 5:
			dao.removeDoctor();
			adminMainMenu();
			break;
		case 6:
			dao.viewAllPatients();
			adminMainMenu();
			break;
		case 7:

		case 8:
			dao.back();
			break;
			default:
				System.out.println("Please Select your range 1-6 only");
			
		}
		
	}
public static void patientMainMenu() {
	System.out.println("-----------------------------------");
	System.out.println("|       PATIENT MAIN MENU         |");
	System.out.println("-----------------------------------");
	System.out.println("          1. VIEW DOCTOR           ");
	System.out.println("          2. VIEW ALLDOCTORS       ");
	System.out.println("          3. APPOINTMENT           ");
	System.out.println("          4. BACK                  ");
	System.out.println("-----------------------------------");
	System.out.println("Enter Your Choice");
	int ch=sc.nextInt();
	switch(ch) {
	
	case 1:
		
		dao.viewDoctor();

		patientMainMenu();
		break;
	case 2:
		dao.viewAlldoctors();
		patientMainMenu();
		break;
	case 3:
		dao.appointment();
		
		patientMainMenu();
		break;
	
	case 4:
		dao.back();
		break;
		default:
			System.out.println("Please Select your range 1-4 only");
		
}
}
}
