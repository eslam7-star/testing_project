package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Create_Medicalreport_Controller {
    private Doctor doctor;

    @FXML
    private TextField patientNameField;

    @FXML
    private TextField diagnosisField;

    @FXML
    private TextField prescriptionField;

    @FXML
    private Button addRecordButton;

    @FXML
    private Button backButton;


    @FXML
    private void addRecord() {
        String patientName = patientNameField.getText();
        String diagnosis = diagnosisField.getText();
        String prescription = prescriptionField.getText();
        PatientRegistrationController p = new PatientRegistrationController();

        if( patientName.isEmpty() || diagnosis.isEmpty() || prescription.isEmpty() ){

            p.showAlert("Empty fields","Error","plz fill empty fields ");
        }else {
            if( Patient.getPatientByName(patientName) != null ) {
                doctor.createMedicalRecord(Patient.getPatientByName(patientName),diagnosis,prescription);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("MedicalRecord added successfully.");
                alert.showAndWait();
            }else{
                p.showAlert("Error patient name is not found","ERROR","Plz enter valid patient name");
            }
        }
    }

    @FXML
    private void goBack() {
        HelloController h = new HelloController();
        h.got_to(backButton,"doctor_dashboard.fxml",null,doctor);

    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
