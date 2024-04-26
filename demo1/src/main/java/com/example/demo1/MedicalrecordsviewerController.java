package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MedicalrecordsviewerController implements Initializable {

    private Patient patient;

    private Doctor doctor;

    @FXML
    private Text type_search;

    @FXML
    private TableView<MedicalRecord> tableView;

    @FXML
    private TableColumn<MedicalRecord, Integer> recordIdColumn;

    @FXML
    private TableColumn<MedicalRecord, String> patientColumn;

    @FXML
    private TableColumn<MedicalRecord, String> doctorColumn;

    @FXML
    private TableColumn<MedicalRecord, String> diagnosisColumn;

    @FXML
    private TableColumn<MedicalRecord, String> prescriptionColumn;


    @FXML
    private TextField doctor_IdText;

    @FXML
    private Button searchButton;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recordIdColumn.setCellValueFactory(new PropertyValueFactory<MedicalRecord,Integer>("recordId"));
        patientColumn.setCellValueFactory(new PropertyValueFactory<MedicalRecord,String>("patient_name"));
        doctorColumn.setCellValueFactory(new PropertyValueFactory<MedicalRecord,String>("doctor_name"));
        diagnosisColumn.setCellValueFactory(new PropertyValueFactory<MedicalRecord,String>("diagnosis"));
        prescriptionColumn.setCellValueFactory(new PropertyValueFactory<MedicalRecord,String>("prescription"));
    }

    @FXML
    void onSearchButtonClicked() {
        String keyword = doctor_IdText.getText().trim();
        if (!keyword.isEmpty()) {
            ObservableList<MedicalRecord> filteredRecords = FXCollections.observableArrayList();
            for (MedicalRecord record : patient.getMedicalRecords()) {
                if (record.getDoctor().getName().equalsIgnoreCase(keyword)) {
                    filteredRecords.add(record);
                }
            }
            if (!filteredRecords.isEmpty()) {
                tableView.setItems(filteredRecords);
            }
        } else {
            tableView.setItems(FXCollections.observableArrayList(patient.getMedicalRecords()));
        }
    }

    @FXML
    void onBackButtonClicked() {
        HelloController h = new HelloController();
        if( patient != null ) {
            h.got_to(backButton, "patient_view.fxml", patient, null);
        }else if ( doctor != null ){
            h.got_to(backButton, "doctor_dashboard.fxml", null, doctor);
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        if ( patient != null ){
            populateTable(patient.getMedicalRecords());
        }
    }

    private void populateTable(List<MedicalRecord> records) {
        tableView.getItems().addAll(records);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        if( doctor != null){
            type_search.setText("Patient:");
            populateTable(doctor.getMedicalrecords());
        }
    }
}
