package controller.orderController;

import javafx.collections.ObservableList;
import model.Orders;

public interface OrderService {
    public ObservableList<Orders> view();
    public void add(Orders orders);
    public void update(Orders orders);
    public void delete(String id);
}
