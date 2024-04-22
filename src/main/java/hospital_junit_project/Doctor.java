package hospital_junit_project;

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

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    
    
}
