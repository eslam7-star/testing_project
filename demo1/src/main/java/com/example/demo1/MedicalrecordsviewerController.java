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
        recordIdColumn.setCellValueFactory(new PropertyValueFactory<>("recordId"));
        patientColumn.setCellValueFactory(new PropertyValueFactory<>("patient_name"));
        doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctor_name"));
        diagnosisColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        prescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("prescription"));
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
        h.got_to(backButton,"patient_view.fxml",patient,null);
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
        tableView.getItems().addAll(patient.getMedicalRecords());
    }

}
