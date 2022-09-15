package order;

import customer.Address;
import customer.Customer;
import menu.MenuItem;

public class InternetOrder implements Order {
    private static class ListNode {
        private ListNode next;
        private MenuItem value;

        ListNode(MenuItem value) {
            this.value = value;
        }
    }

    private ListNode next;
    private MenuItem value;
    private int size;
    private ListNode head, tail;

    public boolean add(MenuItem item) {
        ListNode node = head;
        while (node != null) {
            node = node.next;
        }
        node.value = item;
        return true;
    }

    public String[] itemManes() {
        String[] result = new String[size];
        ListNode node = head;
        for (int i = 0; i < size; i++) {
            result[i] = node.value.getName();
            node = node.next;
        }
        return result;
    }

    @Override
    public int itemsQuanity() {
        return size;
    }

    @Override
    public int itemsQuanity(String itemName) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            if (node.value.getName().equals(itemName)) {
                count++;
            }
            node = node.next;
        }
        return count;
    }

    @Override
    public int itemsQuanity(MenuItem item) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            if (node.value.equals(item)) {
                count++;
            }
            node = node.next;
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] result = new MenuItem[size];
        ListNode node = head;
        for (int i = 0; i < size; i++) {
            result[i] = node.value;
            node = node.next;
        }
        return result;
    }

    @Override
    public boolean remove(String itemName) {
        ListNode node = head;
        while (node != null) {
            if (node.value.getName().equals(itemName)) {
                node.value = null;
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        ListNode node = head;
        while (node != null) {
            if (node.value.equals(item)) {
                node.value = null;
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            if (node.value.getName().equals(itemName)) {
                node.value = null;
                node.next = node.next.next;
                count++;
            }
            node = node.next;
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            if (node.value.equals(item)) {
                node.value = null;
                node.next = node.next.next;
                count++;
            }
            node = node.next;
        }
        return count;
    }

    // insertion sort
    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] result = new MenuItem[size];
        ListNode node = head;
        for (int i = 0; i < size; i++) {
            result[i] = node.value;
            node = node.next;
        }
        for (int left = 0; left < result.length; left++) {
            MenuItem value = result[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value.getPrice() < result[i].getPrice()) {
                    result[i + 1] = result[i];
                } else {
                    break;
                }
            }
            result[i + 1] = value;
        }
        return result;
    }

    @Override
    public int costTotal() {
        int cost = 0;
        ListNode node = head;
        while (node != null) {
            cost += node.value.getPrice();
            node = node.next;
        }
        return cost;
    }
}
