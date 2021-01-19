package BELSKI_home_7_interface.Robot.classes.Toshiba;

import BELSKI_home_7_interface.Robot.interfaces.IHead;

public class ToshibaHead implements IHead {
    private int price;

    public ToshibaHead(int price) {
        this.price = price;
    }

    @Override
    public void speak() {
        System.out.println("Toshiba head speaks.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
