package Robot.classes.Sony;

import Robot.interfaces.IHand;

public class SonyHand implements IHand {
    private int price;

    public SonyHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Up Sony Hand!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}

