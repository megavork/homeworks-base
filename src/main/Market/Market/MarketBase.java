package Market;

import Source.Item;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MarketBase {
    private HashMap<Integer,Item> base = new HashMap();

    public MarketBase() {
    }

    /**
     * return object or null if no objects
     * @param hashCode
     * @return
     */
    public Item getItem(int hashCode) {
        return base.get(hashCode);
    }

    /**
     * put new Item to market base ant return true
     */
    public boolean setItemToBase() {
        //делаем опрос на поля
        Item item = new Item(CustomerInput.getStringInputAnswer("name"),CustomerInput.getDoubleInputAnswer("price"));

        if(!base.containsValue(item.getID())) {    //if base do not contains this hashCode
            base.put(item.getID(),item);         //put object
            return true;
        } else {
            return false;
        }
    }

    /**
     * remove item from base by his ID and return true
     * @return
     */
    public boolean removeItemFromBase() {
        int itemID = CustomerInput.getIntegerInputAnswer("ID or enter 0 to exit");

        if (base.containsKey(itemID)) {
            base.remove(itemID);
            return true;
        } else {
            return false;
        }
    }

    public void showAllItems() {
        System.out.println(base.values().toString());
    }

    public void sortByPrice() {
        //TODO:
    }

    public void sortByAdditionDate() {
    }

    /**
     * will edit one of Item
     * @return
     */
    public boolean editItem() {
        int ID = CustomerInput.getIntegerInputAnswer("ID or enter 0 to exit");

        while(!base.containsKey(ID) && ID != 0) {
            System.out.println("The ID does not exist. Try again or enter 0 to exit.");
            ID = CustomerInput.getIntegerInputAnswer("ID");
        }
        if (ID==0)
            return false;

        System.out.println("You chose " + ID + " Item.");
                // if customer put empty answers no need to change value
                // example: we need to change name without price changes
        String name = CustomerInput.getStringInputAnswer("name", true);
        double price = CustomerInput.getDoubleInputAnswer("price", true);

        if (!name.isEmpty())
            base.get(ID).setName(name);

        if (price >= 0)
            base.get(ID).setPrice(price);

        return true;
    }

    public void generateItems() {
        for (int i=0; i<10; i++) {
            base.put(i+32894674,new Item("Name" + i, 618+i*13));
        }
    }
}
