package managers;

import exceptions.OrderAlreadyAddedException;
import menu.MenuItem;
import order.Order;

public class TableOrdersManager implements OrdersManager {
    Order[] orders;

    public TableOrdersManager(int numberOfTables) {
        orders = new Order[numberOfTables];
    }

    public TableOrdersManager() {
        this(10);
    }


    public void add(Order order, int tableNumber) {
        isCorrectTable(tableNumber);
        try {
            if (orders[tableNumber] != null) {
                throw new OrderAlreadyAddedException();
            }
        } catch (OrderAlreadyAddedException ex) {
            System.err.println("Столик занят");
            ex.printStackTrace();
        }
        orders[tableNumber] = order;
    }

    private boolean isCorrectTable(int tableNumber) {
        try {
            if (tableNumber <= 0 || tableNumber > orders.length) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex) {
            System.err.println("Некорректный номер столика");
            ex.printStackTrace();
        }
        return true;
    }

    public void addItem(MenuItem item, int tableNumber) {
        isCorrectTable(tableNumber);
        if (orders[tableNumber] == null) {
            System.out.println("Столик пуст");
            return;
        } else {
            orders[tableNumber].add(item);
        }
    }

    public int findFreeTable() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int[] findFreeTables() {
        int[] numbers = new int[0];
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                int[] temp = new int[numbers.length + 1];
                System.arraycopy(numbers, 0, temp, 0, numbers.length);
                temp[temp.length - 1] = i;
                numbers = temp;
            }
        }
        return numbers;
    }

    public Order getOrder(int tableNumber) {
        isCorrectTable(tableNumber);
        return orders[tableNumber];
    }

    public void remove(int tableNumber) {
        isCorrectTable(tableNumber);
        orders[tableNumber] = null;
    }

    public boolean remove(Order order) {
        for (Order temp : orders) {
            if (temp.equals(order)) {
                temp = null;
                return true;
            }
        }
        return false;
    }

    public int removeAll(Order order) {
        int count = 0;
        while (remove(order)) {
            count++;
        }
        return count;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        for (Order order : orders) {
            cost += order.costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuanity() {
        return getOrders().length;
    }

    @Override
    public int itemsQuanity(String itemName) {
        int count = 0;
        for (Order order : orders) {
            if (order != null) {
                count += order.itemsQuanity(itemName);
            }
        }
        return count;
    }


    @Override
    public int itemsQuanity(MenuItem item) {
        int count = 0;
        for (Order order : orders) {
            if (order != null) {
                count += order.itemsQuanity(item);
            }
        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        int count = 0;
        for (Order order : orders) {
            if (order != null) {
                count++;
            }
        }
        Order[] result = new Order[count];
        count = 0;
        for (Order order : orders) {
            if (order != null) {
                result[count] = order;
                count++;
            }
        }
        return result;
    }
}
