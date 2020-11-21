package Robot.classes.Toshiba;

import Robot.interfaces.IHand;

public class ToshibaHand implements IHand {
    private int price;

    public ToshibaHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Up Toshiba Hand!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
