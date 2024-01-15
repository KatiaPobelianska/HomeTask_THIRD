package homeTask20231221.task2;

import java.util.concurrent.Semaphore;
/*2.1 В компании есть база данных, и несколько потоков пытаются одновременно записать
данные в эту базу. Чтобы избежать коллизий при одновременной записи, используйте Semaphore,
чтобы ограничить доступ к базе одновременно только нескольким потокам.*/
public class Database {
    private Semaphore semaphore = new Semaphore(3);

    public void writeToDatabase(String data, int threadId) {
        try {
            semaphore.acquire();
            System.out.println("Thread " + threadId + " is writing to the database: " + data);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("Thread " + threadId + " released the database lock.");
        }
    }
}

