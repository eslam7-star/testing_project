package hospital_junit_project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

public class HospitalManagementSystemTest {
	private  Doctor doctor;
    private  Patient patient;
    private  LocalDateTime dateTime;
    private  Appointment appointment;

    @BeforeEach
    public void setUp() {
        doctor = new Doctor("Dr. Smith", "Cardiology", "1234567890", 60);
        patient = new Patient("John Doe", 30, "Male", "0987654321", "123 Main St");
        dateTime = LocalDateTime.of(2024, Month.APRIL, 24, 12, 30);
        appointment = new Appointment(dateTime, doctor, patient);
    }
  
    @Test
    public void testAppointment_details () {
        // Check initial state that appointment detials is correct 
    	System.out.println(appointment.getDateTime().toString());
        assertEquals(dateTime, appointment.getDateTime());
        assertEquals(doctor, appointment.getDoctor());
        assertEquals(patient, appointment.getPatient());
    }
    
    @Test
    public void testAppointment_affect_doctor_appointments_list() {
        // Check the appointments list of doctor contains the appointment
        assertTrue( doctor.getAppointments().contains(appointment));
        
    }
    @Test
    public void testAppointment_affect_patient_appointment_list() {
    	 // Check the appointments list of patient contains the appointment
        assertTrue( patient.getAppointments().contains(appointment));
        
    }
    @Test
    public void test_Appointment_affect_all_appointments_list() {
   	 // Check the appointments list of patient contains the appointment
       assertTrue( Appointment.getAppointments().contains(appointment));
       
   }
    
    
    @Test
    public void testAppointmentRescheduleScenario() {
        // Reschedule appointment
        LocalDateTime newDateTime = dateTime.plusDays(1);
        appointment.reschedule(newDateTime);

        // Check state after rescheduling
        assertEquals(newDateTime, appointment.getDateTime());
    }
    @Test
    public void testAppointmentRescheduleScenario_doctor() {
        // Reschedule appointment
        LocalDateTime newDateTime = dateTime.plusDays(1);
        appointment.reschedule(newDateTime);
       int  index=doctor.getAppointments().indexOf(appointment);
        // Check state after rescheduling the affect happened in doctor appointments list
        assertEquals(newDateTime, doctor.getAppointments().get(index).getDateTime());
    }
    @Test
    public void testAppointmentRescheduleScenario_patient() {
        // Reschedule appointment 
        LocalDateTime newDateTime = dateTime.plusDays(1);
        appointment.reschedule(newDateTime);
       int  index=patient.getAppointments().indexOf(appointment);
        // Check state after rescheduling the affect happend in patient appointments list 
        assertEquals(newDateTime,patient.getAppointments().get(index).getDateTime());
    }
    @Test
    public void  Add_medical_record_to_patient() {
        // Add medical record
        MedicalRecord record = new MedicalRecord(patient, doctor, "sick", "sick");
        patient.addMedicalRecord(record);

        // Check medical records
        assertTrue(patient.getMedicalRecords().contains(record));
    }
    @Test
    public void  Check_bill_iscreated_when_appointment() {
        // Check bill
        assertNotNull(appointment.getBill());
    }
    
    @Test
    public void  Check_bill_count_increment() {
    	int c=Billing.getBillings_count();
    appointment = new Appointment(LocalDateTime.of(2024, Month.APRIL, 28, 12, 30), doctor, patient);
    	//check_Bill_count increment at each appointment 
    assertEquals(Billing.getBillings_count(),c+1);
    
     appointment = new Appointment(LocalDateTime.of(2024, Month.APRIL, 29, 12, 30), doctor, patient);
   assertEquals(Billing.getBillings_count(),c+2);
  
   
    }
    @Test
    public void  Check_bill_amount() {
    	//check_Bill_amount=doctor amount bill
    	 assertEquals(appointment.getBill().getTotalAmount(), doctor.getBill_amount());
    }
    @Test
    public void  Check_Removed_appointment() {
    	//check_Bill_amount=doctor amount bill
    	
    	 Appointment o= new Appointment(dateTime, doctor, patient);
    	 
    	 patient.removeAppointment(o);
    	 assertFalse(doctor.getAppointments().contains(o));
    }
    @Test
    public void  Check_Removed_appointment2() {
    	//check_Bill_amount=doctor amount bill
    	
    	 Appointment o= new Appointment(dateTime, doctor, patient);
    	 
    	 doctor.removeAppointment(o);
    	 assertFalse(patient.getAppointments().contains(o));
    }
    @Test
    public void  Check_Removed_appointment3() {
    	//check_Bill_amount=doctor amount bill
    	
    	 Appointment o= new Appointment(dateTime, doctor, patient);
    	 
    	 doctor.removeAppointment(o);
    	 assertFalse( Appointment.getAppointments().contains(o));
    }
    
    
    
    
}
