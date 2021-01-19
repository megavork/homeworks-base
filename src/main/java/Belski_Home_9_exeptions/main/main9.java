package Belski_Home_9_exeptions.main;

import Belski_Home_9_exeptions.Classes.Car;
import Belski_Home_9_exeptions.Exeptions.wasNotStartedExeption;

public class main9 {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        try {
            car1.tryToStart();
        } catch (wasNotStartedExeption e) {
            System.out.println("The car1 was not started.");
        }

        try {
            car2.tryToStart();
        } catch (wasNotStartedExeption e) {
            System.out.println("The car2 was not started.");
        }

    }
}
