package Space.classes;

import Space.interfaces.IStart;

import java.util.Random;

public class RussianSpace implements IStart {

    public RussianSpace(){

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
        for(int i = 10; i > 0; i--) {
            System.out.println( i + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    public void start() {
        System.out.println("Holly SHIT! it's works!");
    }
}
