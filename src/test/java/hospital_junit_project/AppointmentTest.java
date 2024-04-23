package hospital_junit_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void testAppointmentCreation() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        assertNotNull(appointment, "The appointment should be created successfully");
        assertEquals(dateTime, appointment.getDateTime(), "The appointment date and time should match the initial setup");
    }

    @Test
    @Order(2)
    void testAppointmentRescheduling() {
        Appointment appointment = new Appointment(dateTime, doctor, patient);
        LocalDateTime newDateTime = dateTime.plusDays(1);
        appointment.reschedule(newDateTime);
        assertEquals(newDateTime, appointment.getDateTime(), "The appointment should be rescheduled to the new date and time");
    }
   
}
    
    
    