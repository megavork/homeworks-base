package Person.classes.Nike;

import Person.interfaces.Pants;

public class NikePants implements Pants {

    public NikePants() {

    }

    @Override
    public void putOn() {
        System.out.println("You put on Nike pants.");
    }

    @Override
    public void putOff() {
        System.out.println("You put off Nike pants.");
    }
}
