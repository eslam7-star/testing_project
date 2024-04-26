package hospital_junit_project;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ BillingTest.class, doctor_appoinmtent.class })
public class doctor_appointment_billing {

}
