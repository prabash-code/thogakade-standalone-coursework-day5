package controller.customerDetailsController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDetailsController implements CustomerDetailsService{


    public ObservableList<CustomerDetails> view(){
        ObservableList<CustomerDetails> customerList= FXCollections.observableArrayList();
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from customer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                customerList.add(new CustomerDetails(
                        resultSet.getString("CustID"),
                        resultSet.getString("CustTitle"),
                        resultSet.getString("CustName"),
                        resultSet.getString("DOB"),
                        resultSet.getString("CustAddress"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getInt("PostalCode")
                ));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  customerList;
    }
}
