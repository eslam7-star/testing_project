package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class Appointment_controller implements Initializable {

    private static Patient patient;
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
    private Button search_app;

    @FXML
    private Button remove_app;

    @FXML
    private Button back;
    @FXML
    private ComboBox<Integer> yearComboBox;

    private  static Appointment selectedAppointment = null;

    public static Appointment getSelectedAppointment() {
        return selectedAppointment;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        appointmentLocalDateTime.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("dateTime"));
        appointmentDoctorTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("doctor_name"));
        appointmentPatientTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("patient_name"));
        appointment_bill.setCellValueFactory(new PropertyValueFactory<Appointment,Double>("bill_amount"));
        appointmentTableView.setRowFactory(tv -> {
            TableRow<Appointment> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton()==MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    Appointment clickedRow = row.getItem();
                    selectedAppointment = clickedRow;
                }
            });
            return row ;
        });
    }

    @FXML
    private void remove_appointment() {
        if (selectedAppointment != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INfo");
            alert.setHeaderText(null);
            alert.setContentText(" Removed Successfully ");
            alert.showAndWait();
            HelloController h = new HelloController();

            if( patient != null ){
                patient.removeAppointment(selectedAppointment);
                selectedAppointment.getDoctor().getAppointments().remove(selectedAppointment);
                h.got_to(back, "view_appointments.fxml", patient, null);
            }else if( doctor != null ){
                doctor.getAppointments().remove(selectedAppointment);
                selectedAppointment.getPatient().getAppointments().remove(selectedAppointment);
                h.got_to(back,"view_appointments.fxml",null,doctor);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INfo");
            alert.setHeaderText(null);
            alert.setContentText(" click on appointment in table first ");
            alert.showAndWait();
        }
    }


    @FXML
    private void go_to_edit_appointment() {
        if( doctor != null)
            return;
        if(selectedAppointment != null) {
            HelloController h = new HelloController();
            h.got_to(back, "Edit_app.fxml", patient, null);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INfo");
            alert.setHeaderText(null);
            alert.setContentText(" click on appointment in table first ");
            alert.showAndWait();
        }
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
        if (patient != null) {
            populateTable(patient.getAppointments());
        }
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        patient = null;
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
        if( patient != null ) {
            h.got_to(back, "patient_view.fxml", patient, null);
        }else if( doctor != null ){
            h.got_to(back,"doctor_dashboard.fxml",null,doctor);
        }
    }

    public static Patient getPatient2(){
        return patient;
    }




}
