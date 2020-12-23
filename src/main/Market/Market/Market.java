package Market;

public class Market {
    MarketBase base;
    public Market() {
        base = new MarketBase();
    }

    public boolean checkAction() {
        int number = CustomerInput.getIntegerInputAnswer("options number");
        base.generateItems();
        switch (number) {
            case 1: base.showAllItems(); return true;
            case 2: base.sortByPrice(); return true;
            case 3: base.sortByAdditionDate(); return true;
            case 4: base.setItemToBase(); return true;
            case 5: base.removeItemFromBase(); return true;
            case 6: base.editItem(); return true;
            case 0: return false;
            default:
                System.out.println("Wrong answer. Try again.");
                return true;
        }

    }
}