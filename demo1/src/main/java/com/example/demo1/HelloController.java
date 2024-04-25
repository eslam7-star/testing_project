package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class HelloController {


    @FXML
    private TextField txtName;

    @FXML
    private TextField pass;

    @FXML
    private ComboBox<String> type;

    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    private Button register_adoctor;


    @FXML
    private void Login() {
        String name = txtName.getText();
        String password = pass.getText();
        String Type = type.getValue();

        if (name.isEmpty() || password.isEmpty() || Type == null ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please enter username, password, and select user type.");
            alert.showAndWait();
            return;
        }

        if( Type.equals("Patient") ){
            for( Patient pat : Patient.getAllPatients() ){
                if( (pat.get_patientId() + "").equals(password) && pat.getName().equals(name) ){
                    got_to(login,"patient_view.fxml",pat,null);
                    return;
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INfo");
            alert.setHeaderText(null);
            alert.setContentText(" Not found ");
            alert.showAndWait();

        }else {
            for( Doctor doc : Doctor.getDoctors() ){
                if( (doc.getDoctorId()+ "").equals(password) && doc.getName().equals(name) ){
                    got_to(login,"doctor_dashboard.fxml",null,doc);
                    return;
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INfo");
            alert.setHeaderText(null);
            alert.setContentText(" Not found ");
            alert.showAndWait();
        }


    }

    @FXML
    private void got_to_register() {
        got_to(register,"Register_patient.fxml",null,null);

    }

    @FXML
    private void go_to_doctor_reg(){
        got_to(register_adoctor,"Register_adocotr.fxml",null,null);
    }


    public void got_to(Button btn,String resource , Patient patient , Doctor doctor) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent root = loader.load();
            Object controller = loader.getController();
            if( patient != null ) {
                if( controller instanceof Patient_dashboard_controller ) {
                    ((Patient_dashboard_controller) controller).setPatient(patient);
                }else if( controller instanceof Appointment_controller ){
                    ((Appointment_controller) controller).setPatient(patient);
                }else if( controller instanceof AddappointmentController  ){
                    ((AddappointmentController) controller).setPatient(patient);
                }else if( controller instanceof MedicalrecordsviewerController ){
                    ((MedicalrecordsviewerController) controller).setPatient(patient);
                }
            }else if( doctor != null ){
                if( controller instanceof Doctor_dashboard_controller ){
                    ((Doctor_dashboard_controller) controller).setDoctor(doctor);
                }else if( controller instanceof Create_Medicalreport_Controller ){
                    ((Create_Medicalreport_Controller) controller).setDoctor(doctor);
                }

            }

            Scene scene = new Scene(root);
            Stage stage = (Stage) btn.getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
