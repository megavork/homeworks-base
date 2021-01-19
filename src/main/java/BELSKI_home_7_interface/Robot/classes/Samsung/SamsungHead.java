package BELSKI_home_7_interface.Robot.classes.Samsung;

import BELSKI_home_7_interface.Robot.interfaces.IHead;

public class SamsungHead implements IHead {
    private int price;

    public SamsungHead(int price) {
        this.price = price;
    }

    @Override
    public void speak() {
        System.out.println("Samsung head speaks.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
