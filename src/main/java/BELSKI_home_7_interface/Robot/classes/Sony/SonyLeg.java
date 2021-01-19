package BELSKI_home_7_interface.Robot.classes.Sony;

import BELSKI_home_7_interface.Robot.interfaces.ILeg;

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
