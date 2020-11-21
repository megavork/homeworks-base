package Robot.classes.Samsung;

import Robot.interfaces.ILeg;

public class SamsungLeg implements ILeg {

    private int price;

    public SamsungLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Step by Samsung step.");
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
