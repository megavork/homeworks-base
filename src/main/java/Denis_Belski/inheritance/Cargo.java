package Denis_Belski.inheritance;
//грузовой
public class Cargo extends Ground{
    protected int countOfFreight = 0;

    Cargo(int power, int maxSpeed, int mass, String brand,
          int countOfWheels, int countOfFuel, int countOfFreight) {
        super(power,maxSpeed,mass,brand,countOfWheels,countOfFuel);
        this.countOfFreight = countOfFreight;
    }
    public void showAll() {
        System.out.println("Brand: "+this.brand);
        System.out.println("Max speed km/h: "+this.maxSpeed);
        System.out.println("Power h/p: "+this.power);
        System.out.println("Power kW: "+this.power*0.74);
        System.out.println("Mass kg: "+this.mass);
        System.out.println("Count of wheels: "+this.countOfWheels);
        System.out.println("Fuel consumption L/100km: "+this.countOfFuel);
        System.out.println("Count of freight kg: "+this.countOfFreight);
    }

    public void checkFreeSpace(double workload) {
        if(workload < this.countOfFreight) {
            System.out.println("The truck is loaded.");
        } else {
            System.out.println("You should use bigger truck.");
        }
    }
}
