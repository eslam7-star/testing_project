package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AddappointmentController implements Initializable {

    private Patient patient;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<Doctor> doctorComboBox;


    @FXML
    private Spinner<Integer> timeSpinner;

    SpinnerValueFactory<Integer> sv = new SpinnerValueFactory.IntegerSpinnerValueFactory(8,21,1);

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;


    @FXML
    void onAddButtonClicked() {
        if (datePicker.getValue() == null || doctorComboBox.getValue() == null || timeSpinner.getValue() == null) {
            PatientRegistrationController p = new PatientRegistrationController();
            p.showAlert("empty fields","ERROR","PLEASE FILL EMPTY FIELDS");
            return;
        }

        LocalDate date = datePicker.getValue();
        int hour = timeSpinner.getValue();
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(hour, 0));

        Appointment appointment = new Appointment(dateTime, doctorComboBox.getValue(), patient);
        patient.add_appointment(appointment);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Appointment added successfully.");
        alert.showAndWait();
    }

    @FXML
    void onBackButtonClicked() {
        HelloController h = new HelloController();
        System.out.println(patient);
        h.got_to(backButton,"patient_view.fxml",patient,null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeSpinner.setValueFactory(sv);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
