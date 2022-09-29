package doctorDao;

import java.sql.SQLException;

//import java.util.List;

//import Hospital.Doctor;
//import Hospital.Patient;

public interface DoctorDAO {
public void addDoctor() throws SQLException;
public void viewDoctor();
public void viewAlldoctors();
public void replaceDoctor();
public void removeDoctor();
public void viewPatient();
public void appointment();
public void back();

}
