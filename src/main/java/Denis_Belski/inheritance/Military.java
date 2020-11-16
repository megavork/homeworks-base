package Denis_Belski.inheritance;

public class Military extends Air{
    private boolean isEjectSystem = false;
    private int countOfRocket = 0;

    private int currentCountOfShots = 0;

    public Military(int power, int maxSpeed, int mass, String brand, int lenOfWings,
                 int minLenOfRunway, int countOfRocket, boolean isEjectSystem) {
        super(power,maxSpeed,mass,brand,lenOfWings,minLenOfRunway);
        this.countOfRocket = countOfRocket;
        this.isEjectSystem = isEjectSystem;
    }

    @Override
    public void showAll() {
        super.showAll();
        System.out.println("Is eject system: "+this.isEjectSystem);
        System.out.println("Count of rocket: "+this.countOfRocket);
    }

    public void checkShot() {
        if(currentCountOfShots < countOfRocket) {
            System.out.println("The rocket is launched.");
            currentCountOfShots++;
        } else {
            System.out.println("No ammunition.");
            currentCountOfShots = 0;
        }
    }

    public void checkEjection() {
        if(isEjectSystem) {
            System.out.println("The ejection was successful.");
            isEjectSystem = false;
        } else {
            System.out.println("You don't have such a system.");
        }
    }
}
