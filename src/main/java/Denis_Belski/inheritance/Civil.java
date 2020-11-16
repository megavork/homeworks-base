package Denis_Belski.inheritance;
//гражданский
public class Civil extends  Air{
    private int countOfPeople = 0;
    private boolean isBusinessClass = false;

    public Civil(int power, int maxSpeed, int mass, String brand, int lenOfWings,
                 int minLenOfRunway, int countOfPeople, boolean isBusinessClass) {
        super(power,maxSpeed,mass,brand,lenOfWings,minLenOfRunway);
        this.countOfPeople = countOfPeople;
        this.isBusinessClass = isBusinessClass;
    }

    @Override
    public void showAll() {
        super.showAll();
        System.out.println("Count of people: "+this.countOfPeople);
        System.out.println("Is business class: "+this.isBusinessClass);
    }

    public void checkFreeSpace(int workload) {
        if(workload < this.countOfPeople) {
            System.out.println("The plane is loaded.");
        } else {
            System.out.println("You should use bigger plane.");
        }
    }
}
