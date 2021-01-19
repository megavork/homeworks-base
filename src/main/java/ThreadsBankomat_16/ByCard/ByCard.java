package ThreadsBankomat_16.ByCard;

public class ByCard {

    private static int money = 500;
    private static boolean isDone = false;

    public static synchronized int getMoney() {
        return money;
    }

    public static synchronized void setMoney(int money) {
        ByCard.money = money;
    }

    public static boolean isIsDone() {
        return isDone;
    }

    public static void setIsDone(boolean isDone) {
        ByCard.isDone = isDone;
    }
}
