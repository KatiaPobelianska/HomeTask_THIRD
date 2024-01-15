package homeTask20231219.task2;

import java.util.concurrent.atomic.AtomicLong;

public class UniqueIdGenerator {
    private static final ThreadLocal<AtomicLong> uniqueIdCounter = ThreadLocal.withInitial(() -> new AtomicLong(1));

    public static long generateUniqueId() {
        return uniqueIdCounter.get().getAndIncrement();
    }
}
