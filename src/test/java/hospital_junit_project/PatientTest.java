package hospital_junit_project;

import org.junit.jupiter.api.*;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    private Patient patient;
    private Doctor doctor;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        patient = new Patient("John", 30, "Male", "123456789", "123 Main St");
        doctor = new Doctor("Dr. Smith", "Cardiologist", "987654321", 0.0);
        appointment = new Appointment(LocalDateTime.now().plusDays(1), doctor, patient);
    }
    

    @Test
    @Order(1)
    @DisplayName("Test make_an_Appointment")
    void testMake_an_Appointment() {
        assertNotNull(patient.make_an_Appointment(LocalDateTime.now().plusDays(2), doctor));
    }

    @Test
    @Order(2)
    @DisplayName("Test add_appointment")
    void testAdd_appointment() {
        patient.add_appointment(appointment);
        assertEquals(2, patient.getAppointments());
    }
    @Test
    @Order(3)
    @DisplayName("Test patientId")
    void testpatientId () {
        Patient patient2 = new Patient("h",15,"female","145555","125 stree");

    	assertEquals(1,patient.get_patientId());
    	assertEquals(2,patient2.get_patientId());

    }

    @Test
    @Order(4)
    @DisplayName("Test addMedicalRecord")
    void testAddMedicalRecord() {
        MedicalRecord medicalRecord = new MedicalRecord(patient, doctor, "diabetes","prescription");
        patient.addMedicalRecord(medicalRecord);
        assertEquals(1, patient.getMedicalRecords().size());
    }

    @Test
    @Order(5)
    @DisplayName("Test addBilling")
    void testAddBilling() {
        Billing billing = new Billing(patient, 100);
        patient.addBilling(billing);
        assertEquals(1, patient.getBillings());
    }

    @Test
    @Order(6)
    @DisplayName("Test updateDetails")
    void testUpdateDetails() {
        patient.updateDetails("456 Elm St", "987654321");
        assertEquals("456 Elm St", patient.getAddress());
        assertEquals("987654321", patient.getPhone());
    }

    @RepeatedTest(3)
    @Order(7)
    @DisplayName("Repeated Test for updateDetails")
    void repeatedTestUpdateDetails() {
        patient.updateDetails("789 Oak St", "555666777");
        assertEquals("789 Oak St", patient.getAddress());
        assertEquals("555666777", patient.getPhone());
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("Nested Test for getMedicalRecordById")
    class GetMedicalRecordByIdTest {
        private MedicalRecord medicalRecord;

        @BeforeEach
        void setUp() {
            medicalRecord = new MedicalRecord(patient, doctor,  "diabetes","prescription");
            patient.addMedicalRecord(medicalRecord);
        }

        @Test
        @Order(1)
        void testGetMedicalRecordById() {
            assertNotNull(patient.getMedicalRecordById(medicalRecord.getRecordID()));
        }

        @Test
        @Order(2)
        void testGetMedicalRecordById_NotFound() {
            assertNull(patient.getMedicalRecordById(-1));
        }
    }

    @AfterEach
    void tearDown() {
        // Clean up after each test
        patient = null;
        doctor = null;
        appointment = null;
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Cleaning up after all tests...");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("Setting up before all tests...");
    }
}
