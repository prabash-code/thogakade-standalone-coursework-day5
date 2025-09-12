package controller.itemController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemControllrer implements ItemService{

    @Override
    public ObservableList<Item> view() {
        ObservableList<Item> itemList= FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from item;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                itemList.add(new Item(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("PackSize"),
                        resultSet.getDouble("UnitPrice"),
                        resultSet.getInt("QtyOnHand")
                 ));

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemList;
    }

    @Override
    public void add(Item item) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into item (ItemCode,Description,PackSize,UnitPrice,QtyOnHand) values(?,?,?,?,?);");
            preparedStatement.setObject(1,item.getItemCode());
            preparedStatement.setObject(2,item.getDescription());
            preparedStatement.setObject(3,item.getPackSize());
            preparedStatement.setObject(4,item.getUnitPrice());
            preparedStatement.setObject(5,item.getQty());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Item item) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update item set Description =?,PackSize=?,UnitPrice=?,QtyOnHand=? where ItemCode=?;");
            preparedStatement.setObject(1,item.getDescription());
            preparedStatement.setObject(2,item.getPackSize());
            preparedStatement.setObject(3,item.getUnitPrice());
            preparedStatement.setObject(4,item.getQty());
            preparedStatement.setObject(5,item.getItemCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from item where ItemCode=?;");
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
