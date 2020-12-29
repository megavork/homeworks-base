package Market;

public class Market {
    MarketBase base;

    public Market() {
        base = new MarketBase();
        base.generateItems();
    }

    public boolean checkAction() {
        int number = CustomerInput.getIntegerInputAnswer("options number");

        switch (number) {
            case 1: base.sortPriceChecker(); return true;
            case 2: base.sortByPriceAscendingOrder(); return true;
            case 3: base.sortByAdditionDate(); return true;
            case 4: base.setItemToBase(); return true;
            case 5: base.removeItemFromBase(); return true;
            case 6: base.editItem(); return true;
            case 7: base.sortByIdDescendingOrder(); return true;
            case 8: base.sortByIdAscendingOrder(); return true;
            case 0: return false;
            default:
                System.out.println("Wrong answer. Try again.");
                return true;
        }

    }
}
