package Robot.classes.Samsung;

import Robot.interfaces.IHand;

public class SamsungHand implements IHand {
    private int price;

    public SamsungHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Up Samsung Hand!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
