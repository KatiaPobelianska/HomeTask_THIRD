package homeTask20231221.next;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread producerThread = new Thread(new DataProducer(exchanger));
        Thread consumerThread = new Thread(new DataConsumer(exchanger));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
