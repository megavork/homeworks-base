package Space.main;

import Space.interfaces.IStart;

public class Spaceport {
    public Spaceport() {
    }

    public void start(IStart istart){
        if(istart.firstCheck()) {
            istart.motorStart();
            istart.start();
        }
    }
}
