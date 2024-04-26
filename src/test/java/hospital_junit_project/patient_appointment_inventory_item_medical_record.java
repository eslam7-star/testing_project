package hospital_junit_project;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ MedicalRecordTest.class, patient_appointment_inventory_item.class })
public class patient_appointment_inventory_item_medical_record {

}
