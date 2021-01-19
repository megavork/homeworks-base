package BELSKI_home_7_interface.Person.main;


import BELSKI_home_7_interface.Person.classes.Abibas.AbibasJacket;
import BELSKI_home_7_interface.Person.classes.Nike.NikePants;
import BELSKI_home_7_interface.Person.classes.Puma.PumaShoes;

public class main {
    public static void main(String[] args) {
        Person person = new Person("R2D2");
        person.getJacket(new AbibasJacket());
        person.getPants(new NikePants());
        person.getShoes(new PumaShoes());

        person.fullPutOn();
        person.fullPutOff();

    }
}
