package BELSKI_home_7_interface.Robot.classes.Sony;

import BELSKI_home_7_interface.Robot.interfaces.IHead;

public class SonyHead implements IHead {
    private int price;

    public SonyHead(int price) {
        this.price = price;
    }

    @Override
    public void speak() {
        System.out.println("Sony head speaks");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
