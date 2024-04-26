package hospital_junit_project;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ doctor_appointment_billing.class, patient_appointment_inventory_item_medical_record.class })
public class AllTestswithsuites {

}
