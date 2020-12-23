package Market;

import MySOUT.Debug;
import Source.Item;

import java.util.*;

public class MarketBase {
    private HashMap<Integer,Item> mainItemBase = new HashMap<>();
    private ArrayList<Integer> itemListOrderedByAddition = new ArrayList<>();

    public MarketBase() {
    }

    /**
     * put new Item to market base ant return true
     */
    public boolean setItemToBase() {
        Item item = new Item(CustomerInput.getStringInputAnswer("name"),CustomerInput.getDoubleInputAnswer("price"));

        if(!mainItemBase.containsValue(item.getID())) {    //if base do not contains this hashCode
            mainItemBase.put(item.getID(),item);           //put object
            itemListOrderedByAddition.add(item.getID());
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

        if (mainItemBase.containsKey(itemID)) {
            Item item = mainItemBase.get(itemID);
            mainItemBase.remove(itemID);
            itemListOrderedByAddition.remove(item);
            return true;
        } else {
            System.out.println("ID did not find.");
            return false;
        }
    }

    /**
     * just to show all Items
     */
    public void showAllItems() {
        System.out.println(mainItemBase
                .values()
                .toString()
                .replace(", ","")
                .replace("[","")
                .replace("]",""));
        Debug.sout(mainItemBase.size());
    }

    /**
     * mainItemBase will sort by price value
     */
    public void sortByPrice() {
        List<Item> itemList = new ArrayList<Item>(mainItemBase.values());
        Collections.sort(itemList,Comparator.comparing(Item::getPrice));

        for (Item item : itemList) {
            System.out.print(item.toString());
        }

    }

    /**
     * itemListOrderedByAddition will sort by additional
     */
    public void sortByAdditionDate() {
        for (int i = 0; i < itemListOrderedByAddition.size(); i++) {
            System.out.printf("%3d ",i+1);
            mainItemBase.get(itemListOrderedByAddition.get(i)).showItemList();
        }
    }

    /**
     * will edit one of Item
     * @return
     */
    public boolean editItem() {
        int ID = CustomerInput.getIntegerInputAnswer("ID or enter 0 to exit");

        while(!mainItemBase.containsKey(ID) && ID != 0) {
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
            mainItemBase.get(ID).setName(name);

        if (price >= 0)
            mainItemBase.get(ID).setPrice(price);

        return true;
    }

    /**
     * just to generate example Items
     */
    public void generateItems() {
        for (int i=0; i<10; i++) {
            Item item = new Item("Name" + i, 618+i*13);
            mainItemBase.put(item.getID(),item);
            itemListOrderedByAddition.add(item.getID());
        }
    }

    public int compare(Map.Entry<Integer, Item> a, Map.Entry<Integer, Item> b) {
        return (int)( b.getValue().getPrice() - a.getValue().getPrice() );
    }
}
