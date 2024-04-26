package hospital_junit_project;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    private Doctor doctor;
    private Appointment appointment;
    private Appointment appointment2;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    void setUp() {
        doctor = new Doctor("John Doe", "Cardiology", "123-456-7890", 150.0);
        appointment = new Appointment(
                LocalDateTime.of(2024, 4, 20, 9, 0),
                doctor,
                new Patient("Jane Smith", 30, "Female", "9876543210", "123 Main St")
            );
		 appointment2=new Appointment(LocalDateTime.now(), doctor, new Patient("Alice", 25, "Female", "555-555-5555", "456 Elm St"));


    }

    @Test
    @Order(1)
    void testConstructor() {
        assertNotNull(doctor);
        assertEquals("John Doe", doctor.getName());
        assertEquals("Cardiology", doctor.getDepartment());
        assertEquals("123-456-7890", doctor.getPhone());
        assertEquals(150.0, doctor.getBill_amount());
        assertFalse(doctor.getAppointments().isEmpty());
    }

    @Test
    @Order(2)
    void testAddAppointment() {
        assertFalse(doctor.getAppointments().isEmpty());

        doctor.add_appointment(appointment);
        List<Appointment> appointments = doctor.getAppointments();

        assertFalse(appointments.isEmpty());
        assertSame(appointment, appointments.get(0));
    }

    @Test
    @Order(3)
    void testGetSetBillAmount() {
        assertEquals(150.0, doctor.getBill_amount());

        doctor.setBill_amount(200.0);
        assertEquals(200.0, doctor.getBill_amount());
    }


    @Test
    @Order(4)
    @DisplayName("Testing GetDoctorId")
    void testGetDoctorId() {
    	int d= Doctor.getNoOfDoctors();
    	Doctor doctor2 = new Doctor("Franklin", "Emergency", "123-123-4567", 200.0);
        assertEquals(d+1, doctor2.getDoctorId());
    }
    

    @Test
    @Order(5)
    void testSetName() {
        assertEquals("John Doe", doctor.getName());

        doctor.setName("Dr. John");
        assertNotEquals("John Doe", doctor.getName());
        assertEquals("Dr. John", doctor.getName());      
    }

    @Test
    @Order(6)
    void testSetDepartment() {
        assertEquals("Cardiology", doctor.getDepartment());

        doctor.setDepartment("Neurology");
        assertNotSame("Cardiology", doctor.getDepartment());
        assertEquals("Neurology", doctor.getDepartment());
    }

    @Test
    @Order(7)
    void testSetPhone() {
        assertEquals("123-456-7890", doctor.getPhone());

        doctor.setPhone("987-654-3210");
        assertNotEquals("123-456-7890", doctor.getPhone());
        assertEquals("987-654-3210", doctor.getPhone());       
    }

    @Test
    @Order(8)
    void testToString() {
        String expected = "Doctor{name='John Doe', department='Cardiology', phone='123-456-7890'}";
        assertEquals(expected, doctor.toString());
    }

    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @Order(9)
    void testRepeatedAddAppointment(RepetitionInfo repetitionInfo) {
        doctor.add_appointment(appointment);
        List<Appointment> appointments = doctor.getAppointments();
        assertTrue(appointments.size() > 0);   
    }   

    @Nested
    @DisplayName("Additional Tests")
    class AdditionalTests {
        @Test
        @Order(10)
        @DisplayName("Testing Null Appointment")
        void testNullAppointment() {
            assertNull(null);
        }


        
        @Test
        @Order(12)
        @DisplayName("Testing Doctor Attributes")
        void testDoctorAttributes() {
            Doctor doctor3 = new Doctor("Mary Johnson", "Pediatrics", "555-555-5555", 180.0);
            assertEquals("Mary Johnson", doctor3.getName());
            assertEquals("Pediatrics", doctor3.getDepartment());
            assertEquals("555-555-5555", doctor3.getPhone());
            assertEquals(180.0, doctor3.getBill_amount());
            assertTrue(doctor3.getAppointments().isEmpty());
        }


    }
    @Test
    @Order(1)
    @DisplayName("Test Negative Values For Bill_amount ")
    void testSetNegativeBillAmount() {
       doctor.setBill_amount(-100);
        assertNotEquals(-100, doctor.getBill_amount());
    }
	@Test 
	@Order(2)
	@DisplayName("TestBoundriesValues ")
	
	void testSetBoundriesValues() {
		doctor.setBill_amount(100);
		assertEquals (100, doctor.getBill_amount());
		doctor.setBill_amount(300);
		assertEquals (300, doctor.getBill_amount());
		
		
	}
	@Test
	@Order(3)
	@DisplayName("Test lower Boundry Values ")
	void testSetlowBoundryvalue() {
		doctor.setBill_amount(99.999);
		assertEquals(150.0,doctor.getBill_amount());
	}
	@Test
	@Order(4)
	@DisplayName("Test Upper Boundry Values ")
	void testSethighboundryvalue() {
		doctor.setBill_amount(300.001);
		assertEquals(150.0,doctor.getBill_amount());
	
	}
	@Test
    void testAddMultipleAppointments() {
		doctor.delete_appointments();

		doctor.add_appointment(appointment);
        doctor.add_appointment(appointment2);
        assertEquals(2,doctor.getAppointments().size());
}
	@Test
	void testDeleteappointments() {
		doctor.delete_appointments();
		assertEquals(0,doctor.getAppointments().size());
	}
       
    @AfterEach
    void tearDown() {
    	
    	doctor = null;
        appointment = null;
        
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all tests");
    }
    
  
}
