package managers;

import menu.MenuItem;
import order.InternetOrder;
import order.Order;

public class InternetOrderManager implements OrdersManager {
    public static class QueueNode {
        protected QueueNode next;
        protected QueueNode prev;
        protected Order value;
    }

    private QueueNode head;
    private QueueNode tail;
    private int size;

    public InternetOrderManager() {
        head = tail = new QueueNode();
    }

    public InternetOrderManager(Order[] orders) {
        this();
        QueueNode node = head;
        for (Order order : orders) {
            node.value = order;
            node.next = new QueueNode();
            node.next.prev = node;
            node = node.next;
        }
        tail = node;
    }

    public boolean add(Order order) {
        QueueNode node = head;
        try {
            if (!(order instanceof InternetOrder)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex) {
            System.err.println("Вы пытаетесь добавить некорректный заказ");
            return false;
        }
        while (node != null && node.value != null) {
            node = node.next;
        }
        size++;
        QueueNode newNode = new QueueNode();
        tail.next = newNode;
        newNode.prev = tail;
        newNode.value = order;
        return true;
    }

    public Order remove() {
        if (head != null) {
            Order order = head.value;
            head = head.next;
            size--;
            return order;
        } else {
            return null;
        }
    }

    public Order order() {
        return head.value;
    }

    @Override
    public int itemsQuanity(MenuItem item) {
        int count = 0;
        QueueNode node = head;

        while (node != null) {
            count += node.value.itemsQuanity(item);
            node = node.next;
        }

        return count;
    }

    @Override
    public int itemsQuanity(String itemName) {
        int count = 0;
        QueueNode node = head;

        while (node != null) {
            count += node.value.itemsQuanity(itemName);
            node = node.next;
        }

        return count;
    }

    @Override
    public Order[] getOrders() {
        Order[] orders = new Order[size];
        QueueNode node = head;
        int i = 0;
        while (node != null) {
            orders[i] = node.value;
            node = node.next;
            i++;
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        QueueNode node = head;

        while (node != null) {
            cost += node.value.costTotal();
            node = node.next;
        }

        return cost;
    }

    @Override
    public int ordersQuanity() {
        return size;
    }
}
