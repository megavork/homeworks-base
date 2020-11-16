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
        super.showAll();
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
