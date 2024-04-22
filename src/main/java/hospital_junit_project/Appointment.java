package hospital_junit_project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


class Appointment {
    private static int appointmentId = 0;
    private LocalDateTime  dateTime;
    private Doctor doctor;
    private Patient patient;

    public Appointment(LocalDateTime dateTime, Doctor doctor, Patient patient) {
        appointmentId++;
        if( !doctor.hasAppointmentConflict(dateTime) && !patient.hasAppointmentConflict(dateTime) ) {
        	this.dateTime = dateTime;
            this.doctor = doctor;
            this.patient = patient;
        }else {
        	return;
        }
        
    }
    
    
    public void reschedule(LocalDateTime newDate) {
        this.dateTime = newDate;
    }

    public static int getAppointmentId() {
        return appointmentId;
    }

    public static void setAppointmentId(int appointmentId) {
        Appointment.appointmentId = appointmentId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}