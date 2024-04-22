package hospital_junit_project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Doctor {
    private int doctorId;
    private String name;
    private String department;
    private String phone;
    private List<Appointment> appointments;

    public Doctor(int doctorId, String name, String department, String phone) {
        this.doctorId = doctorId;
        this.name = name;
        this.department = department;
        this.phone = phone;
        this.appointments = new ArrayList<>();
    }
    
    public boolean hasAppointmentConflict(LocalDateTime proposedDateTime) {
        for (Appointment appointment : appointments) {
            LocalDateTime existingStart = appointment.getDateTime();
            LocalDateTime existingEnd = existingStart.plusMinutes(30); // Assuming each appointment lasts 30 minutes

            // Check if the proposed appointment overlaps with any existing appointment
            if (proposedDateTime.isAfter(existingStart) && proposedDateTime.isBefore(existingEnd)) {
                return true; // Conflict found
            }
        }
        return false; // No conflict
    }
    
    
    public void addAppointment(Appointment appointment) {
        if( ! hasAppointmentConflict(appointment.getDateTime()) ) {
        	appointments.add(appointment);
        }else {
        	
        }
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
