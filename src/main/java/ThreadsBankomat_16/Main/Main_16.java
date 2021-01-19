package ThreadsBankomat_16.Main;

import ThreadsBankomat_16.ATM.*;
import ThreadsBankomat_16.ByCard.ByCard;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main_16 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Random rand = new Random();

        ArrayList<Future> threadsList = new ArrayList<>();

        long countAtm = (rand.nextInt(4)) + 2;    //генерируем число банкоматов от 2 до 5
        System.out.println(countAtm);

        while (countAtm > 0) {
            threadsList.add(service.submit(new AtmProducer()));
            threadsList.add(service.submit(new AtmConsumer()));

            System.out.println(ByCard.getMoney() + " on card.");
            countAtm--;
        }

        while (!threadsList.stream().anyMatch(future -> future.isDone())) {
            //???????????????????????????????????
            //активное ожидание - говно
        }

        if (threadsList.stream().anyMatch(future -> future.isDone())) {

            System.out.println("ShutDown");
            System.out.println("Money on card = " + ByCard.getMoney());

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

        System.out.println("Last Money on card = " + ByCard.getMoney());

    }
}
