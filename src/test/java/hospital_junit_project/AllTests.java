package hospital_junit_project;



import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    PatientTest.class,
    AppointmentTest.class,
    MedicalRecordTest.class,
    BillingTest.class
})

public class AllTests {
    // This class remains empty, used only as a holder for the above annotations
}