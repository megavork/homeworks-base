package ByCard;

public class ByCard {

    private static int money = 500;

    public static synchronized int getMoney() {
        return money;
    }

    public static synchronized void setMoney(int money) {
        ByCard.money = money;
    }
}
