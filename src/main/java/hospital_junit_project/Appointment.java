package hospital_junit_project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


class Appointment {
    private int appointmentId;
    private LocalDateTime  dateTime;
    private Doctor doctor;
    private Patient patient;

    public Appointment(int appointmentId, LocalDateTime dateTime, Doctor doctor, Patient patient) {
        this.appointmentId = appointmentId;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
    }
    
    
    public void reschedule(LocalDateTime newDate) {
        this.dateTime = newDate;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    
}