package homeTask20231219.task2;

public class ProductId {
    private final long id;

    public ProductId() {
        this.id = UniqueIdGenerator.generateUniqueId();
    }

    public long getId() {
        return id;
    }
}
