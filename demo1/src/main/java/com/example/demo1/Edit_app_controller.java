package com.example.demo1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Edit_app_controller {
    @FXML
    private DatePicker dp;

    @FXML
    private ComboBox<Integer> h;
    @FXML
    private ComboBox<Integer> m;
    @FXML
    private Button c;

    private int hour;
    private int mins;

    @FXML
    public void initialize() {

        for (int i = 1; i <= 24; i++) {
            h.getItems().add(i);
        }
        for (int i = 0; i <= 60; i++) {
            m.getItems().add(i);
        }

    }

    @FXML
    private void handleSubmitButtonAction() {
  if(h.getValue()!=null && m.getValue()!=null && dp.getValue()!=null) {
        hour = h.getValue();
        mins = m.getValue();
        LocalDateTime dateTime = LocalDateTime.of(dp.getValue(), LocalTime.of(hour, mins));
        if( HelloController.isBeforeCurrentHour(dateTime) ){
            PatientRegistrationController p = new PatientRegistrationController();
            p.showAlert("Error","date is not valid ","plz update with a valid date");
            return;
        }
        if(Appointment_controller.getSelectedAppointment()!=null) {
            Appointment_controller.getSelectedAppointment().reschedule(dateTime);
        }
        HelloController h = new HelloController();
        h.got_to(c, "view_appointments.fxml", Appointment_controller.getPatient2(), null);
    }else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("INfo");
      alert.setHeaderText(null);
      alert.setContentText(" fill all fields ");
      alert.showAndWait();
      }
  }

    public void back(ActionEvent actionEvent) {
        HelloController h = new HelloController();
        h.got_to(c, "view_appointments.fxml", Appointment_controller.getPatient2(), null);
    }
}
