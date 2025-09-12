package controller.orderDetailsController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OrderDetails;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsController implements OrderDetailsService{


    public ObservableList<OrderDetails> view(){
        ObservableList<OrderDetails> orderDetailList= FXCollections.observableArrayList();

        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orderdetail");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                orderDetailList.add(new OrderDetails(
                        resultSet.getString("OrderId"),
                        resultSet.getString("ItemCode"),
                        resultSet.getInt("OrderQTY"),
                        resultSet.getInt("Discount")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailList;
    }
}
