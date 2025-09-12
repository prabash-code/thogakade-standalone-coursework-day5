package controller.orderDetailsController;

import javafx.collections.ObservableList;
import model.OrderDetails;

public interface OrderDetailsService {
    public ObservableList<OrderDetails> view();
    public void add(OrderDetails orderDetails);
    public void update(OrderDetails orderDetails);
    public void delete(String id);
}
