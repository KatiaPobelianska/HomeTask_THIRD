package homeTask20231219.task3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainStore {
    public static void main(String[] args) {
            ThreadPoolExecutor orderProcessingExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

            ScheduledExecutorService deliveryScheduler = Executors.newScheduledThreadPool(2);

            for (int i = 1; i <= 10; i++) {
                String orderId = "Order-" + i;
                OrderProcessingTask orderProcessingTask = new OrderProcessingTask(orderId);
                orderProcessingExecutor.execute(orderProcessingTask);

                DeliveryTask deliveryTask = new DeliveryTask(orderId);
                deliveryScheduler.schedule(deliveryTask, 2, TimeUnit.SECONDS);
            }

            orderProcessingExecutor.shutdown();
            while (!orderProcessingExecutor.isTerminated()) {
            }

            deliveryScheduler.shutdown();
        }
    }

