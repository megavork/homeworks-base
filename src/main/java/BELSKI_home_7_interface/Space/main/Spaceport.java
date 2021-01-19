package BELSKI_home_7_interface.Space.main;

import BELSKI_home_7_interface.Space.interfaces.IStart;

public class Spaceport {
    public Spaceport() {
    }

    public void start(IStart istart) {
        if (istart.firstCheck()) {
            istart.motorStart();
            istart.start();
        }
    }
}
