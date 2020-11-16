package Denis_Belski.inheritance;

public class Ground extends Transport{
    protected int countOfWheels = 0;
    protected double countOfFuel = 0.0;

    public Ground(int power, int maxSpeed, int mass, String brand, int countOfWheels, int countOfFuel) {
        super(power,maxSpeed,mass,brand);
        this.countOfFuel = countOfFuel;
        this.countOfWheels = countOfWheels;
    }

    @Override
    public void showAll() {
        super.showAll();
        System.out.println("Count of wheels: "+this.countOfWheels);
        System.out.println("Fuel consumption L/100km: "+this.countOfFuel);
    }

}
