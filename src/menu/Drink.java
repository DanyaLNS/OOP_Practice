package menu;

import menu.types.DrinkType;

public final class Drink extends MenuItem implements Alcoholable {

    private double alcoholVol;
    private DrinkType type;

    public Drink(int price, String name, String description,
                 double alcoholVol, DrinkType type) {
        super(price, name, description);
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    public DrinkType getType() {
        return type;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return alcoholVol > 0;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }
}
