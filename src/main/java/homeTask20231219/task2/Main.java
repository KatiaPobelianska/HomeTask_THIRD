package homeTask20231219.task2;

public class Main {
    public static void main(String[] args) {
        ClientId clientId1 = new ClientId();
        ProductId productId1 = new ProductId();
        TaskId taskId1 = new TaskId();

        ClientId clientId2 = new ClientId();
        ProductId productId2 = new ProductId();
        TaskId taskId2 = new TaskId();

        System.out.println("Client ID 1: " + clientId1.getId());
        System.out.println("Product ID 1: " + productId1.getId());
        System.out.println("Task ID 1: " + taskId1.getId());

        System.out.println("Client ID 2: " + clientId2.getId());
        System.out.println("Product ID 2: " + productId2.getId());
        System.out.println("Task ID 2: " + taskId2.getId());
    }
}
