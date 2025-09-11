import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    Stage customerDetails = new Stage();
    Stage item = new Stage();
    Stage order = new Stage();
    Stage orderDetails = new Stage();

    public void customerManagementOnAction(ActionEvent actionEvent) {
        try {
            customerDetails.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerDetails.fxml"))));
            customerDetails.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void orderManagementOnAction(ActionEvent actionEvent) {
        try {
            order.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Order.fxml"))));
            order.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void itemMnagementOnAction(ActionEvent actionEvent) {
        try {
            item.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Item.fxml"))));
            item.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void orderDetailsManagementOnAction(ActionEvent actionEvent) {
        try {
            orderDetails.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/OrderDetails.fxml"))));
            orderDetails.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
