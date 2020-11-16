package Denis_Belski.inheritance;

public class Automobile extends  Ground{
    private String typeOfBody = "";
    private int countOfPeople = 0;

    Automobile(int power, int maxSpeed, int mass, String brand,
               int countOfWheels, int countOfFuel, String typeOfBody, int countOfPeople) {
        super(power,maxSpeed,mass,brand,countOfWheels,countOfFuel);
        this.countOfWheels = countOfWheels;
        this.countOfFuel = countOfFuel;
        this.typeOfBody = typeOfBody;
        this.countOfPeople = countOfPeople;
    }

    @Override
    public void showAll() {
        super.showAll();
        System.out.println("Type of body: "+this.typeOfBody);
        System.out.println("Count of people: "+this.countOfPeople);
    }

    public void distanceOfTime(double time) {
        double distance = time * this.maxSpeed;
        double checkFuel = fuelOfDistance(distance);
        System.out.println("During the time "+ time +" hours, the " + this.brand + " car" +
                " will using max speed " + this.maxSpeed +" km/h will drives " + distance + "" +
                " km and will waste " + checkFuel + " L of fuel.");
    }

    private double fuelOfDistance(double distance) {
        return this.countOfFuel * distance / 100.0;
    }

}
