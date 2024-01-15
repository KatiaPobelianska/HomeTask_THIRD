package homeTask20231219.task1;

public class MainClass {
    public static void main(String[] args) {
        Document document = new Document();
        User user1 = new User("Misha", document);
        User user2 = new User("Viki", document);
        User user3 = new User("Anna", document);

        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user2);
        Thread thread3 = new Thread(user3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
