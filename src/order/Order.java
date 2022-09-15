package order;

import customer.Customer;
import menu.MenuItem;

import java.util.Currency;

public interface Order {
    boolean add(MenuItem item);

    int itemsQuanity();

    int itemsQuanity(String itemName);

    int itemsQuanity(MenuItem item);

    MenuItem[] getItems();

    boolean remove(String itemName);

    boolean remove(MenuItem item);

    int removeAll(String itemName);

    int removeAll(MenuItem item);

    MenuItem[] sortedItemsByCostDesc();

    int costTotal();


}
