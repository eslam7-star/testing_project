package hospital_junit_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicalRecordTest {
    private Doctor doctor;
    private Patient patient;
    private MedicalRecord record;

    @BeforeEach
    public void setUp() {
        doctor = new Doctor("Ali", "Sad", "2345345345", 50);
        patient = new Patient("Fares", 12, "male", "012343234", "asdasd");
        record = new MedicalRecord(patient, doctor, "Flu", "Medicine A");
    }

    @Test
    public void testGetSetPatient() {
        Patient newPatient = new Patient("Test", 30, "female", "0123456789", "address");
        record.setPatient(newPatient);
        assertEquals(newPatient, record.getPatient());
    }

    @Test
    public void testGetSetDoctor() {
        Doctor newDoctor = new Doctor("Test", "Doc", "9876543210", 40);
        record.setDoctor(newDoctor);
        assertEquals(newDoctor, record.getDoctor());
    }

    @Test
    public void testGetSetDiagnosis() {
        String newDiagnosis = "Cold";
        record.setDiagnosis(newDiagnosis);
        assertEquals(newDiagnosis, record.getDiagnosis());
    }

    @Test
    public void testGetSetPrescription() {
        String newPrescription = "Medicine B";
        record.setPrescription(newPrescription);
        assertEquals(newPrescription, record.getPrescription());
    }

    @Test
    public void testStaticRecordId() {
        // Since recordId is static, it is shared across instances
        int firstRecordId = MedicalRecord.getRecordId();
        new MedicalRecord(new Patient("Another", 20, "female", "9876543210", "address"), 
                          new Doctor("Doctor", "Who", "1234567890", 45),
                          "Allergy", "Medicine C");
        assertEquals(firstRecordId + 1, MedicalRecord.getRecordId());
    }
}