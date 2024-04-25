package com.example.demo1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Appointment {

	private static List<Appointment> appointments = new ArrayList<Appointment>();
    private static int no_ofappointments = 0;
    private int appointmentId;
    public LocalDateTime dateTime;
    private Doctor doctor;
    public String doctor_name;
    private Patient patient;
    public String patient_name;
    public double bill_amount;
    private Billing bill;
    
    public Appointment(LocalDateTime dateTime, Doctor doctor, Patient patient) {
    	no_ofappointments ++;
    	appointmentId=no_ofappointments;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
        setDoctor_name(doctor.getName());
        setBill_amount(doctor.getBill_amount());
        setPatient_name(patient.getName());
        bill = new Billing(patient,bill_amount);
        if( ! hasAppointmentConflict() ) {
            appointments.add(this);
        }
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
    
    
    public void reschedule(LocalDateTime newDate) {
        this.dateTime = newDate;
    }

    public  int getAppointmentId() {
        return appointmentId;
    }
    public static int getAppointmentcount() {
        return no_ofappointments;
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

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public double getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(double bill_amount) {
        this.bill_amount = bill_amount;
    }
}