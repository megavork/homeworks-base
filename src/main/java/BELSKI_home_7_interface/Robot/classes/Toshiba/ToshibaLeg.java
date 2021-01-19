package BELSKI_home_7_interface.Robot.classes.Toshiba;

import BELSKI_home_7_interface.Robot.interfaces.ILeg;

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
