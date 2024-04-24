package com.example.demo1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Patient {

    private static List<Patient> patients = new ArrayList<>();

    private  int patientId = 0;
    
    private String name;                
    private static int no_of_patients=0;
    private int age;
    private String gender;
    private String phone,address;
    private List<Appointment> appointments;
    private List<MedicalRecord> medicalRecords;
    private List<Billing> billings;

    public Patient(String name, int age, String gender, String phone , String address) {
        no_of_patients++;
        this.patientId= no_of_patients;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.appointments = new ArrayList<>();
        this.medicalRecords = new ArrayList<>();
        this.billings = new ArrayList<>();
        patients.add(this);
    }
    



    public Appointment make_an_Appointment(LocalDateTime dateTime, Doctor doctor) {
        return new Appointment(dateTime, doctor, this);
    }
    
    public void add_appointment(Appointment app) {
    	if( app != null )
    		appointments.add(app);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    public void addBilling(Billing billing) {
        billings.add(billing);
    }

    public void updateDetails(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }
    
    public MedicalRecord getMedicalRecordById(int recordID) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordID() == recordID) {
                return record;
            }
        }
        return null;
    }

    
    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Billing> getBillings() {
        return billings;
    }

    public String getAddress() {
    	return this.address;
    }
    public String getPhone() {
    	return this.phone;
    }
    public int get_patientId() {
    	return this.patientId;
    }

    public static List<Patient> getAllPatients() {
        return patients;
    }

}











