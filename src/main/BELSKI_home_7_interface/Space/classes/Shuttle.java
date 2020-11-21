package Space.classes;

import Person.interfaces.Shoes;
import Space.interfaces.IStart;

import java.util.Random;

public class Shuttle implements IStart {

    public Shuttle(){

    }

    @Override
    public boolean firstCheck() {
        Random rnd = new Random();
        if(rnd.nextBoolean()){
            System.out.println("All systems works correct.");
            return true;
        } else {
            System.out.println("The Start was interrupting.");
            return false;
        }
    }

    @Override
    public void motorStart() {
        for(int i = 0; i < 10; i++) {
            System.out.println( i+1 + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

        }
    }

    @Override
    public void start() {
        System.out.println("Start.");
    }
}
