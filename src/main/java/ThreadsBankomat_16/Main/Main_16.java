package ThreadsBankomat_16.Main;

import ThreadsBankomat_16.ATM.*;
import ThreadsBankomat_16.ByCard.ByCard;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class Main_16 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Random rand = new Random();
        ByCard card = new ByCard();

        ArrayList<Future> threadsList = new ArrayList<>();

        long countAtm = (rand.nextInt(4)) + 2;    //генерируем число банкоматов от 2 до 5
        System.out.println(countAtm);

        System.out.println(card.getCurrentMoney() + " on card.");

        while (countAtm > 0) {
            threadsList.add(service.submit(new AtmProducer(card)));
            threadsList.add(service.submit(new AtmConsumer(card)));
            countAtm--;
        }

        for (Future<?> future : threadsList) {
            try {
                future.get();
            } catch ( ExecutionException e ) {
                e.printStackTrace();
            }
        }

        if (threadsList.stream().anyMatch(future -> future.isDone())) {

            System.out.println("ShutDown");
            System.out.println("Money on card = " + card.getCurrentMoney());

            try {
                service.shutdownNow();
                if (!service.awaitTermination(20, TimeUnit.SECONDS)) {
                    service.shutdownNow();
                }
            } catch ( InterruptedException ex ) {
                service.shutdownNow();
                Thread.currentThread().interrupt();

            }
        }

        System.out.println("Last Money on card = " + card.getCurrentMoney());

    }
}
