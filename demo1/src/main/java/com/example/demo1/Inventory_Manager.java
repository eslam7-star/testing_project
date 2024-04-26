package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class Inventory_Manager implements Initializable {

    private Doctor doctor;

    PatientRegistrationController p = new PatientRegistrationController();

    @FXML
    private DatePicker Ex_DATE;

    @FXML
    private TableColumn<InventoryItem, Date> Ex_date_col;

    @FXML
    private Spinner<Integer> Quantity;

    @FXML
    private Button add_button;

    @FXML
    private TableColumn<InventoryItem, Integer> id_col;

    @FXML
    private TextField item_name;

    @FXML
    private TableView<InventoryItem> items_table;

    @FXML
    private TableColumn<InventoryItem,String> name_col;

    @FXML
    private TextField price;

    @FXML
    private TableColumn<InventoryItem, Double> price_col;

    @FXML
    private TableColumn<InventoryItem, Integer> quantity_col;

    @FXML
    private Button remove_item;

    @FXML
    private Button return_button;

    @FXML
    void add_item(ActionEvent event) {
        String name = item_name.getText();
        int quantity = Quantity.getValue();
        double itemPrice;

        try {
            itemPrice = Double.parseDouble(price.getText());
            if( itemPrice < 5 || itemPrice > 10000){
                p.showAlert("NOT valid price","ERROR","PRICE range should in range 5-10000");
            }
        }catch ( Exception exception ){
            p.showAlert("NOT valid price","ERROR","CORRECT PRICE");
            return;
        }

        if( name.isEmpty() ){
            p.showAlert("empty name","Error","fill name field first");
            return;
        }

        LocalDate expiryDate = Ex_DATE.getValue();

        if( !HelloController.isMoreThanAWeekAhead(expiryDate)){
            p.showAlert("not valid date ","error","plz make sure the date is more than a week ahead");
        }
        InventoryItem newItem = new InventoryItem(name,quantity,itemPrice,expiryDate);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("added");
        alert.setHeaderText("INFO");
        alert.setContentText("added successfully");
        alert.showAndWait();

        items_table.getItems().add(newItem);
        item_name.clear();
        Quantity.getValueFactory().setValue(0);
        price.clear();
        Ex_DATE.setValue(null);
    }


    @FXML
    void back(ActionEvent event) {
        HelloController h = new HelloController();
        h.got_to(return_button,"doctor_dashboard.fxml",null,doctor);
    }

    @FXML
    void remove_ir(ActionEvent event) {
        InventoryItem selectedItem = items_table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            items_table.getItems().remove(selectedItem);
            InventoryItem.Items.remove(selectedItem);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("removed");
            alert.setHeaderText("INFO");
            alert.setContentText("removed successfully");
            alert.showAndWait();
        } else {
            p.showAlert("No Item Selected", "Error", "Please select an item to remove.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100, 1);
        Quantity.setValueFactory(valueFactory);

        id_col.setCellValueFactory(new PropertyValueFactory<InventoryItem,Integer>("Item_id"));
        name_col.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("name"));
        quantity_col.setCellValueFactory(new PropertyValueFactory<InventoryItem,Integer>("quantity"));
        price_col.setCellValueFactory(new PropertyValueFactory<InventoryItem,Double>("price"));
        Ex_date_col.setCellValueFactory(new PropertyValueFactory<InventoryItem,Date>("expiryDate"));
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
