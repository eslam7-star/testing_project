package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MedicalrecordsviewerController {

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> recordIdColumn;

    @FXML
    private TableColumn<?, ?> patientColumn;

    @FXML
    private TableColumn<?, ?> doctorColumn;

    @FXML
    private TableColumn<?, ?> diagnosisColumn;

    @FXML
    private TableColumn<?, ?> prescriptionColumn;

    @FXML
    private TextField patientIdTextField;

    @FXML
    private Text patientIdText;

    @FXML
    private Button searchButton;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        // Initialize your controller here
    }

    @FXML
    void onSearchButtonClicked() {
        // Handle search button click here
    }

    @FXML
    void onBackButtonClicked() {
        // Handle back button click here
    }
}
