package Market_11.Source;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"ID", "itemName", "price"}, name = "item")
@JsonAutoDetect
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ID")
public class Item implements Comparable<Item> {
    private final Integer ID;
    private String itemName = "";
    private double price = 0;

    public Item(String name, double price) {
        this.itemName = name;
        this.price = price;
        ID = this.hashCode();
    }

    public Item getObject() {
        return this;
    }

    @JsonProperty("ID")
    @XmlElement(name = "ID")
    public int getID() {
        return ID;
    }

    @JsonProperty("itemName")
    public String getItemName() {
        return itemName;
    }

    @JsonProperty("price")
    public double getPrice() {
        return price;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void showItemList() {
        System.out.printf("   ID: %-10d Name: %-10s Price: %-6.2f%n", ID, itemName, price);
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
        result += 19 * itemName.hashCode();
        result += 19 * Double.hashCode(price);

        if (result < 0)
            result = -result;

        return result;
    }

    public String toString() {
        return String.format("ID: %-10d Name: %-10s Price: %-6.2f%n", ID, itemName, price);
    }

    @Override
    public int compareTo(Item o) {
        return (int) (this.price - o.price);
    }

    public int sortByPrice(Item itm1) {
        return (int) (this.getPrice() - itm1.getPrice());
    }

    public int sortById(Item itm1) {
        return this.getID() - itm1.getID();
    }
}
