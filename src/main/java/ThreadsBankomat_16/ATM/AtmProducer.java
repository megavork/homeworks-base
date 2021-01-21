package ThreadsBankomat_16.ATM;

import ThreadsBankomat_16.ByCard.ByCard;
import ThreadsBankomat_16.Checker.TimeMoneyChecker;

import java.util.Random;
import java.util.function.Predicate;

public class AtmProducer implements Runnable {

    Random rand = new Random();
    ByCard card;
    private int currentStateOfMoney = 0;

    Predicate<Integer> isBiggerThen1000 = x -> x > TimeMoneyChecker.getMaxMoneyStates();
    Predicate<Integer> isLessOrEquals0 = x -> x <= TimeMoneyChecker.getMinMoneyStates();

    public AtmProducer(ByCard card) {
        this.card = card;
    }

    private void needToSleep() {
        long time = TimeMoneyChecker.getTimeToSleep();
        try {
            Thread.sleep(time);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

    private boolean isLessThousandAndBiggerZero() {
        if (!isBiggerThen1000.test(card.getCurrentMoney()) && !isLessOrEquals0.test(card.getCurrentMoney()))
            return false;
        else
            return true;
    }

    @Override
    public void run() {

        int moneyToIncrease = TimeMoneyChecker.getMoneyForOperation();

        while (!card.isDone()) {          //пока средств достаточно

            synchronized (card) {
                if (!Thread.currentThread().isInterrupted() && !card.isDone()) {
                    currentStateOfMoney = card.getCurrentMoney() + moneyToIncrease;
                    card.setCurrentMoney(currentStateOfMoney);
                    System.out.println(this.hashCode() + ": Was decreased to: " + currentStateOfMoney);

                    if (isLessThousandAndBiggerZero()) {
                        card.setIsDone(true);
                    }
                }
            }
            needToSleep();
        }
        Thread.currentThread().interrupt();

    }
}
