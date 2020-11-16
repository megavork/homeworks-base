package Denis_Belski.inheritance;

public class Transport {
    int power = 0;
    int maxSpeed = 0;
    int mass = 0;
    String brand = "";

    Transport(int power, int maxSpeed, int mass, String brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.mass = mass;
        this.brand = brand;
    }

    public void showAll() {
        System.out.println("Brand: "+this.brand);
        System.out.println("Max speed km/h: "+this.maxSpeed);
        System.out.println("Power h/p: "+this.power);
        System.out.println("Power kW: "+this.power*0.74);
        System.out.println("Mass kg: "+this.mass);
    }

}
