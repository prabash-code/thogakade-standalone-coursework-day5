package controller.orderController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderController implements OrderService {
    Connection connection;

    {
        try {
            connection = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Orders> view() {
        ObservableList<Orders> orderList = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderList.add(new Orders(
                        resultSet.getString("OrderID"),
                        resultSet.getString("OrderDate"),
                        resultSet.getString("CustID")
                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

    @Override
    public void add(Orders orders) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into orders(OrderID,OrderDate,CustID) values(?,?,?)");
            preparedStatement.setObject(1, orders.getOrderId());
            preparedStatement.setObject(2, orders.getDate());
            preparedStatement.setObject(3, orders.getCustId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Orders orders) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update orders set CustID=?,OrderDate=? where OrderID=? ;");
            preparedStatement.setObject(1,orders.getCustId());
            preparedStatement.setObject(2,orders.getDate());
            preparedStatement.setObject(3,orders.getOrderId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from orders where OrderID=?");
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
