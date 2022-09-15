package menu;

import menu.types.DrinkType;

public class MenuItem implements Item {

    private int price;
    private String name;
    private String description;

    public MenuItem(int price, String name, String description) {
        try {
            if (price <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Некорректная цена");
            ex.printStackTrace();
        }
        this.price = price;
        this.name = name;
        this.description = description;
    }
    // TODO добавить второй конструктор, если он будет необходим

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
