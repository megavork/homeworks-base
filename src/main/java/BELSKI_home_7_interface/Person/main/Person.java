package BELSKI_home_7_interface.Person.main;

import BELSKI_home_7_interface.Person.interfaces.Jacket;
import BELSKI_home_7_interface.Person.interfaces.Pants;
import BELSKI_home_7_interface.Person.interfaces.Shoes;

public class Person {
    private String name;
    private Jacket jacket;
    private Pants pants;
    private Shoes shoes;

    public Person(String name) {
        this.name = name;
    }

    public void getJacket(Jacket jacket) {
        this.jacket = jacket;
    }

    public void getPants(Pants pants) {
        this.pants = pants;
    }

    public void getShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public void fullPutOn() {
        this.jacket.putOn();
        this.pants.putOn();
        this.shoes.putOn();
    }

    public void fullPutOff() {
        this.jacket.putOff();
        this.pants.putOff();
        this.shoes.putOff();
    }
}
