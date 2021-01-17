package ATM;

import ByCard.ByCard;

import java.util.Random;
import java.util.function.Predicate;

public class AtmConsumer implements Runnable{
    int money;

    Random rand = new Random();

    Predicate<Integer> isEquals1000 = x -> x > 520;
    Predicate<Integer> isLessOrEquals0 = x -> x <= 490;


    @Override
    public void run() {

        while (!isEquals1000.test(ByCard.getMoney()) &&
                !isLessOrEquals0.test(ByCard.getMoney())) {          //пока средств мешьне 1000

            long time = (rand.nextInt(4) ) +2;    //генерируем число секунд от 2 до 5
            int moneys = (rand.nextInt(6) ) +5;   //генерируем количество средств от 5 до 10

            this.money = ByCard.getMoney() - moneys;
            ByCard.setMoney(this.money);

            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {

            }
            if(!isEquals1000.test(ByCard.getMoney()) &&
                    !isLessOrEquals0.test(ByCard.getMoney())) {
                System.out.println(ByCard.getMoney() + " on card before.");
                System.out.println(this.hashCode() + ": Was increased: " + this.money);
            }
        }
        Thread.currentThread().interrupt();
    }
}
