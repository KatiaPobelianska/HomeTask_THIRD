package homeTask20231221.task2;

public class DatabaseAccessExample {
    public static void main(String[] args) {
        Database database = new Database();
        for (int i = 1; i <= 5; i++) {
            final int threadId = i;
            new Thread(() -> {
                database.writeToDatabase("Data from Thread " + threadId, threadId);
            }).start();
        }
    }
}
