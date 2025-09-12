package controller.orderDetailsController;

import com.mysql.cj.x.protobuf.MysqlxCrud;
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

    public void add(OrderDetails orderDetails){
        try {
            Connection connection= DBConnection.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into orderdetail(OrderID,ItemCode,OrderQTY,Discount) values(?,?,?,?);");
            preparedStatement.setObject(1,orderDetails.getOrderId());
            preparedStatement.setObject(2,orderDetails.getItemCode());
            preparedStatement.setObject(3,orderDetails.getQty());
            preparedStatement.setObject(4,orderDetails.getDiscount());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(OrderDetails orderDetails){
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update orderdetail set OrderQTY=?,Discount=? where OrderID=? AND ItemCode=? ");
            preparedStatement.setObject(1,orderDetails.getQty());
            preparedStatement.setObject(2,orderDetails.getDiscount());
            preparedStatement.setObject(3,orderDetails.getOrderId());
            preparedStatement.setObject(4,orderDetails.getItemCode());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(String id){}

}
