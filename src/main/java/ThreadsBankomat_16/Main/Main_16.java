package ThreadsBankomat_16.Main;

import ThreadsBankomat_16.ATM.*;
import ThreadsBankomat_16.ByCard.ByCard;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class Main_16 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Random rand = new Random();

        Predicate<Integer> isEquals1000 = x -> x > 510;
        Predicate<Integer> isLessOrEquals0 = x -> x <= 490;

        long countAtm = (rand.nextInt(4)) + 2;    //генерируем число банкоматов от 2 до 5
        System.out.println(countAtm);

        while (countAtm > 0) {
            service.submit(new AtmProducer());
            service.submit(new AtmConsumer());

            System.out.println(ByCard.getMoney() + " on card.");
            countAtm--;
        }
        while (!isEquals1000.test(ByCard.getMoney()) &&
                !isLessOrEquals0.test(ByCard.getMoney())) {

        }

        service.shutdownNow();
        System.out.println("ShutDown");
        System.out.println("Money on card = " + ByCard.getMoney());
        try {
            service.shutdownNow();
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException ex) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Money on card = " + ByCard.getMoney());
        }

    }
}
