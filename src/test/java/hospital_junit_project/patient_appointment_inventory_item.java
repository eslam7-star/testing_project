package hospital_junit_project;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ InventoryItemTest.class, patient_appointment.class })
public class patient_appointment_inventory_item {

}
