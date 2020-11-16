package Denis_Belski.inheritance;

public class Air extends  Transport{
    protected int lenOfWings = 0;
    protected int minLenOfRunway = 0;

    public Air(int power, int maxSpeed, int mass, String brand, int lenOfWings, int minLenOfRunway) {
        super(power,maxSpeed,mass,brand);
        this.lenOfWings = lenOfWings;
        this.minLenOfRunway = minLenOfRunway;
    }
    //нужен ли он здесь?!

    @Override
    public void showAll() {
        super.showAll();
        System.out.println("Count of wheels: "+this.lenOfWings);
        System.out.println("Fuel consumption L/100km: "+this.minLenOfRunway);
    }

}
