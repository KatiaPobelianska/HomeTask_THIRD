package homeTask20231221.next;

import java.util.concurrent.Exchanger;

/*2.4 Есть два потока, один из которых генерирует данные, а другой их обрабатывает.
Используйте Exchanger, чтобы потоки могли обмениваться данными*/
public class DataProducer implements Runnable{
    private final Exchanger<String> exchanger;

    public DataProducer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String data = "Data from Producer - " + i;
                System.out.println("Producer is generating data: " + data);
                exchanger.exchange(data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
