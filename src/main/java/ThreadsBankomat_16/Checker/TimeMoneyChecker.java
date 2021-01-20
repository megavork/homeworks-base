package ThreadsBankomat_16.Checker;

import java.util.Random;

public class TimeMoneyChecker {
    final public static int MAX_MONEY_STATES = 510;
    final public static int MIN_MONEY_STATES = 490;

    final public static int INITIAL_MONEY_STATES = 500;

    final private static int MAX_TIME_TO_SLEEP = 5;
    final private static int MIN_TIME_TO_SLEEP = 2;

    final public static int MAX_MONEY_ON_OPERATION = 10;
    final public static int MIN_MONEY_ON_OPERATION = 5;

    private static final Random rand = new Random();

    /**
     * return time in MILLISECONDS
     *
     * @return
     */
    public static long getTimeToSleep() {//генерируем число секунд от 2 до 5
        long time = (rand.nextInt(MAX_TIME_TO_SLEEP - MIN_TIME_TO_SLEEP + 1)) + MIN_TIME_TO_SLEEP;
        time *= 1000;   //convert to milliseconds
        return time;
    }

    public static int getInitialMoney() {
        return INITIAL_MONEY_STATES;
    }

    public static int getMoneyForOperation() {
        int money = (rand.nextInt(MAX_MONEY_ON_OPERATION - MIN_MONEY_ON_OPERATION + 1)) + MIN_MONEY_ON_OPERATION;
        return money;
    }

    public static int getMaxMoneyStates() {
        return MAX_MONEY_STATES;
    }

    public static int getMinMoneyStates() {
        return MIN_MONEY_STATES;
    }
}
