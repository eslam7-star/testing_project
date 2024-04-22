package hospital_junit_project;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PatientTest {

    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient(1, "John Doe", 30, "Male", "1234567890", "123 Main St");
    }

    @AfterEach
    void tearDown() {
        patient = null;
    }

    @Order(1)
    @Test
    void testAddAppointment() {
        Appointment appointment = new Appointment(1, "2024-04-23", "10:00 AM", "Consultation");
        patient.addAppointment(appointment);
        List<Appointment> appointments = patient.getAppointments();
        assertTrue(appointments.contains(appointment));
    }

    @Order(2)
    @Test
    void testAddMedicalRecord() {
        MedicalRecord medicalRecord = new MedicalRecord(1, "2024-04-23", "Some diagnosis", "Prescription: Some medication");
        patient.addMedicalRecord(medicalRecord);
        List<MedicalRecord> medicalRecords = patient.getMedicalRecords();
        assertTrue(medicalRecords.contains(medicalRecord));
    }

    @Order(3)
    @Test
    void testAddBilling() {
        Billing billing = new Billing(1, "2024-04-23", 100.0);
        patient.addBilling(billing);
        List<Billing> billings = patient.getBillings();
        assertTrue(billings.contains(billing));
    }

    @Order(4)
    @Test
    void testUpdateDetails() {
        patient.updateDetails("456 Oak St", "0987654321");
        assertEquals("456 Oak St", patient.getAddress());
        assertEquals("0987654321", patient.getPhone());
    }

    @Order(5)
    @Test
    void testGetMedicalRecordById() {
        MedicalRecord medicalRecord1 = new MedicalRecord(1, "2024-04-23", "Some diagnosis", "Prescription: Some medication");
        MedicalRecord medicalRecord2 = new MedicalRecord(2, "2024-04-24", "Another diagnosis", "Prescription: Another medication");
        patient.addMedicalRecord(medicalRecord1);
        patient.addMedicalRecord(medicalRecord2);
        assertEquals(medicalRecord1, patient.getMedicalRecordById(1));
        assertEquals(medicalRecord2, patient.getMedicalRecordById(2));
        assertNull(patient.getMedicalRecordById(3)); // Record not found
    }

    @Order(6)
    @RepeatedTest(value = 3, name = "{displayName} - {currentRepetition}/{totalRepetitions}")
    @DisplayName("Testing Update Details")
    void testUpdateDetails_NotSame() {
        String oldAddress = patient.getAddress();
        String oldPhone = patient.getPhone();
        patient.updateDetails("456 Oak St", "0987654321");
        assertNotSame(oldAddress, patient.getAddress());
        assertNotSame(oldPhone, patient.getPhone());
    }

    @Order(7)
    @RepeatedTest(value = 2)
    void testGetMedicalRecordById_NotEquals() {
        MedicalRecord medicalRecord1 = new MedicalRecord(1, "2024-04-23", "Some diagnosis", "Prescription: Some medication");
        MedicalRecord medicalRecord2 = new MedicalRecord(2, "2024-04-24", "Another diagnosis", "Prescription: Another medication");
        patient.addMedicalRecord(medicalRecord1);
        patient.addMedicalRecord(medicalRecord2);
        assertNotEquals(medicalRecord1, patient.getMedicalRecordById(2));
    }

    @Order(8)
    @Nested
    class AddressPhoneTests {
        @Order(1)
        @Test
        void testUpdateAddress() {
            patient.updateDetails("456 Oak St", patient.getPhone());
            assertEquals("456 Oak St", patient.getAddress());
        }

        @Order(2)
        @Test
        void testUpdatePhone() {
            patient.updateDetails(patient.getAddress(), "0987654321");
            assertEquals("0987654321", patient.getPhone());
        }
    }

    @Order(9)
    @Test
    void testNoMedicalRecords() {
        List<MedicalRecord> medicalRecords = patient.getMedicalRecords();
        assertTrue(medicalRecords.isEmpty());
    }

    @Order(10)
    @Test
    void testNoAppointments() {
        List<Appointment> appointments = patient.getAppointments();
        assertTrue(appointments.isEmpty());
    }

    @Order(11)
    @Test
    void testNoBillings() {
        List<Billing> billings = patient.getBillings();
        assertTrue(billings.isEmpty());
    }

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Starting PatientTest");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Finished PatientTest");
    }
}
