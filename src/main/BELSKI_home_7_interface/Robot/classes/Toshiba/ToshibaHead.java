package Robot.classes.Toshiba;

import Robot.interfaces.IHead;

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
