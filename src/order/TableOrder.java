package order;

import menu.MenuItem;

public class TableOrder implements Order {
    private int size;
    private MenuItem[] items;

    private void increase() {
        MenuItem[] temp = items;
        temp = new MenuItem[items.length + 1];
        for (int i = 0; i < temp.length; i++) {
            items[i] = temp[i];
        }
        size++;
    }

    private void decrease() {
        MenuItem[] temp = items;
        temp = new MenuItem[items.length - 1];
        for (int i = 0; i < temp.length; i++) {
            items[i] = temp[i];
        }
        size--;
    }

    @Override
    public boolean add(MenuItem item) {
        increase();
        items[items.length - 1] = item;
        return true;
    }

    public String[] itemsNames() {
        String[] result = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = items[i].getName();
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
        for (MenuItem item : items) {
            if (item.getName().equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int itemsQuanity(MenuItem itemName) {
        int count = 0;
        for (MenuItem item : items) {
            if (item.equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(itemName)) {
                for (int j = i; j < items.length - 1; i++) {
                    items[j] = items[j + 1];
                }
                decrease();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                for (int j = i; j < items.length - 1; i++) {
                    items[j] = items[j + 1];
                }
                decrease();
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(itemName)) {
                for (int j = i; j < items.length - 1; i++) {
                    items[j] = items[j + 1];
                }
                decrease();
                count++;
            }
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                for (int j = i; j < items.length - 1; i++) {
                    items[j] = items[j + 1];
                }
                decrease();
                count++;
            }
        }
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] result = items;
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
        for (MenuItem item : items) {
            cost += item.getPrice();
        }
        return cost;
    }
}
