package com.example.demo1;

import java.util.List;

public class MedicalRecord {

    private static List<MedicalRecord> recordList;

    private static int records = 0;

    private int recordId;
    private Patient patient;

    public String patient_name;
    private Doctor doctor;

    public String doctor_name;
    private String diagnosis;
    private String prescription;

    public MedicalRecord(Patient patient, Doctor doctor, String diagnosis, String prescription) {
        records++;
        this.recordId = records;
        this.patient = patient;
        this.doctor = doctor;
        doctor_name = doctor.getName();
        patient_name = patient.getName();
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        recordList.add(this);
    }



	public int getRecordID() {
		return recordId;
	}

    public int getRecordId() {
        return recordId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                '}';
    }


    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }
}

