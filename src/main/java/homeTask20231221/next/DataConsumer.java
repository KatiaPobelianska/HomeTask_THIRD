package homeTask20231221.next;

import java.util.concurrent.Exchanger;

public class DataConsumer implements Runnable{
    private final Exchanger<String> exchanger;

    public DataConsumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String receivedData = exchanger.exchange(null);
                System.out.println("Consumer received data: " + receivedData);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
