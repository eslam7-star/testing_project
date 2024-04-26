package hospital_junit_project;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ AppointmentTest.class, DoctorTest.class })
public class doctor_appoinmtent {

}
