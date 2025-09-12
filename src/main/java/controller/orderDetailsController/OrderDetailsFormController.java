package controller.orderDetailsController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.OrderDetails;

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

    OrderDetailsService orderDetailsService=new OrderDetailsController();

    public void clearOnAction(ActionEvent actionEvent) {
        txtDiscount.setText(null);
        txtOrderQTY.setText(null);
        txtOrderID.setText(null);
        txtItemCode.setText(null);
    }

    public void updateOnAction(ActionEvent actionEvent) {
        OrderDetails orderDetails=new OrderDetails(
                txtOrderID.getText(),
                txtItemCode.getText(),
                Integer.parseInt(txtOrderQTY.getText()),
                Integer.parseInt(txtDiscount.getText())
        );

        orderDetailsService.update(orderDetails);
        viewOnAction(actionEvent);
        clearOnAction(actionEvent);

    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String id1=txtOrderID.getText();
        String id2=txtItemCode.getText();
        orderDetailsService.delete(id1,id2);
        viewOnAction(actionEvent);
        clearOnAction(actionEvent);

    }

    public void addOnAction(ActionEvent actionEvent) {
        OrderDetails orderDetails=new OrderDetails(
                txtOrderID.getText(),
                txtItemCode.getText(),
                Integer.parseInt(txtOrderQTY.getText()),
                Integer.parseInt(txtDiscount.getText())
        );

        orderDetailsService.add(orderDetails);
        viewOnAction(actionEvent);
        clearOnAction(actionEvent);

    }

    public void viewOnAction(ActionEvent actionEvent) {

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
