package BELSKI_home_7_interface.Space.main;

import BELSKI_home_7_interface.Space.classes.RussianSpace;
import BELSKI_home_7_interface.Space.classes.Shuttle;

public class main {
    public static void main(String[] args) {

        Spaceport port = new Spaceport();
        System.out.println("Try to start USA shuttle.");
        port.start(new Shuttle());
        System.out.println();

        Spaceport port_2 = new Spaceport();
        System.out.println("Try to start Russian shuttle.");
        port_2.start(new RussianSpace());
        System.out.println();
    }
}
