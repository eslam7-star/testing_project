package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Doctor_registeration implements Initializable {

    private Doctor doctor;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private ChoiceBox<String> departmentChoiceBox;

    @FXML
    private TextField billAmountTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Button backButton;

    @FXML
    private void register() {
        String name = nameTextField.getText();
        String phone = phoneTextField.getText();
        String department = departmentChoiceBox.getValue();
        PatientRegistrationController p = new PatientRegistrationController();
        double billAmount;

        try {
            billAmount = Double.parseDouble(billAmountTextField.getText());
        }catch (Exception e){
            p.showAlert("Error","wrong bill amount field","plz fill fields correctly ");
            return;
        }
        if (name.isEmpty() || phone.isEmpty() || department == null || billAmountTextField.getText().isEmpty() || billAmount < 0 ) {
            p.showAlert("Error","Empty fields","plz fill empty fields ");
        }else {
            doctor = new Doctor(name,department,phone,billAmount);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Registered");
            alert.setHeaderText("INFO");
            alert.setContentText("your ID :"+doctor.getDoctorId());
            alert.showAndWait();
        }
    }


    @FXML
    private void back(){
        HelloController h = new HelloController();
        h.got_to(backButton,"login_form.fxml",null,doctor);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        departmentChoiceBox.getItems().addAll("ENT (Ear, Nose, and Throat) Department", "Urology Department", "Ophthalmology Department","Pediatrics Department","General Surgery","Gastroenterology Department","Casualty Department (Emergency Department)","Intensive Care Unit (ICU)","Operating Theatre (OT)","Other");

    }
}
