package Belski_Home_9_exeptions.Classes;

import java.util.Random;

import Belski_Home_9_exeptions.Exeptions.wasNotStartedExeption;

public class Car {
    String brand = "";
    double speed = 0;
    double cost = 0;

    public Car(String brand, double speed, double cost) {
        this.brand = brand;
        this.speed = speed;
        this.cost = cost;
    }

    public Car() {
        this.brand = "UAZ";
        this.speed = 98.8;
        this.cost = 100.0;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void tryToStart() throws wasNotStartedExeption {
        Random rand = new Random();
        int number = rand.nextInt(21);

        if (number % 2 == 0)
            System.out.println("The car was started.");
        else
            throw new wasNotStartedExeption();
    }

}
