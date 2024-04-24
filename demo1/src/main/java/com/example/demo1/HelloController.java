package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
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
    private void Login() {
        String name = txtName.getText();
        String password = pass.getText();
        String Type = type.getValue();

        System.out.println("Registered "+ Type + ": " + name + ", pass: " + password);
    }

    @FXML
    private void got_to_register() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Register_patient.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) register.getScene().getWindow();

            stage.hide();

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
