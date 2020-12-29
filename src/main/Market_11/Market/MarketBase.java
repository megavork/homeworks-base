package Market;

import MySOUT.Debug;
import Source.Item;
import interfs.interf.SortByID;

import java.util.*;
import java.util.function.Function;

public class MarketBase {
    private HashMap<Integer,Item> mainItemBase = new HashMap<>();
    private ArrayList<Integer> itemListOrderedByAddition = new ArrayList<>();

    public MarketBase() {
    }
    // **********************************************************************************************
    // ***********************                  SORTERS begin
    // **********************************************************************************************
    /**
     * sort by price. using lambda function
     */
    public void sortByPriceAscendingOrder() {
        List<Item> itemList = new ArrayList<Item>(mainItemBase.values());
        Collections.sort(itemList,(itm1, itm2) -> itm1.sortByPrice(itm2));

        for (Item item : itemList) {
            System.out.print(item.toString());
        }
    }
    public void sortByPriceDescendingOrder() {
        List<Item> itemList = new ArrayList<Item>(mainItemBase.values());
        Collections.sort(itemList,(itm1, itm2) -> itm2.sortByPrice(itm1));

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
     * Sort Items ID by descending order
     */
    public void sortByIdDescendingOrder() {
        List<Item> itemList = new ArrayList<Item>(mainItemBase.values());
        // without using standard collection sorts
        itemList = this.SortById(itemList,(itm1, itm2) -> itm2.sortById(itm1));

        for (Item item : itemList) {
            System.out.print(item.toString());
        }
    }

    /**
     * sort Items Id by ascending order
     */
    public void sortByIdAscendingOrder() {
        List<Item> itemList = new ArrayList<Item>(mainItemBase.values());
        Collections.sort(itemList,(itm1, itm2) -> itm1.sortById(itm2));

        for (Item item : itemList) {
            System.out.print(item.toString());
        }
    }
    // **********************************************************************************************
    // ***********************                  SORTERS end
    // **********************************************************************************************
    /**
     * put new Item to market base ant return true
     */
    public boolean setItemToBase() {
        System.out.println("Item ID will generate automatically.");
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
     * just show all Items ib mainBase
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

    public List SortById(List<Item> list, SortByID srt) {
        for (int i=0; i < list.size(); i++) {
            for (int j=list.size()-1; j > i;  j--) {
                if(srt.sortByID(list.get(i),list.get(j)) > 0) {
                    Item temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        return list;
    }
    public void sortPriceChecker() {

        int answer = -1;

        while(answer < 0 || answer > 3) {
            answer = CustomerInput.getIntegerInputAnswer("sort number: \n" +
                    "1 sort Items Price by ascending order.\n" +
                    "2 sort Items Price by descending order.\n" +
                    "3 Sort Items by order of addition.\n" +
                    "0 exit.\n" +
                    "Enter number of sort: ");
        }

        switch (answer) {
            case 0: return;
            case 1: this.sortByPriceAscendingOrder(); break;
            case 2: this.sortByPriceDescendingOrder(); break;
            case 3: this.sortByAdditionDate(); break;
        }
    }
}
