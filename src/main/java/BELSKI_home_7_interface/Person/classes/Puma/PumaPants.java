package BELSKI_home_7_interface.Person.classes.Puma;

import BELSKI_home_7_interface.Person.interfaces.Pants;

public class PumaPants implements Pants {

    public PumaPants() {

    }

    @Override
    public void putOn() {
        System.out.println("You put on Puma pants.");
    }

    @Override
    public void putOff() {
        System.out.println("You put off Puma pants.");
    }
}
