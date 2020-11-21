package Person.classes.Puma;

import Person.interfaces.Shoes;

public class PumaShoes implements Shoes {

    public PumaShoes(){

    }

    @Override
    public void putOn() {
        System.out.println("You put on Puma shoes.");
    }

    @Override
    public void putOff() {
        System.out.println("You put off Puma shoes.");
    }
}
