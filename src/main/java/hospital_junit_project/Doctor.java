package hospital_junit_project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Doctor {
    private static int doctorId = 0;
    private String name;
    private String department;
    private String phone;
    private List<Appointment> appointments;

    public Doctor(String name, String department, String phone) {
        doctorId++;
        this.name = name;
        this.department = department;
        this.phone = phone;
        this.appointments = new ArrayList<>();
    }
    
    
    public int getDoctorId() {
        return doctorId;
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

}
