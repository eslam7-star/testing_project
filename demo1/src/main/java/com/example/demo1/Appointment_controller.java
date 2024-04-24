package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.util.List;

public class Appointment_controller {

    private Patient patient;
    private Doctor doctor;

    @FXML
    private TableView<Appointment> appointmentTableView;

    @FXML
    private TableColumn<Appointment, LocalDateTime> appointmentLocalDateTime;

    @FXML
    private TableColumn<Appointment, Doctor> appointmentDoctorTableColumn;

    @FXML
    private TableColumn<Appointment, Patient> appointmentPatientTableColumn;

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
    private void initialize() {
        if( patient == null && doctor == null )
            throw new RuntimeException("null pointer exception");
        appointmentLocalDateTime.setCellValueFactory(cellData -> cellData.getValue().getDateTime());
        appointmentDoctorTableColumn.setCellValueFactory(cellData -> cellData.getValue().getDoctor().getName());
        appointmentPatientTableColumn.setCellValueFactory(cellData -> cellData.getValue().getPatient().getName());
        appointment_bill.setCellValueFactory(cellData -> cellData.getValue().getBill());
    }


    @FXML
    private void remove_appointment() {

    }

    @FXML
    private void search_appointment() {

    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        if (patient != null) {
            populateTable(patient.);
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


}
