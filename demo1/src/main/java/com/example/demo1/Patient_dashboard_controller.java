package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.time.LocalTime;

public class Patient_dashboard_controller {

    private Patient patient;

    @FXML
    private Text id_text;

    @FXML
    private Button viewMedicalRecordsButton;

    @FXML
    private Button addAppointmentButton;

    @FXML
    private Button viewAppointmentsButton;

    @FXML
    private Button signOutButton;

    @FXML
    void onViewMedicalRecords(ActionEvent event) {

    }


    @FXML
    void initialize() {
        setPatient(patient);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        if (patient != null) {
            id_text.setText("Patient ID: " + patient.get_patientId());
        }
    }

    @FXML
    void onAddAppointment(ActionEvent event) {

    }

    @FXML
    void onViewAppointments(ActionEvent event) {

    }

    @FXML
    void onSignOut(ActionEvent event) {

    }



}
