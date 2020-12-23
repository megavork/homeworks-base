package Main;

import Market.Market;
import Market.Menu;

public class MainLoop {
    public static void main(String[] args) {
        Menu.showAllMenu();

        Market market = new Market();
        while (market.checkAction()) {
            Menu.showOptions();
        }
    }
}
