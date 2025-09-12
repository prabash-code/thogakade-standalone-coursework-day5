package controller.orderDetailsController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailsFormController implements Initializable {
    public TableView tableOrderDetails;
    public TableColumn colOrderID;
    public TableColumn colItemCode;
    public TableColumn ColOrderID;
    public TableColumn colDiscount;
    public JFXTextField txtOrderID;
    public JFXTextField txtItemCode;
    public JFXTextField txtDiscount;
    public JFXTextField txtOrderQTY;
    public JFXButton btnClear;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXButton btnView;
    public TableColumn colQty;

    public void clearOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void addOnAction(ActionEvent actionEvent) {
    }

    public void viewOnAction(ActionEvent actionEvent) {
        OrderDetailsService orderDetailsService=new OrderDetailsController();
        tableOrderDetails.setItems(orderDetailsService.view());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }
}
