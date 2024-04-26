package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Doctor_dashboard_controller {

    private Doctor doctor;
    HelloController h = new HelloController();

    @FXML
    private Button ViewMedicalRecordsButton;

    @FXML
    private Text id_text;

    @FXML
    private Button signOutButton;

    @FXML
    private Button viewAppointmentsButton;

    @FXML
    private Button CreateMedicalRecordsButton;

    @FXML
    private Button Manage_InventoryItems;


    @FXML
    void onSignOut(ActionEvent event) {
        h.got_to(signOutButton,"login_form.fxml",null,null);
    }

    @FXML
    void onViewAppointments(ActionEvent event) {
        h.got_to(viewAppointmentsButton,"view_appointments.fxml",null,doctor);
    }

    @FXML
    void onViewMedicalRecords(ActionEvent event) {
        h.got_to(ViewMedicalRecordsButton,"View_medicalrecords.fxml",null,doctor);
    }

    @FXML
    public void onManage_InventoryItems(){
        h.got_to(Manage_InventoryItems,"InventoryItemsM.fxml",null,doctor);
    }

    @FXML
    public void setCreateMedicalRecordsButton(){
        h.got_to(CreateMedicalRecordsButton,"create_medicalrecord.fxml",null,doctor);
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        if( doctor != null ){
            id_text.setText(doctor.getDoctorId()+"");
        }
    }

}

