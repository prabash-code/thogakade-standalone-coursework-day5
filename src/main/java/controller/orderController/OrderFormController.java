package controller.orderController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Orders;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {
    public JFXTextField txtOrderId;
    public JFXTextField txtCustomerId;
    public TableView tableOrder;
    public TableColumn colOrderId;
    public TableColumn colCustId;
    public TableColumn colOrderDate;
    public DatePicker date;
    public JFXButton btnClear;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXButton btnView;

    public void clearOnAction(ActionEvent actionEvent) {
        txtCustomerId.setText(null);
        txtOrderId.setText(null);
        date.setValue(null);
    }

    public void updateOnAction(ActionEvent actionEvent) {
        Orders orders=new Orders(
                txtOrderId.getText(),
                date.getValue().toString(),
                txtCustomerId.getText()
        );
        OrderService orderService=new OrderController();
        orderService.update(orders);
        viewOnAction(actionEvent);
        clearOnAction(actionEvent);
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void addOnAction(ActionEvent actionEvent) {
        Orders orders=new Orders(
                txtOrderId.getText(),
                date.getValue().toString(),
                txtCustomerId.getText()
        );
        OrderService orderService=new OrderController();
        orderService.add(orders);
        viewOnAction(actionEvent);
    }

    public void viewOnAction(ActionEvent actionEvent) {
        OrderService orderService=new OrderController();
        tableOrder.setItems(orderService.view());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustId.setCellValueFactory(new PropertyValueFactory<>("custId"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
    }
}
