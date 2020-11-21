package Person.classes.Nike;

import Person.interfaces.Jacket;


public class NikeJacket implements Jacket {

    public NikeJacket(){

    }

    @Override
    public void putOn() {
        System.out.println("You put on Nike jacket.");
    }

    @Override
    public void putOff() {
        System.out.println("You put off Nike jacket.");
    }
}
