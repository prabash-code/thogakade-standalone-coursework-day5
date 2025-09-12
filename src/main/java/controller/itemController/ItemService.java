package controller.itemController;

import javafx.collections.ObservableList;
import model.Item;

public interface ItemService {
    public ObservableList<Item> view();
    public void add(Item item);
    public void update(Item item);
    public void delete(String id);

}
