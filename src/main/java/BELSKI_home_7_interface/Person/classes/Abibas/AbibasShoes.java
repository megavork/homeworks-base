package BELSKI_home_7_interface.Person.classes.Abibas;

import BELSKI_home_7_interface.Person.interfaces.Shoes;

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
