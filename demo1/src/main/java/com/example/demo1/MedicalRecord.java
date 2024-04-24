package com.example.demo1;

class MedicalRecord {
    private static int recordId = 0;
    private Patient patient;
    private Doctor doctor;
    private String diagnosis;
    private String prescription;

    public MedicalRecord(Patient patient, Doctor doctor, String diagnosis, String prescription) {
        recordId++;
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

	public int getRecordID() {
		return recordId;
	}

    public static int getRecordId() {
        return recordId;
    }

    public static void setRecordId(int recordId) {
        MedicalRecord.recordId = recordId;
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
}

