package Source;

public class Item implements Comparable<Item> {
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

    public void showItemList() {
        System.out.printf("   ID: %-10d Name: %-10s Price: %-6.2f%n",ID,name,price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0;
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

    public String toString() {
        return String.format("ID: %-10d Name: %-10s Price: %-6.2f%n",ID,name,price);
    }

    @Override
    public int compareTo(Item o) {
        return (int)(this.price - o.price);
    }

    public int sortByPrice(Item itm1) {
        return (int)(this.getPrice() - itm1.getPrice());
    }

    public int sortById(Item itm1) {
        return this.getID() - itm1.getID();
    }
}
