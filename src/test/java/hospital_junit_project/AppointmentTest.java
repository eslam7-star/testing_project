package hospital_junit_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestMethodOrder(OrderAnnotation.class)
class AppointmentTest { private Doctor doctor;
    private Patient patient;
    private Patient patient2;
    private LocalDateTime dateTime;

    @BeforeEach
    void setUp() {
        doctor = new Doctor( "Dr. Smith", "Cardiology", "1234567890",60);
        patient = new Patient( "John Doe", 30, "Male", "0987654321", "123 Main St");
        patient2 = new Patient( "Jack Danil", 30, "Male", "09547033", "25 master St");
        dateTime = LocalDateTime.now();
    }
    
    @Test
    @Order(1)
    void testAppointmentIdIncrements() {
    	 // Create first appointment
    	int c= Appointment.getAppointmentcount();
        Appointment firstAppointment = new Appointment(LocalDateTime.now(),doctor,patient);
        assertEquals(c+1, firstAppointment.getAppointmentId(), "The appointment ID should be 1 for the first appointment");
        System.out.println(Appointment.getAppointmentcount());

        // Create second appointment
        Appointment secondAppointment = new Appointment(LocalDateTime.now().plusDays(1),doctor,patient);
        assertEquals(c+2,secondAppointment.getAppointmentId(), "The appointment ID should be 2 for the second appointment");
        System.out.println(Appointment.getAppointmentcount());
        
    }

    @Test
    @Order(2)
    void testAppointmentCreation() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        assertNotNull(appointment, "The appointment should be created successfully");
        assertEquals(dateTime, appointment.getDateTime(), "The appointment date and time should match the initial setup");
    }

    @Test
    @Order(3)
    void testAppointmentRescheduling() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        LocalDateTime newDateTime = LocalDateTime.of(2024, Month.APRIL, 28, 12, 30);
        appointment.reschedule(newDateTime);
        assertEquals(newDateTime, appointment.getDateTime(), "The appointment should be rescheduled to the new date and time");
    }
    @Test
    void testAppointmentRescheduling_conflict() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        LocalDateTime newDateTime = dateTime.plusDays(1);
        Appointment appointment2 = new Appointment(newDateTime, doctor, patient);
        appointment.reschedule(newDateTime);
        assertNotEquals(newDateTime, appointment.getDateTime(), "The appointment should be rescheduled to the new date and time");
    }
    

  
   
    
    @Test
    void testappointmen_conflict() {
    	 Appointment appointment = new Appointment( dateTime, doctor, patient);
    	 Appointment appointment2 = new Appointment( dateTime, doctor, patient2);	
         assertEquals(appointment2.hasAppointmentConflict(),true);
    	 
    }
    
    
    
    @Test
   
    void testAppointmentConstructor() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        assertNotNull(appointment, "The appointment should be created successfully");
        assertEquals(dateTime, appointment.getDateTime(), "The appointment date and time should match the initial setup");
        assertEquals(doctor, appointment.getDoctor(), "The doctor should match the initial setup");
        assertEquals(patient, appointment.getPatient(), "The patient should match the initial setup");
    }

    @Test
    
    void testSetAndGetAppointmentId() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        int newId = 10;
        appointment.setAppointmentId(newId);
        assertEquals(newId, appointment.getAppointmentId(), "The appointment ID should be updated successfully");
    }

    @Test
   
    void testSetAndGetDateTime() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        LocalDateTime newDateTime = LocalDateTime.now().plusDays(2);
        appointment.setDateTime(newDateTime);
        assertEquals(newDateTime, appointment.getDateTime(), "The appointment date and time should be updated successfully");
    }

    @Test
  
    void testSetAndGetDoctor() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        Doctor newDoctor = new Doctor("Dr. Johnson", "Neurology", "0987654321", 80);
        appointment.setDoctor(newDoctor);
        assertEquals(newDoctor, appointment.getDoctor(), "The doctor should be updated successfully");
    }

    @Test
    
    void testSetAndGetPatient() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        Patient newPatient = new Patient("Jane Doe", 25, "Female", "1234567890", "456 Main St");
        appointment.setPatient(newPatient);
        assertEquals(newPatient, appointment.getPatient(), "The patient should be updated successfully");
    }

    @Test
   
    void testSetAndGetBill() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        Billing newBill = new Billing(patient, 100);
        appointment.setBill(newBill);
        assertEquals(newBill, appointment.getBill(), "The bill should be updated successfully");
    }

}
    
    
    