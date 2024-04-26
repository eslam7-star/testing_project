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
    void testSetName() {
        // Set a new name
        String newName = "Jane Smith";
        patient.setName(newName);

        // Verify that the name was set correctly
        assertEquals(newName, patient.getName());
    }


    @Test
    void testSetAndGetPhone() {
        // Set a new phone number
        String newPhone = "987-654-3210";
        patient.setPhone(newPhone);

        // Verify that the phone number was set correctly
        assertEquals(newPhone, patient.getPhone());
    }

    @Test
    void testSetAndGetAddress() {
        // Set a new address
        String newAddress = "456 Elm St";
        patient.setAddress(newAddress);

        // Verify that the address was set correctly
        assertEquals(newAddress, patient.getAddress());
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
        assertEquals(2, patient.getAppointments_count());
    }
    @Test
    @Order(3)
    @DisplayName("Test patientId")
    void testpatientId () {
    	int c = Patient.getNo_of_patients();
        Patient patient2 = new Patient("h",15,"female","145555","125 stree");
    	assertEquals(c+1,patient2.get_patientId());
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
        assertEquals(1, patient.getBillings_count());
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
    static void afterAll()
    {
        System.out.println("Setting up before all tests...");
    }
   
    
    @Test 
    void testSetAgelowBoundry() {
    	patient .setAge(5);
    	//certain that the age don't change to forbidden value 
    	assertNotEquals(5,patient.getAge());
    	assertEquals(30,patient.getAge());
    }
    @Test 
    void testSetAgeBoundry() {
    	patient .setAge(6);
    	assertEquals(6,patient.getAge());
    }
    @Test
    void testSetAge() {
 	   //Set a new age
 	   int newage=29;
 	   patient.setAge(newage);
 	   assertEquals(newage,patient.getAge());
    }
    @Test
    void testSetnegativeAge() {
 	   //Set a new age
 	   int newage=-29;
 	   patient.setAge(newage);
 	   //shows that the age don't change 
 	   assertEquals(30,patient.getAge());
    }

    @Test 
    void testSetemptyaddress() { 
    	patient.setAddress("");
    	String  newaddress=patient.getAddress();
    	assertNotEquals("",newaddress);
    	assertEquals("123 Main St",newaddress);
    }
    @Test
    @Order(1)
    @DisplayName("test true gendersetting and certain that the system accept male or female with any form ")

    void testtruegendersetting() {
    	patient .setGender("MALE");
    	String patientgender =patient.getGender();
    	assertEquals("MALE",patientgender);
    }
    @Test
    @Order(2)
    @DisplayName("test false gendersetting and certain that the system don't accept any other string  ")
    void testfalsegendersetting() {
    	String vlaueforsetting ="java";
    	patient .setGender(vlaueforsetting);
    	String patientgender =patient.getGender();
    	assertNotEquals(vlaueforsetting,patientgender);
    }
 
     @Test
     @Order(3)
     @DisplayName("test normal input from user ")
     void testSetAndGetGender() {
         // Set a new gender
         String newGender = "Female";
         patient.setGender(newGender);

         // Verify that the gender was set correctly
         assertEquals(newGender, patient.getGender());
     }

}
