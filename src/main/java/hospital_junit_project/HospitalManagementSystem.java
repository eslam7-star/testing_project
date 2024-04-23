package hospital_junit_project;

import java.time.LocalDateTime;
import java.util.List;



public class HospitalManagementSystem {
	
	public static void main(String[] args) {
        // Example Usage:
        // Create instances of classes and establish relationships

        // Create a patient
		Doctor doc = new Doctor(100, "ali", "sad", "2345345345");
		Patient pat = new Patient(10, "fares", 12, "male", "012343234","asdasd");
        LocalDateTime specificDateTime = LocalDateTime.of(2022, 4, 27, 14, 30);
		Appointment app1 = new Appointment(specificDateTime, doc, pat);
		Appointment app2 = new Appointment(specificDateTime, doc, pat);
    }
}
