package homeTask20231219.task3;
/*3 В интернет-магазине есть два процесса: обработка заказов и доставка товаров.
На фоне обработки заказов, нужно периодически планировать доставку готовых товаров.
Разработайте программу, используя ThreadPoolExecutor и ScheduledThreadPoolExecutor,
чтобы эффективно управлять обработкой заказов и доставкой.*/
public class OrderProcessingTask implements Runnable{
    private final String orderId;

    public OrderProcessingTask(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("Processing order: " + orderId);
        sendConfirmationToCustomer(orderId);
    }

    private void sendConfirmationToCustomer(String orderId) {
        System.out.println("Confirmation email sent to customer for order: " + orderId);
    }
}
