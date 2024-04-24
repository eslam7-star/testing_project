package hospital_junit_project;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ AppointmentTest.class, BillingTest.class, InventoryItemTest.class, MedicalRecordTest.class,
		PatientTest.class, DoctorTest.class })
public class AllTests {

}
