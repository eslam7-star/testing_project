package hospital_junit_project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


class Appointment {

	private static List<Appointment> appointments = new ArrayList<Appointment>();
    private static int no_ofappointments = 0;
    private static int no_ofappointments_conflict = 0;
    private int appointmentId;
    private LocalDateTime  dateTime;
    private Doctor doctor;
    private Patient patient;
    private Billing bill;
    
    public Appointment(LocalDateTime dateTime, Doctor doctor, Patient patient) {
    	no_ofappointments++;
    	appointmentId=no_ofappointments;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
        if( ! hasAppointmentConflict() ) {
        	 bill = new Billing(patient,doctor.getBill_amount());
        	appointments.add(this);}
        else { no_ofappointments_conflict++;}
        
    }

    public boolean hasAppointmentConflict( ) {
        for (Appointment appointment : appointments) {
            if ( getDateTime()== appointment.getDateTime() && ( getDoctor() == appointment.getDoctor() || getPatient() == appointment.getPatient() ) ) {
                System.out.println("conflict occurs ");
               
                bill = null;
               
                return true;
            }
        }
        doctor.add_appointment(this);
        patient.add_appointment(this);
        return false; // No conflict
    }
    
    public boolean hasAppointmentConflict(LocalDateTime dateTime) {
        for (Appointment appointment : appointments) {
            if (dateTime.equals(appointment.getDateTime()) && 
                (getDoctor().equals(appointment.getDoctor()) || getPatient().equals(appointment.getPatient()))) {
                System.out.println("Conflict occurs");
                return true;
                
            }
        }
       
        return false; // No conflict
    }

    
    public void reschedule(LocalDateTime newDate) {
    	if(!hasAppointmentConflict(newDate)) {
    		this.dateTime=newDate;
    	}
    	else {
    		return;
    	}
    }

    public  int getAppointmentId() {
        return appointmentId;
    }
    public static int getAppointmentcount() {
        return no_ofappointments;
    }
    public static int getno_ofappointments_conflict() {
        return no_ofappointments_conflict;
    }

    public  void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
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

    public static List<Appointment> getAppointments() {
        return appointments;
    }

    public static void setAppointments(List<Appointment> appointments) {
        Appointment.appointments = appointments;
    }

    public Billing getBill() {
        return bill;
    }

    public void setBill(Billing bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "dateTime=" + dateTime +
                ", doctor=" + doctor.toString() +
                ", patient=" + patient.toString() +
                ",bill =" + bill.toString() +
                '}';
    }
    
}