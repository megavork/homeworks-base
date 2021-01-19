package BELSKI_home_7_interface.Robot.classes.main;

import BELSKI_home_7_interface.Robot.classes.Samsung.SamsungHand;
import BELSKI_home_7_interface.Robot.classes.Samsung.SamsungLeg;
import BELSKI_home_7_interface.Robot.classes.Sony.SonyHand;
import BELSKI_home_7_interface.Robot.classes.Sony.SonyHead;
import BELSKI_home_7_interface.Robot.classes.Toshiba.ToshibaHead;
import BELSKI_home_7_interface.Robot.classes.Toshiba.ToshibaLeg;

public class Run {
    public static void main(String[] args) {
        Robot robot_1 = new Robot();
        robot_1.setHand(new SonyHand(1500));
        robot_1.setHead(new ToshibaHead(4205));
        robot_1.setLeg(new SamsungLeg(1671));
        robot_1.action();
        System.out.println("Robot_1 - " + robot_1.getPrice());
        System.out.println();

        Robot robot_2 = new Robot();
        robot_2.setHand(new SamsungHand(2370));
        robot_2.setHead(new SonyHead(9802));
        robot_2.setLeg(new ToshibaLeg(4821));
        robot_2.action();
        System.out.println("Robot_2 - " + robot_2.getPrice());
        System.out.println();

        Robot robot_3 = new Robot();
        robot_3.setHand(new SamsungHand(3467));
        robot_3.setHead(new SonyHead(7345));
        robot_3.setLeg(new ToshibaLeg(5658));
        robot_3.action();
        System.out.println("Robot_3 - " + robot_3.getPrice());
        System.out.println();

        if (robot_1.getPrice() > robot_2.getPrice() && robot_1.getPrice() > robot_3.getPrice()) {
            System.out.println("Robot_1 have the biggest price.");
        } else if (robot_2.getPrice() > robot_1.getPrice() && robot_2.getPrice() > robot_3.getPrice()) {
            System.out.println("Robot_2 have the biggest price.");
        } else {
            System.out.println("Robot_3 have the biggest price.");
        }
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */


    }
}
