package controller.orderController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderController implements OrderService{
    ObservableList<Orders> orderList= FXCollections.observableArrayList();
    public ObservableList<Orders> view(){
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                orderList.add(new Orders(resultSet.getString("OrderID"),
                        resultSet.getString("OrderDate"),
                        resultSet.getString("CustID")
                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }
    public void add(Orders orders){}
    public void update(Orders orders){}
    public void delete(String id){}

}
