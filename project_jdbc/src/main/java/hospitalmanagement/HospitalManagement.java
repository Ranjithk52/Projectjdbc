package hospitalmanagement;

import java.util.Scanner;

public class HospitalManagement {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("------------------------");
			System.out.println("| Hospital Management System");
			System.out.println("------------------------");
			System.out.println("|    1. ADMIN           ");
			System.out.println("|    2. PATIENT         ");
			System.out.println("|    3. EXIT            ");
			System.out.println("------------------------");
			System.out.println("Enter Your Choice ?");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:DoctorDetails.adminMainMenu();
			break;
			case 2:DoctorDetails.patientMainMenu();
			break;
			case 3:System.exit(0);
			break;
			default:System.out.println("Please Select your choice range 1-3");
			}
			
		} 

	}

}
