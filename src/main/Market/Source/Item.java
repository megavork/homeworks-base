package Source;

import java.util.Comparator;
import java.util.Objects;

public class Item {
    private final int ID;
    private String name = "";
    private double price = 0;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        ID = this.hashCode();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return ID == item.ID &&
                Double.compare(item.price, price) == 0 &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += 19 * Integer.hashCode(ID);
        result += 19 * name.hashCode();
        result += 19 * Double.hashCode(price);

        if(result < 0)
            result = - result;

        return result;
    }

    @Override
    public String toString() {
        return "ID=" + ID + " name=" + name + " price=" + price + "\n";
    }
}
