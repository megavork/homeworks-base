package Person.classes.Abibas;

import Person.interfaces.Shoes;

public class AbibasShoes implements Shoes {

    public AbibasShoes() {

    }

    @Override
    public void putOn() {
        System.out.println("You put on Abibas shoes.");
    }

    @Override
    public void putOff() {
        System.out.println("You put off Abibas shoes.");
    }
}
