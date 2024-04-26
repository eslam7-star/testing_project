package hospital_junit_project;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import javax.print.attribute.standard.DateTimeAtCompleted;
import static hospital_junit_project.Appointment.getAppointments;
public class HospitalManagementSystem {
	
	public static void main(String[] args) {
		Doctor doctor = new Doctor( "Dr. Smith", "Cardiology", "1234567890",60);
	    Patient  patient = new Patient( "John Doe", 30, "Male", "0987654321", "123 Main St");
	    LocalDateTime dateTime=LocalDateTime.of(2024, Month.APRIL, 24, 12, 30);
	    Appointment appointment = new Appointment(dateTime, doctor, patient);
	    //before reshchedualing
	    System.out.println("before reshchedual");
	    System.out.println(doctor.getAppointments().toString());
        System.out.println(patient.getAppointments().toString());
       //after reshchedualing
        LocalDateTime newDateTime = dateTime.plusDays(1);
        appointment.reschedule(newDateTime);
        System.out.println("Reschedualin");
        System.out.println(doctor.getAppointments().toString()); 
        System.out.println(patient.getAppointments().toString()); 
        //add medical record
        patient.addMedicalRecord(new MedicalRecord(patient,doctor,"sick","sick"));
        System.out.println(patient.getMedicalRecords().toString());
        //Billing 
        System.out.println(appointment.getBill().toString()); 
	}
}
