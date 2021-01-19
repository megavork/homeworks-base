package BELSKI_home_7_interface.Person.classes.Abibas;

import BELSKI_home_7_interface.Person.interfaces.Jacket;


public class AbibasJacket implements Jacket {

    public AbibasJacket() {

    }

    @Override
    public void putOn() {
        System.out.println("You put on Abibas jacket.");
    }

    @Override
    public void putOff() {
        System.out.println("You put off Abibas jacket.");
    }
}
