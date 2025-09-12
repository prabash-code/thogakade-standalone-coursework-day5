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

@Override
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
                        resultSet.getDouble("salary"),
                        resultSet.getString("CustAddress"),
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

    @Override
    public void add(CustomerDetails customerDetails){
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into customer(CustID,CustTitle,CustName,DOB,salary,CustAddress,City,Province,PostalCode) values (?,?,?,?,?,?,?,?,?);");

            preparedStatement.setObject(1,customerDetails.getId());
            preparedStatement.setObject(2,customerDetails.getTitle());
            preparedStatement.setObject(3,customerDetails.getName());
            preparedStatement.setObject(4,customerDetails.getDate());
            preparedStatement.setObject(5,customerDetails.getSalary());

            preparedStatement.setObject(6,customerDetails.getAddress());
            preparedStatement.setObject(7,customerDetails.getCity());
            preparedStatement.setObject(8,customerDetails.getProvince());
            preparedStatement.setObject(9,customerDetails.getPostalcode());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


public void delete(String id){
    try {
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from customer where CustID=?;");
        preparedStatement.setObject(1,id);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
public void update(CustomerDetails customerDetails){
    try {
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update customer set CustTitle=?,CustName=?,DOB=?,salary=?,CustAddress=?,City=?,Province=?,PostalCode=? where CustID=?;");
        preparedStatement.setObject(1,customerDetails.getTitle());
        preparedStatement.setObject(2,customerDetails.getName());
        preparedStatement.setObject(3,customerDetails.getDate());
        preparedStatement.setObject(4,customerDetails.getSalary());
        preparedStatement.setObject(5,customerDetails.getAddress());
        preparedStatement.setObject(6,customerDetails.getCity());
        preparedStatement.setObject(7,customerDetails.getProvince());
        preparedStatement.setObject(8,customerDetails.getPostalcode());
        preparedStatement.setObject(9,customerDetails.getId());

        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

}
