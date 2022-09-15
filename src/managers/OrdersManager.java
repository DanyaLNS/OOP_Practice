package managers;

import menu.MenuItem;
import order.Order;

public interface OrdersManager {
    int itemsQuanity(String itemName);

    int itemsQuanity(MenuItem item);

    Order[] getOrders();

    int ordersCostSummary();

    int ordersQuanity();
}
