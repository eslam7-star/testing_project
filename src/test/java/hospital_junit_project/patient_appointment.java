package hospital_junit_project;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ AppointmentTest.class, PatientTest.class })
public class patient_appointment {

}
