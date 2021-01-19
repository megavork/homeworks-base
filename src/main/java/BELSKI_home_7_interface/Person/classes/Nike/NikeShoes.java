package BELSKI_home_7_interface.Person.classes.Nike;

import BELSKI_home_7_interface.Person.interfaces.Shoes;

public class NikeShoes implements Shoes {

    public NikeShoes() {

    }

    @Override
    public void putOn() {
        System.out.println("You put on Nike shoes.");
    }

    @Override
    public void putOff() {
        System.out.println("You put off Nike shoes.");
    }
}
