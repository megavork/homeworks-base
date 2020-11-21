package Person.classes.Abibas;

import Person.interfaces.Pants;

public class AbibasPants implements Pants {

    public AbibasPants() {

    }

    @Override
    public void putOn() {
        System.out.println("You put on Abibas pants.");
    }

    @Override
    public void putOff() {
        System.out.println("You put off Abibas pants.");
    }
}
