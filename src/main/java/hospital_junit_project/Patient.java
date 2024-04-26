package hospital_junit_project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Patient {
    private  int patientId = 0;
    
    private String name;                
    private static int no_of_patients=0;
    private int age;
    private String gender;
    private String phone,address;
    private List<Appointment> appointments;
    private List<MedicalRecord> medicalRecords;
    private List<Billing> billings;

    public Patient(String name, int age, String gender, String phone , String address) {
        no_of_patients++;
        this.patientId= no_of_patients;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.appointments = new ArrayList<>();
        this.medicalRecords = new ArrayList<>();
        this.billings = new ArrayList<>();
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
    	return this.address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
    	return this.phone;
    }
    public int get_patientId() {
    	return this.patientId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
       if (age>=0)
    	this.age = age;
       else 
    	   System.out.println("Enter Valid Age");
    }

    public int getAge() {
        return age;
    }
    public void setGender(String gender) {
     
    this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
  
    

    public Appointment make_an_Appointment(LocalDateTime dateTime, Doctor doctor) {
        return new Appointment(dateTime, doctor, this);
    }
    
    public void add_appointment(Appointment app) {
    	if( app != null )
    		appointments.add(app);
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    public void addBilling(Billing billing) {
        billings.add(billing);
    }

    public void updateDetails(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }
    
    public MedicalRecord getMedicalRecordById(int recordID) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordID() == recordID) {
                return record;
            }
        }
        return null;
    }

    
    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }


    public static int getNo_of_patients() {
        return no_of_patients;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public  List<Appointment> getAppointments () {
    	return appointments;
    }
    public  int getAppointments_count () {
    	return appointments.size();
    }
    public int getBillings_count() {
    	return billings.size();
    }
    
    public List<Billing>  getBillings() {
    	return billings;
    }
 
   
}

