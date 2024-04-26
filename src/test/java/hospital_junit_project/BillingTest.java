package hospital_junit_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;

class BillingTest {
    private Billing billing;
    private Patient patient;
    
    @BeforeEach
    void setUp() {
    	patient = new Patient("fares", 12, "male", "012343234","asdasd");
        billing = new Billing(patient, 1000.0);
    }

    @Test
    void testGetBillingId() {
    	int billings_count = Billing.getBillings_count();
    	Billing b = new Billing(patient, 1020.0);
        assertEquals(billings_count + 1, b.getBillingId());
    }
    
    @Test
    void testGetPatient() {
        assertEquals(patient, billing.getPatient());
    }

    @Test
    void testSetPatient() {
    	patient = new Patient("far", 14, "male", "01234323334","fasdasd");        
    	billing.setPatient(patient);
        assertEquals(patient, billing.getPatient());
    }

    @Test
    void testGetTotalAmount() {
        assertEquals(1000.0, billing.getTotalAmount());
    }

    @Test
    void testSetTotalAmount() {
        billing.setTotalAmount(2000.0);
        assertEquals(2000.0, billing.getTotalAmount());
    }

    @Test
    void testSetNegativeTotalAmount() {
        billing.setTotalAmount(-2000.0);
        assertNotEquals(-2000.0, billing.getTotalAmount());
        assertEquals(1000.0, billing.getTotalAmount());

    }
    
    @AfterEach
    void tearDown() {
        billing = null;
        patient = null;
    }
    
}
