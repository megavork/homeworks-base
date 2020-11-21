package Person.main;


import Person.classes.Abibas.AbibasJacket;
import Person.classes.Nike.NikePants;
import Person.classes.Puma.PumaShoes;

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
