package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class Appointment_controller implements Initializable {

    private Patient patient;
    private Doctor doctor;

    @FXML
    private TableView<Appointment> appointmentTableView;

    @FXML
    private TableColumn<Appointment, LocalDateTime> appointmentLocalDateTime;

    @FXML
    private TableColumn<Appointment, String> appointmentDoctorTableColumn;

    @FXML
    private TableColumn<Appointment, String> appointmentPatientTableColumn;

    @FXML
    private TableColumn<Appointment, Double> appointment_bill;

    @FXML
    private TextField patient_txt;

    @FXML
    private TextField doctor_txt;

    @FXML
    private Button search_app;

    @FXML
    private Button remove_app;

    @FXML
    private Button back;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentLocalDateTime.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("dateTime"));
        appointmentDoctorTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("doctor_name"));
        appointmentPatientTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("patient_name"));
        appointment_bill.setCellValueFactory(new PropertyValueFactory<Appointment,Double>("bill_amount"));
    }

    @FXML
    private void remove_appointment() {
        // Add logic to remove an appointment
    }

    @FXML
    private void search_appointment() {
        // Add logic to search for an appointment
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        if (patient != null) {
            populateTable(patient.getAppointments());
        }
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        if (doctor != null) {
            populateTable(doctor.getAppointments());
        }
    }

    private void populateTable(List<Appointment> appointments) {
        appointmentTableView.getItems().setAll(appointments);
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @FXML
    public void back(){
        HelloController h = new HelloController();
        h.got_to(back,"patient_view.fxml",patient,null);
    }
}
