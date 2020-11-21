package Person.classes.Abibas;

import Person.interfaces.Jacket;


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
