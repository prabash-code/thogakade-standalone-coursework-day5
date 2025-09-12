package controller.itemController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {
    public JFXButton btnView;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnClear;
    public TableView tableItem;
    public TableColumn colItemCode;
    public TableColumn colPackSize;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQTYOnHand;
    public JFXTextField txtItemCode;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtPackSize;
    public JFXTextField txtQTYOnHand;
    public TextArea txtDescription;

    public void viewOnAction(ActionEvent actionEvent) {
        ItemService itemService= new ItemControllrer();
        tableItem.setItems(itemService.view());

    }

    public void addOnAction(ActionEvent actionEvent) {
        ItemControllrer itemService=new ItemControllrer();
        Item item=new Item(
                txtItemCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQTYOnHand.getText())
        );

        itemService.add(item);
        viewOnAction(actionEvent);
        clearOnAction(actionEvent);

    }

    public void updateOnAction(ActionEvent actionEvent) {
        ItemControllrer itemService=new ItemControllrer();
        Item item=new Item(
                txtItemCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQTYOnHand.getText())
        );

        itemService.update(item);
        viewOnAction(actionEvent);
        clearOnAction(actionEvent);

    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String id=txtItemCode.getText();
        ItemService itemService=new ItemControllrer();
        itemService.delete(id);
        viewOnAction(actionEvent);
        clearOnAction(actionEvent);
    }

    public void clearOnAction(ActionEvent actionEvent) {
        txtDescription.setText(null);
        txtItemCode.setText(null);
        txtPackSize.setText(null);
        txtUnitPrice.setText(null);
        txtQTYOnHand.setText(null);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQTYOnHand.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }
}
