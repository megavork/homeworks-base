package Robot.classes.Sony;

import Robot.interfaces.ILeg;

public class SonyLeg implements ILeg {

    private int price;

    public SonyLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Step by Sony step.");
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
