package BELSKI_home_7_interface.Person.classes.Abibas;

import BELSKI_home_7_interface.Person.interfaces.Pants;

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
