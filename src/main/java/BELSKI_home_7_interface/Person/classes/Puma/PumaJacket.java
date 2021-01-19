package BELSKI_home_7_interface.Person.classes.Puma;

import BELSKI_home_7_interface.Person.interfaces.Jacket;


public class PumaJacket implements Jacket {

    public PumaJacket() {

    }

    @Override
    public void putOn() {
        System.out.println("You put on Puma jacket.");
    }

    @Override
    public void putOff() {
        System.out.println("You put off Puma jacket.");
    }
}
