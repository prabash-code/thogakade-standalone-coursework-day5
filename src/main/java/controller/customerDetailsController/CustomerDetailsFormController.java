package controller.customerDetailsController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerDetails;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerDetailsFormController implements Initializable {

    public TableColumn colcustPostalCode;
    @FXML
    private TableColumn<?, ?> ColcustPostalCode;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnView;

    @FXML
    private JFXComboBox<String> cmbProvince;

    @FXML
    private JFXComboBox<String> cmbTitle;

    @FXML
    private TableColumn<?, ?> colCustAddress;

    @FXML
    private TableColumn<?, ?> colCustCity;

    @FXML
    private TableColumn<?, ?> colCustDOB;

    @FXML
    private TableColumn<?, ?> colCustId;

    @FXML
    private TableColumn<?, ?> colCustName;

    @FXML
    private TableColumn<?, ?> colCustProvince;

    @FXML
    private TableColumn<?, ?> colCustSalary;

    @FXML
    private TableColumn<?, ?> colCustTitle;

    @FXML
    private DatePicker dob;

    @FXML
    private TableView<CustomerDetails> tableCustomer;

    @FXML
    private TextArea txtAddress;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPostalCode;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    void AddOnAction(ActionEvent event) {

    }

    @FXML
    void clearOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    @FXML
    void viewOnAction(ActionEvent event) {

     CustomerDetailsService customerDetailsService=new CustomerDetailsController();
     tableCustomer.setItems(customerDetailsService.view());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //-----------------set table details-----------------
        colCustId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustDOB.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCustSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colCustCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colCustProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colCustAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colcustPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));

//---------initialize title--------------
        ObservableList<String> titleList = FXCollections.observableArrayList(
                "Mr",
                "Ms",
                "Miss"
        );
        cmbTitle.setItems(titleList);

        // -----------------initilized province-----------------
        ObservableList<String> province = FXCollections.observableArrayList(
                "Western",
                "Central",
                "Southern",
                "Northern",
                "Eastern",
                "North Western",
                "North Central",
                "Uva",
                "Sabaragamuwa"
        );
        cmbProvince.setItems(province);
    }

}



