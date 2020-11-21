package Robot.classes.Toshiba;

import Robot.interfaces.ILeg;

public class ToshibaLeg implements ILeg {

    private int price;

    public ToshibaLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Step by Toshiba step.");
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
