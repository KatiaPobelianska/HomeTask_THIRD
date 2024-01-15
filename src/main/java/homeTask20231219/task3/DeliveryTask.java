package homeTask20231219.task3;

public class DeliveryTask implements Runnable{
    private final String orderId;

    public DeliveryTask(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("Delivering order: " + orderId);
        deliverOrder(orderId);
    }

    private void deliverOrder(String orderId) {
        System.out.println("Order delivered: " + orderId);
    }
}
