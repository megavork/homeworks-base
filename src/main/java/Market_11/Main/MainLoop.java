package Market_11.Main;

import Market_11.Market.Market;
import Market_11.Market.Menu;
import Market_11.MySOUT.Debug;

public class MainLoop {
    public static void main(String[] args) {
        Menu.showAllMenu();
        Debug.flag = true;

        Market market = new Market();
        while (market.checkAction()) {
            Menu.showOptions();
        }
    }
}
