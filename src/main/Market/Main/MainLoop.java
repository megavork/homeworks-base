package Main;

import Market.Market;
import Market.Menu;
import MySOUT.Debug;

public class MainLoop {
    public static void main(String[] args) {
        Menu.showAllMenu();
        Debug.flag=true;

        Market market = new Market();
        while (market.checkAction()) {
            Menu.showOptions();
        }
    }
}
