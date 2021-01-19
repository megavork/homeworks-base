package ThreadsBankomat_16.ATM;

import ThreadsBankomat_16.ByCard.ByCard;
import java.util.Random;
import java.util.function.Predicate;

public class AtmProducer implements Runnable {

    Random rand = new Random();

    Predicate<Integer> isLessThen1000 = x -> x > 1000;
    Predicate<Integer> isLessOrEquals0 = x -> x <= 0;

    private void needToSleep() {
        long time = (rand.nextInt(4)) + 2;    //генерируем число секунд от 2 до 5
        try {
            Thread.sleep(time * 1000);
        } catch ( InterruptedException e ) {

        }
    }

    @Override
    public void run() {

        int moneys = (rand.nextInt(6)) + 5;   //генерируем количество средств от 5 до 10

        while (!isLessThen1000.test(ByCard.getMoney()) &&
                !isLessOrEquals0.test(ByCard.getMoney())) {          //пока средств мешьне 1000

            needToSleep();

            System.out.println(ByCard.getMoney() + " on card before.");

            if (!Thread.currentThread().isInterrupted() && !ByCard.isIsDone()) {
                ByCard.setMoney(ByCard.getMoney() + moneys);
                System.out.println(this.hashCode() + ": Was increased: " + ByCard.getMoney());
            }
        }
        try {
            ByCard.setIsDone(true);
            Thread.currentThread().notifyAll();
            Thread.currentThread().interrupt();
            Thread.currentThread().wait();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
}
