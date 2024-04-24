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
        HelloController h = new HelloController();
        h.got_to(viewMedicalRecordsButton,"View_medicalrecords.fxml",patient,null);
    }


    public void set_Patient_id() {
        if (patient != null) {
            id_text.setText(patient.get_patientId()+"");
        }
    }

    @FXML
    void onAddAppointment(ActionEvent event) {
        HelloController h = new HelloController();
        h.got_to(addAppointmentButton,"Add_appointment.fxml",patient,null);
    }

    @FXML
    void onViewAppointments(ActionEvent event) {
        HelloController h = new HelloController();
        h.got_to(viewAppointmentsButton,"view_appointments.fxml",patient,null);
    }

    @FXML
    void onSignOut(ActionEvent event) {
        HelloController h = new HelloController();
        h.got_to(signOutButton,"login_form.fxml",null,null);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        set_Patient_id();
    }
}
