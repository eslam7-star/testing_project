package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MedicalrecordsviewerController implements Initializable {

    private Patient patient;

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
        h.got_to(backButton,"patient_view.fxml",patient,null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (patient != null) {
            // Initialize the table with patient's medical records
            ObservableList<MedicalRecord> medicalRecords = FXCollections.observableArrayList(patient.getMedicalRecords());
            tableView.setItems(medicalRecords);
            // Initialize table columns
            recordIdColumn.setCellValueFactory(new PropertyValueFactory<>("recordId"));
            patientColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
            doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
            diagnosisColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
            prescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("prescription"));

            tableView.getItems().addAll(patient.getMedicalRecords());
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}