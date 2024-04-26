package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PatientRegistrationController {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAge;

    @FXML
    private ComboBox<String> gender;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button back;



    @FXML
    private void Register() {
        String name = txtName.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();
        String ageText = txtAge.getText();
        String Gender = gender.getValue();

        // Validate input
        if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || ageText.isEmpty() || Gender.isEmpty()) {
            showAlert("Error", "All fields are required", "Please fill in all the fields.");
            return;
        }
        try {
            int age = Integer.parseInt(ageText);
            if( age < 6 ){
                showAlert("Error","age not correct","plz age should be not less than 6");
            }
        }catch (Exception exception){
            showAlert("Error","age not correct","plz update age again");
        }

        Patient patient = Patient.getPatientByName(name);
        if( patient != null ){
            showAlert("name is already exists","ERROR","PLZ change the name");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid Age", "Please enter a valid age as a positive integer.");
            return;
        }

        Patient newPatient = new Patient(name, age, Gender, phone, address);

        // dummy data
        Doctor doctor1 = new Doctor("Dr. Smith", "Cardiologist", "23534534",200.0);
        Doctor doctor2 = new Doctor("Dr. Johnson", "Neurologist", "234234234",250.0);
        MedicalRecord record1 = new MedicalRecord(newPatient, doctor1, "Hypertension", "Prescription A");
        MedicalRecord record2 = new MedicalRecord(newPatient, doctor2, "Migraine", "Prescription B");
        doctor1.add_medical_record(record1);
        doctor1.add_medical_record(record2);
        doctor2.add_medical_record(record2);
        doctor2.add_medical_record(record1);


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registered");
        alert.setHeaderText("INFO");
        alert.setContentText("your ID :"+newPatient.get_patientId());
        alert.showAndWait();

    }

    public void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void back_to_login(){
        HelloController h = new HelloController();
        h.got_to(back,"login_form.fxml",null,null);
    }


}
