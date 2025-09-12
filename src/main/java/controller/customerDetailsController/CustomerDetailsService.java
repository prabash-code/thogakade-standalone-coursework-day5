package controller.customerDetailsController;

import javafx.collections.ObservableList;
import model.CustomerDetails;

public interface CustomerDetailsService {
    public ObservableList<CustomerDetails> view();
    public void add(CustomerDetails customerDetails);
    public void delete(String id);
    public void update(CustomerDetails customerDetails);
}
