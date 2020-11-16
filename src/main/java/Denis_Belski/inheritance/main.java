package Denis_Belski.inheritance;

public class main {
    public static void main(String[] args) {
        Automobile car = new Automobile(123,240,1750,"Volvo",
                4,12,"Air", 5);
        car.showAll();
            System.out.println();
        car.distanceOfTime(5);
            System.out.println();

        Cargo cargo = new Cargo(278,120,3567,"Kamaz",6,10,5780);
        cargo.showAll();
            System.out.println();
        cargo.checkFreeSpace(200);
            System.out.println();

        Civil civil = new Civil(980,320,9761,"Aerobus",20, 2430, 126, true);
        civil.showAll();
            System.out.println();
        civil.checkFreeSpace(140);
            System.out.println();

        Military military = new Military(1280,485,11761,"Boing",27, 3081, 3, true);
        military.showAll();
            System.out.println();
        military.checkEjection();
            System.out.println();
        military.checkShot();
        military.checkShot();
        military.checkShot();
        military.checkShot();
    }
}



//какая реализация будет более понятной и уместной. Слишком большие параметры для конструкторов!