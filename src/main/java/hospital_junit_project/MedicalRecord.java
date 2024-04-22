package hospital_junit_project;

class MedicalRecord {
    private int recordId;
    private Patient patient;
    private Doctor doctor;
    private String diagnosis;
    private String prescription;

    public MedicalRecord(int recordId, Patient patient, Doctor doctor, String diagnosis, String prescription) {
        this.recordId = recordId;
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

	public int getRecordID() {
		return recordId;
	}
	
	
}

